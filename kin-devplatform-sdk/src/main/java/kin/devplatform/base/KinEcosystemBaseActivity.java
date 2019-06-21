package kin.devplatform.base;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import kin.devplatform.KinEcosystemInitiator;

public abstract class KinEcosystemBaseActivity extends AppCompatActivity {

	protected abstract @LayoutRes
	int getLayoutRes();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutRes());
		KinEcosystemInitiator.getInstance().internalInit(this);
	}
}
