package kin.devplatform.marketplace.view;

import android.telecom.Call;

import java.util.List;
import java.util.concurrent.Callable;

import kin.devplatform.base.IBaseView;
import kin.devplatform.marketplace.presenter.ISpendDialogPresenter;
import kin.devplatform.marketplace.presenter.MarketplacePresenter;
import kin.devplatform.network.model.Offer;
import kin.devplatform.poll.view.PollWebViewActivity.PollBundle;

public interface IMarketplaceView extends IBaseView<MarketplacePresenter> {

	void setSpendList(List<Offer> response);

	void setEarnList(List<Offer> response);

	void showOfferActivity(PollBundle pollBundle);

	void showSpendDialog(ISpendDialogPresenter spendDialogPresenter);

	void showToast(String msg);

	void showOfferConfirmation(Offer offer, Callable onClick);

	void notifyEarnItemRemoved(int index);

	void notifyEarnItemInserted(int index);

	void notifySpendItemRemoved(int index);

	void notifySpendItemInserted(int index);

	void showSomethingWentWrong();

	void updateEarnSubtitle(boolean isEmpty);

	void updateSpendSubtitle(boolean isEmpty);
}