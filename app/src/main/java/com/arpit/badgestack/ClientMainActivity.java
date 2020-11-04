package com.arpit.badgestack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.arpit.badgestack.ui.AssociatedIndustries.IndustriesFragment;
import com.arpit.badgestack.ui.ClientStatistics.ClientStatistics;
import com.arpit.badgestack.ui.CodeScanner.CodeScannerFragment;
import com.arpit.badgestack.ui.statistics.statisticsFragment;
import com.arpit.badgestack.ui.timeline.timelineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ClientMainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            item -> {
                switch (item.getItemId())
                {
                    case R.id.navigation_showcase:
                        switchToCodeScannerFragment();
                        break;

                    case R.id.navigation_industries:
                        switchToIndustryFragment();
                        break;

                    case R.id.navigation_statistics:
                        switchToStatisticsFragment();
                        break;


                }
                return true; };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_main);
        BottomNavigationView navView = findViewById(R.id.nav_view_client);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_codeScanner, R.id.navigation_industries, R.id.navigation_statistics_client)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_client);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        switchToCodeScannerFragment();
    }
    public void switchToCodeScannerFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment_client, new CodeScannerFragment()).commit();
    }
    public void switchToIndustryFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment_client, new IndustriesFragment()).commit();

    }
    public void switchToStatisticsFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment, new ClientStatistics()).commit();


    }
}