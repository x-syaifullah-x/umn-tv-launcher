package com.umntv.launcher.main;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import media.umn.tv.R;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }

//        JSONObject consentObject = new JSONObject();
//        try {
//            // Provide correct consent value to sdk which is obtained by User
//            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true);
//            // Provide 0 if GDPR is not applicable and 1 if applicable
//            consentObject.put("gdpr", "0");
//            // Provide user consent in IAB format
////            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_IAB, “ << consent in IAB format >> ”);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        InMobiSdk.init(this, "e0fb22098ee14a6aaa803ecb84bc77e1", consentObject, new SdkInitializationListener() {
//            @Override
//            public void onInitializationComplete(@Nullable @org.jetbrains.annotations.Nullable Error error) {
//                if (error != null) {
//                    error.printStackTrace();
//                } else {
//                    InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
//                    InterstitialAdEventListener mInterstitialAdEventListener = new InterstitialAdEventListener() {
//                        @Override
//                        public void onAdLoadSucceeded(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull AdMetaInfo info) {
//                            Log.d("TAG", "Ad can now be shown!");
//                            inMobiInterstitial.show();
//                        }
//
//                        @Override
//                        public void onAdLoadFailed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
//                            super.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
//                            Log.d("TAG", "Ad can now be shown!");
//                        }
//                    };
//
//                    InMobiInterstitial interstitialAd = new InMobiInterstitial(
//                            MainActivity.this,
//                            1680826218142L,
//                            mInterstitialAdEventListener
//                    );
//                }
//            }
//        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        /**/
    }
}