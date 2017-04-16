package jeevan.namesofgod;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestingActivity extends AppCompatActivity {

    public List<String> mPlanetTitles = new ArrayList<String>(Arrays.asList("Names of God", "Prayer", "Encouragement"));
    public DrawerLayout mDrawerLayout;
    public ListView mDrawerList;
    public int inflator_layout_resource = -1;
    public View inflated_content_root_view;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar myToolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        LinearLayout main_content = (LinearLayout)findViewById(R.id.main_content);
        if(inflator_layout_resource!=-1) {
            inflated_content_root_view = getLayoutInflater().inflate(inflator_layout_resource,main_content, true);
        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        /*mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, mPlanetTitles));*/
        // Set the list's click listener
       // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        /*mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Selected Item: "+ mPlanetTitles.get(position), Toast.LENGTH_LONG).show();
                mDrawerList.setItemChecked(position, true);
                setTitle(mPlanetTitles.get(position));
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });*/

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,
                myToolbar,/* DrawerLayout object */
                R.string.open_drawer,/* "open drawer" description */
                R.string.close_drawer/* "close drawer" description */
        );
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_slideshow);  // Replace with your icon
        //myToolbar.setNavigationIcon(R.drawable.ic_menu_gallery);
        ((LinearLayout) findViewById(R.id.names_of_god)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_activity = getCurrentActivity();
                if(current_activity != "MainActivity")
                    startActivity(new Intent(TestingActivity.this, MainActivity.class));
                mDrawerLayout.closeDrawers();
            }
        });

        ((LinearLayout) findViewById(R.id.prayer)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_activity = getCurrentActivity();
                if(current_activity != "PrayerActivity")
                    startActivity(new Intent(TestingActivity.this, PrayerActivity.class));
                mDrawerLayout.closeDrawers();
            }
        });

        ((LinearLayout) findViewById(R.id.encouragement)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTitle(mPlanetTitles.get(2));
                mDrawerLayout.closeDrawers();
            }
        });

    }

    public String getCurrentActivity() {
        if(inflator_layout_resource == R.layout.activity_main)
            return "MainActivity";
        else
            return "PrayerActivity";
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Toast.makeText(getApplicationContext(), "Hamdled: ", Toast.LENGTH_LONG).show();
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
}
