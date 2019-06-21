package kin.devplatform.data.settings;

import androidx.annotation.NonNull;

public class SettingsDataSourceImpl implements SettingsDataSource {

	private final SettingsDataSource.Local local;

	public SettingsDataSourceImpl(@NonNull final SettingsDataSource.Local local) {
		this.local = local;
	}

	@Override
	public void setIsBackedUp(boolean isBackedUp) {
		local.setIsBackedUp(isBackedUp);
	}

	@Override
	public boolean isBackedUp() {
		return local.isBackedUp();
	}
}
