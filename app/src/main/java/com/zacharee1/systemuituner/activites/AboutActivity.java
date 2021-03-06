package com.zacharee1.systemuituner.activites;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zacharee1.systemuituner.R;
import com.zacharee1.systemuituner.misc.BillingUtil;
import com.zacharee1.systemuituner.misc.RecreateHandler;

@SuppressWarnings("unused")
public class AboutActivity extends AppCompatActivity
{
    @SuppressWarnings("FieldCanBeLocal")
    private static boolean DARK = false;
    private BillingUtil mBilling;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        DARK = sharedPreferences.getBoolean("dark_mode", false);

        setTheme(DARK ? R.style.AppTheme_Dark : R.style.AppTheme);

        RecreateHandler.onCreate(this);

        setContentView(R.layout.activity_about);

        mBilling = new BillingUtil(this);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView appCred = findViewById(R.id.app_credit);
        TextView appSpanishCred = findViewById(R.id.spanish_lang_credit);
        TextView appChineseCred = findViewById(R.id.chinese_lang_credit);

        appCred.setMovementMethod(LinkMovementMethod.getInstance());
        appSpanishCred.setMovementMethod(LinkMovementMethod.getInstance());
        appChineseCred.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        RecreateHandler.onDestroy(this);
        super.onDestroy();
    }

    public void onDonatePayPalClicked(View v) {
        BillingUtil.onDonatePayPalClicked(this);
    }

    public void onDonate1Clicked(View v) {
        mBilling.onDonateClicked("donate_1");
    }

    public void onDonate2Clicked(View v) {
        mBilling.onDonateClicked("donate_2");
    }

    public void onDonate5Clicked(View v) {
        mBilling.onDonateClicked("donate_5");
    }

    public void onDonate10Clicked(View v) {
        mBilling.onDonateClicked("donate_10");
    }
}
