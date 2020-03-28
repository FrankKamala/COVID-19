package com.adwera.covid_19.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adwera.covid_19.R;
import com.adwera.covid_19.models.Country;
import com.adwera.covid_19.network.CoronaApi;
import com.adwera.covid_19.network.CoronaClient;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryDetails extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.total_cases_reported)
    TextView mCasesReported;

    @BindView(R.id.today_cases_reported)
    TextView mTodaysCases;

    @BindView(R.id.reported_deaths_today)
    TextView mDeathsToday;

    @BindView(R.id.total_deaths_reported)
    TextView mTotalDeaths;

    @BindView(R.id.total_recovered_patients)
    TextView mRecoveredPatients;

    @BindView(R.id.active_patients)
    TextView mActivePatients;

    @BindView(R.id.critical_patients)
    TextView mCriticalPatients;

    @BindView(R.id.flag_placeholder)
    ImageView mFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        setupActionBar();
        String countryName = intent.getStringExtra("country");
        collapsingToolbarLayout.setTitle(countryName);
        CoronaApi coronaApi = CoronaClient.getClient();
        Call<Country> countryCall = coronaApi.searchCountry(countryName);
        countryCall.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                Picasso.get().load(response.body().getCountryInfo().getFlag()).into(mFlag);
                mCasesReported.setText(Integer.toString(response.body().getCases()));
                mTodaysCases.setText(Integer.toString(response.body().getTodayCases()));
                mDeathsToday.setText(Integer.toString(response.body().getTodayDeaths()));
                mTotalDeaths.setText(Integer.toString(response.body().getDeaths()));
                mRecoveredPatients.setText(Integer.toString(response.body().getRecovered()));
                mActivePatients.setText(Integer.toString(response.body().getActive()));
                mCriticalPatients.setText(Integer.toString(response.body().getCritical()));
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Toast.makeText(CountryDetails.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }


}
