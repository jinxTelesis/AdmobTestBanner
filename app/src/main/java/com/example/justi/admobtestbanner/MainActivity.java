package com.example.justi.admobtestbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //NOTES
        //Need to make an admob account, search google admob
        //or go to https://admob.google.com/home/
        //Turn off adblockers or they will blow up the site
        //Once created and signed in, click apps to add the app
        //Select Banner when making the ad
        //Name the banner under Ad unit name, then create
        //Will give a code for an app ID and a Banner ID (might be called ad id i forget)

        //One implementation in the gradle module app (play services ads one)
        //Need 2 permissions that are in the manifest file (internet and access network state)
        //Need Metadata line in the manifest, this contains the APP id, the long ca-app-pub code is the app ID code
        //Current code is a testing purposes code that can be used for simple hello world tests

        //context, then APP ID as a string given from admob goes here in the initialize
        //The string here is a testing purposes string that is useful for hello world tests
        //Ad unit ID goes in the xml code for the banner
        //current xml unit ID is once again a hello world testing purposes string
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.banner_add);

        //Note the line below is how you normally build it
        //AdRequest adRequest = new AdRequest.Builder().build();

        //This line with addTestDevice is for testing with an emulator, can change to the phones id if testing with an actual phone
        //you would remove the add test device and use the above when not testing
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);

    }
}
