# AdsSdk ||Release date 20-02-2023

How to implement AdsSdk in your project.

********************|| Step 1 ||********************

# Add this line in your gradle.properties.

    android.enableJetifier=true

# Add this to root build.gradle // If you are using a newer version of Android Studio, then add it to settings.gradle

    repositories {
    ...
        maven {
            url "https://jitpack.io"
        }
    }

# Change your sir url by following the class below.

    com.ads.sdk.configs => rootApiBase();

    https://yoursirurl.com/ Replace this string to your sir URL

# Initialize SdkManager in your Application class.

    @Override
    public void onCreate() {
        super.onCreate();
            SdkManager.getInstance().initialize(this, YourLauncherActivity.class);
    }

********************|| Step 2 ||********************

# Extend SplashBaseActivity in your SplashActivity class.

    public class SplashActivity extends SplashBaseActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
    
             loadSplash(BuildConfig.DEBUG, BuildConfig.VERSION_CODE, "1"); //"1" is your app ID
        }
    
        @Override
        public void onComplete() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        }
    }

# Make sure *BuildConfig.DEBUG* import package is your app package name.

********************|| Step 3 ||********************

# Call ads and other settings.

*If you are combining 2 apps in a single app then use the below code.
Example: An application has two modules in which one button open "Gallery" and another button open "
Video Player".

    SdkManager.getInstance().setAppOption(this, binding.btn1, binding.btn2);

*Advertisement

	//For Banner ad
 	    SdkManager.getInstance().loadBanner(MainActivity.this, binding.bannerView);

	//For Native ad
        SdkManager.getInstance().loadNative(MainActivity.this, binding.nativeView, R.drawable.your_app_banner);

	//For Native Banner ad
        SdkManager.getInstance().loadNativeBanner(MainActivity.this, binding.nativeBannerView);

	//For Interstitial ad
        SdkManager.getInstance().showInterstitialAd(MainActivity.this, new OnShowAdCompleteListener() {
            @Override
            public void onShowAdComplete() {
                Toast.makeText(MainActivity.this, "Well done", Toast.LENGTH_SHORT).show();
            }
        });

    //For onBackpress Interstitial ad
        SdkManager.getInstance().showBackPressAd(MainActivity.this, new OnShowAdCompleteListener() {
            @Override
            public void onShowAdComplete() {
                Toast.makeText(MainActivity.this, "Well done", Toast.LENGTH_SHORT).show();
            }
        });

# You can also call all the above ads using XML (Except Interstitial).

    **NOTE: If you use XML code then you don't put anything in java class.

        //For Banner ad
            <com.ads.sdk.views.BannerView
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
    
        //For Native ad
            <com.ads.sdk.views.NativeView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:app_banner="@drawable/your_app_banner"/>
    
        //For Native Banner ad
            <com.ads.sdk.views.NativeBannerView
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />

********************|| Step 4 ||********************

# Add this line in your final exit button click.

    exitButton.setOnClickListener(view -> {
        SdkManager.getInstance().finalExit(MainActivity.this);
    });