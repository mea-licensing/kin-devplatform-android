package kin.devplatform.data.offer;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;
import kin.devplatform.core.network.ApiCallback;
import kin.devplatform.core.network.ApiException;
import kin.devplatform.core.util.ExecutorsUtil;
import kin.devplatform.data.Callback;
import kin.devplatform.network.api.OffersApi;
import kin.devplatform.network.model.OfferList;

public class OfferRemoteData implements OfferDataSource.Remote {

	private static volatile OfferRemoteData instance;

	private final OffersApi offersApi;
	private final ExecutorsUtil executorsUtil;

	private OfferRemoteData(@NonNull ExecutorsUtil executorsUtil) {
		this.offersApi = new OffersApi();
		this.executorsUtil = executorsUtil;
	}

	public static OfferRemoteData getInstance(@NonNull ExecutorsUtil executorsUtil) {
		if (instance == null) {
			synchronized (OfferRemoteData.class) {
				if (instance == null) {
					instance = new OfferRemoteData(executorsUtil);
				}
			}
		}
		return instance;
	}

	@Override
	public void getOffers(@NonNull final Callback<OfferList, ApiException> callback) {
		try {
			offersApi.getOffersAsync("", 25, "", "", new ApiCallback<OfferList>() {
				@Override
				public void onFailure(final ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
					executorsUtil.mainThread().execute(new Runnable() {
						@Override
						public void run() {
							callback.onFailure(e);
						}
					});
				}

				@Override
				public void onSuccess(final OfferList result, int statusCode,
					Map<String, List<String>> responseHeaders) {
					executorsUtil.mainThread().execute(new Runnable() {
						@Override
						public void run() {
							callback.onResponse(result);

						}
					});
				}
			});
		} catch (final ApiException e) {
			executorsUtil.mainThread().execute(new Runnable() {
				@Override
				public void run() {
					callback.onFailure(e);
				}
			});
		}
	}
}
