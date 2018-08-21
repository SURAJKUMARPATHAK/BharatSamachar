package com.my.bharatsamachar.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.my.bharatsamachar.R;
import com.my.bharatsamachar.fragment.FavouriteFragment;
import com.my.bharatsamachar.fragment.HomeFragment;
import com.my.bharatsamachar.fragment.KaryakaramFragment;
import com.my.bharatsamachar.fragment.LiveTvFragment;
import com.my.bharatsamachar.fragment.NotificationFragment;
import com.my.bharatsamachar.fragment.PhotoFragment;
import com.my.bharatsamachar.fragment.PlaylistFragment;
import com.my.bharatsamachar.fragment.RateFragment;
import com.my.bharatsamachar.fragment.ReadOFFlineFragment;
import com.my.bharatsamachar.fragment.SectionFragment;
import com.my.bharatsamachar.fragment.SettingsFragment;
import com.my.bharatsamachar.fragment.ShareAppFragment;
import com.my.bharatsamachar.fragment.VedioFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab,fab1,fab2;
    Animation fabOpen ,fabClosed, rotateForward,rotateBackward;
    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab=findViewById(R.id.fab);
        fab1=findViewById(R.id.fab1);
        fab2=findViewById(R.id.fab2);
        fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_button);
        fabClosed=AnimationUtils.loadAnimation(this,R.anim.fab_button_closed);
        rotateForward=AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward= AnimationUtils.loadAnimation(this,R.anim.rotate_backward);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snack =   Snackbar.make(view, "Call/Whatsapp to BharatSamachar ", Snackbar.LENGTH_LONG);
                ViewGroup group = (ViewGroup) snack.getView();
                group.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
                snack.setAction("Action", null).show();

                animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + "7892209484");
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                Toast.makeText(MainActivity.this, "You are sending message to BharatSamachar..", Toast.LENGTH_SHORT).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7892209484"));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Calling BharatSamachet", Toast.LENGTH_SHORT).show();

            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.screen_area, new HomeFragment()).addToBackStack(null).commit();
    }

    private void animateFab() {
        if (isOpen){
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClosed);
            fab2.startAnimation(fabClosed);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }else {
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.LiveTv) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://aajtak.intoday.in/livetv.html"));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment=null;
        int id = item.getItemId();

        if (id == R.id.Home) {
            Fragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area, homeFragment).commit();
        } else if (id == R.id.LiveTv) {
            Fragment liveFragment =new LiveTvFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        } else if (id == R.id.Photo) {
            Fragment photoFragment =new PhotoFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,photoFragment).commit();
        } else if (id == R.id.Vedio) {
            Fragment liveFragment =new VedioFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        } else if (id == R.id.Section) {
            Fragment liveFragment =new SectionFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        } else if (id == R.id.Karyakarm) {
            Fragment liveFragment =new KaryakaramFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.Playlist) {
            Fragment liveFragment =new PlaylistFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.Favourite) {
            Fragment liveFragment =new FavouriteFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.ReadOffline) {
            Fragment liveFragment =new ReadOFFlineFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.Notification) {
            Fragment liveFragment =new NotificationFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.RateApp) {
            Fragment liveFragment =new RateFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.ShareApp) {
            Fragment liveFragment =new ShareAppFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }
        else if (id == R.id.Settings) {
            Fragment liveFragment =new SettingsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area ,liveFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
