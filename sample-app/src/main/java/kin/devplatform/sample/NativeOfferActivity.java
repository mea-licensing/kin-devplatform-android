package kin.devplatform.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;


public class NativeOfferActivity extends AppCompatActivity {

	private static final String OFFER_NAME_KEY = "offer_name_key";

	public static Intent createIntent(Context context, String offerName) {
		Intent intent = new Intent(context.getApplicationContext(), NativeOfferActivity.class);
		intent.putExtra(OFFER_NAME_KEY, offerName);
		return intent;
	}


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.native_offer_activity);

		String offerName = getIntent().getStringExtra(OFFER_NAME_KEY);
		Toast.makeText(this, offerName + " offer was clicked", Toast.LENGTH_LONG).show();
	}
}
