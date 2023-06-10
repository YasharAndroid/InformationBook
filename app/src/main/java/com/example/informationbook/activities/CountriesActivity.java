package com.example.informationbook.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.informationbook.R;
import com.example.informationbook.adapters.ViewPagerAdapterCountries;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {

    private TabLayout tabLayoutCountries;
    private ViewPager2 viewPagerCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        tabLayoutCountries = findViewById(R.id.tabLayoutCountries);
        viewPagerCountries = findViewById(R.id.viewPagerCountries);

        ViewPagerAdapterCountries adapter = new ViewPagerAdapterCountries(getSupportFragmentManager(), getLifecycle());

        viewPagerCountries.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutCountries, viewPagerCountries, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("United Kingdom");
                        break;
                    case 1:
                        tab.setText("France");
                        break;
                    case 2:
                        tab.setText("Italy");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();
    }
}