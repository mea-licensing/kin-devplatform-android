package kin.devplatform.settings.view;

import androidx.annotation.IntDef;
import com.kin.ecosystem.recovery.BackupManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kin.devplatform.base.IBaseView;
import kin.devplatform.settings.presenter.ISettingsPresenter;

public interface ISettingsView extends IBaseView<ISettingsPresenter> {

	int ITEM_BACKUP = 0x00000001;
	int ITEM_RESTORE = 0x00000002;

	void showMigrationStarted();

	void showMigrationError(Exception e);

	void showUpdateWalletAddressFinished(boolean didMigrationStarted);

	void showUpdateWalletAddressError();

	void startWaiting();

	void showUWalletWasNotCreatedInThisAppError();


	@IntDef({ITEM_BACKUP, ITEM_RESTORE})
	@Retention(RetentionPolicy.SOURCE)
	@interface Item {

	}

	int BLUE = 0x00000001;
	int GRAY = 0x00000002;

	@IntDef({BLUE, GRAY})
	@Retention(RetentionPolicy.SOURCE)
	@interface IconColor {

	}


	void navigateBack();

	void setIconColor(@Item final int item, @IconColor final int color);

	void changeTouchIndicatorVisibility(@Item final int item, boolean isVisible);

	BackupManager getBackupManager();

}
