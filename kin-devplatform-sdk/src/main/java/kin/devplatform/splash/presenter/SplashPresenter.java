package kin.devplatform.splash.presenter;

import androidx.annotation.NonNull;

import kin.devplatform.KinCallback;
import kin.devplatform.base.BasePresenter;
import kin.devplatform.bi.EventLogger;
import kin.devplatform.bi.events.BackButtonOnWelcomeScreenPageTapped;
import kin.devplatform.bi.events.WelcomeScreenButtonTapped;
import kin.devplatform.bi.events.WelcomeScreenPageViewed;
import kin.devplatform.data.auth.AuthDataSource;
import kin.devplatform.exception.KinEcosystemException;
import kin.devplatform.splash.view.ISplashView;

public class SplashPresenter extends BasePresenter<ISplashView> implements ISplashPresenter {

	private final AuthDataSource authRepository;
	private final EventLogger eventLogger;

	private boolean animationEnded = false;
	private boolean confirmedSucceed = false;

	public SplashPresenter(@NonNull final AuthDataSource authRepository, @NonNull EventLogger eventLogger) {
		this.authRepository = authRepository;
		this.eventLogger = eventLogger;
	}

	@Override
	public void onAttach(ISplashView view) {
		super.onAttach(view);
		this.eventLogger.send(WelcomeScreenPageViewed.create());
	}

	@Override
	public void getStartedClicked() {
		eventLogger.send(WelcomeScreenButtonTapped.create());
		animateLoading();
		activateAccount();
	}

	private void animateLoading() {
		if (view != null) {
			view.animateLoading();
		}
	}

	private void activateAccount() {
		authRepository.activateAccount(new KinCallback<Void>() {
			@Override
			public void onResponse(Void response) {
				confirmedSucceed = true;
				navigateToMarketplace();
			}

			@Override
			public void onFailure(KinEcosystemException exception) {
				showToast("Oops something went wrong...");
				stopLoading(true);
			}
		});
	}

	private void stopLoading(boolean reset) {
		if (view != null) {
			view.stopLoading(reset);
		}
	}

	private void showToast(String msg) {
		if (view != null) {
			view.showToast(msg);
		}
	}

	private void navigateToMarketplace() {
		if (animationEnded && confirmedSucceed) {
			if (view != null) {
				view.navigateToMarketPlace();
			}
		}
	}

	@Override
	public void backButtonPressed() {
		eventLogger.send(BackButtonOnWelcomeScreenPageTapped.create());
		if (view != null) {
			view.navigateBack();
		}
	}

	@Override
	public void onAnimationEnded() {
		animationEnded = true;
		navigateToMarketplace();
	}
}
