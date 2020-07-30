package com.dbmssema.navigationdr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);
        bottomNavigationView=findViewById(R.id.bottomnavigation);


        setupdraw();
        setbottomnav();
    }

    private void setbottomnav() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.share:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new BookmarksFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.home:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new MomentsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.settings:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new SettingsAndPrivacyFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void setupdraw() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_profile:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new ProfileFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.menu_lists:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new ListsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.menu_settings:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new SettingsAndPrivacyFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.menu_topics:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new TopicsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.menu_moment:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new MomentsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.menu_bookmarks:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new BookmarksFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case R.id.menu_helpcenter:{
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.framelayout, new HelpCenterFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
}
