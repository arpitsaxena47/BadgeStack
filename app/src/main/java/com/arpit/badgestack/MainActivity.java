package com.arpit.badgestack;

import android.os.Bundle;
import android.view.MenuItem;

import com.arpit.badgestack.ui.showcase.showcaseFragment;
import com.arpit.badgestack.ui.statistics.statisticsFragment;
import com.arpit.badgestack.ui.timeline.timelineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_showcase:
                            switchToShowcaseFragment();
                            break;

                        case R.id.navigation_timeline:
                            switchToTimelineFragment();
                            break;

                        case R.id.navigation_statistics:
                            switchToStatisticsFragment();
                            break;


                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_showcase, R.id.navigation_timeline, R.id.navigation_statistics)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        switchToShowcaseFragment();
    }

    public void switchToShowcaseFragment() {
//        Intent showcaseIntent = new Intent(MainActivity.this , ShowcaseActivity.class);
//        startActivity(showcaseIntent);
//        finish();

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment, new showcaseFragment()).commit();
    }
    public void switchToTimelineFragment() {
//        Intent timelineIntent = new Intent(MainActivity.this , TimelineActivity.class);
//        startActivity(timelineIntent);
//        finish();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment, new timelineFragment()).commit();
    }
    public void switchToStatisticsFragment() {
//        Intent statisticsIntent = new Intent(MainActivity.this , Statistics.class);
//        startActivity(statisticsIntent);
//        finish();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment, new statisticsFragment()).commit();
    }

}