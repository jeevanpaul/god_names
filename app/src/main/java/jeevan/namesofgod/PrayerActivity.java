package jeevan.namesofgod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PrayerActivity extends TestingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inflator_layout_resource = R.layout.activity_prayer;
        super.onCreate(savedInstanceState);
        setTitle(mPlanetTitles.get(1));
    }
}
