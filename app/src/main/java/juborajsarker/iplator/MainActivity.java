package juborajsarker.iplator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5809082953640465/2169308832");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("2BA46C54FD47FD80CBBAD95AE0F70E1A").build();
        mAdView.loadAd(adRequest);






    }

    public void home_activity_open(View view) {

        startActivity(new Intent(MainActivity.this, HomeActivity.class));

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.about_me, menu);
        return true;
    }


    public void aboutMe(MenuItem item) {

        Intent about_me = new Intent(MainActivity.this, AboutMeActivity.class);
        startActivity(about_me);
    }
}
