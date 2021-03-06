package kin.devplatform.marketplace.view;

import static kin.devplatform.core.util.DensityDpi.XXHDPI;
import static kin.devplatform.core.util.StringUtil.getAmountFormatted;

import android.content.Context;
import androidx.annotation.LayoutRes;
import android.view.View;
import kin.devplatform.R;
import kin.devplatform.base.AbstractBaseViewHolder;
import kin.devplatform.base.BaseRecyclerAdapter;
import kin.devplatform.core.util.DeviceUtils;
import kin.devplatform.marketplace.view.OfferRecyclerAdapter.ViewHolder;
import kin.devplatform.network.model.Offer;
import kin.devplatform.network.model.Offer.ContentTypeEnum;
import kin.devplatform.network.model.Offer.OfferType;

class OfferRecyclerAdapter extends BaseRecyclerAdapter<Offer, ViewHolder> {

	private static final float NORMAL_WIDTH_RATIO = 0.38f;
	private static final float NORMAL_HEIGHT_RATIO = 0.25f;
	private static final float HIGH_RES_HEIGHT_RATIO = 0.28f;

	private static final String KIN = " Kin";

	protected float getImageWidthRatio() {
		return NORMAL_WIDTH_RATIO;
	}

	protected float getImageHeightRatio() {
		return DeviceUtils.isDensity(XXHDPI) ? HIGH_RES_HEIGHT_RATIO : NORMAL_HEIGHT_RATIO;
	}

	OfferRecyclerAdapter(@LayoutRes int layoutResID) {
		super(layoutResID);
	}

	@Override
	protected void convert(ViewHolder holder, Offer item) {
		holder.bindObject(item);
	}

	@Override
	protected ViewHolder createBaseViewHolder(View view) {
		return new ViewHolder(view);
	}

	class ViewHolder extends AbstractBaseViewHolder<Offer> {

		private int imageWidth;
		private int imageHeight;

		ViewHolder(View item_root) {
			super(item_root);
			getView(R.id.title);
			getView(R.id.sub_title);
			getView(R.id.amount_text);
			setViewSize(R.id.image, imageWidth, imageHeight);
		}

		@Override
		protected void init(Context context) {
			imageWidth = (int) (DeviceUtils.getScreenWidth() * getImageWidthRatio());
			imageHeight = (int) (DeviceUtils.getScreenWidth() * getImageHeightRatio());
		}

		@Override
		protected void bindObject(final Offer item) {
			setImageUrlResized(R.id.image, item.getImage(), imageWidth, imageHeight);
			setText(R.id.title, item.getTitle());
			setText(R.id.sub_title, item.getDescription());
			setAmountText(item);

			if (item.getOfferType() == OfferType.EARN && item.getContentType() == ContentTypeEnum.POLL) {
				setOnItemClickListener(getOnItemClickListener());
			}
		}

		private void setAmountText(final Offer item) {
			int amount = item.getAmount();
			if (item.getOfferType() == OfferType.EARN) {
				setText(R.id.amount_text, "+" + getAmountFormatted(amount) + KIN);
			} else {
				setText(R.id.amount_text, getAmountFormatted(amount) + KIN);
			}
		}
	}
}
