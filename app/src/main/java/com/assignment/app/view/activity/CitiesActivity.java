package com.assignment.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import com.assignment.app.WeatherApplication;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.R;
import com.assignment.app.view.adapter.CitiesAdapter;
import com.assignment.app.view.base.view.BaseActivity;
import com.assignment.app.view.presenter.CityPresenter;
import com.assignment.app.view.viewmodel.CountryViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;

public class CitiesActivity extends BaseActivity implements CityPresenter.View {

    private final static String COUNTRY_NAME_KEY = "country_name_key";

    @Inject
    CityPresenter presenter;
    @BindView(R.id.list_city)
    RecyclerView cityList;
    @BindView(R.id.progress)
    ProgressBar cityProgress;
    private CitiesAdapter adapter;
    String country_id;


    public static void open(Context context, String country_name) {

        Intent intent = new Intent(context, CitiesActivity.class);
        intent.putExtra(COUNTRY_NAME_KEY, country_name);
        context.startActivity(intent);

    }

    @Override
    public void initView() {
        super.initView();
        initializeToolbar();
        initializeDagger();
        initializePresenter();
        initializeAdapter();
        initializeRecyclerView();
        presenter.initialize();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_city;
    }

    private void initializeDagger() {
        WeatherApplication weatherApplication = (WeatherApplication) getApplication();
        weatherApplication.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
        String flag = getCityFlagKey();
        presenter.setCountryNameFlag(flag);
        presenter.initialize();
    }

    private void initializeAdapter() {
        adapter = new CitiesAdapter(presenter);
    }

    private void initializeRecyclerView() {
        cityList.setLayoutManager(new LinearLayoutManager(this));
        cityList.setHasFixedSize(true);
        cityList.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    private String getCityFlagKey() {
        return getIntent().getExtras().getString(COUNTRY_NAME_KEY);
    }


    private void initializeToolbar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(
                    ContextCompat.getColor(CitiesActivity.this, R.color.colorPrimaryDark));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showLoading() {

        cityProgress.setVisibility(View.VISIBLE);
        cityList.setVisibility(View.GONE);

    }

    @Override
    public void hideLoading() {

        cityProgress.setVisibility(View.GONE);
        cityList.setVisibility(View.VISIBLE);

    }

    @Override
    public void showCity(CountryViewModel countryViewModel) {


        if (getToolbar() != null) {
            getToolbar().setTitle(countryViewModel.getCountry_name());
        }

        this.country_id = countryViewModel.getCountry_id();

        List<CityEntity> cityList = new ArrayList<>();

        for (int i = 0; i < countryViewModel.getCities().size(); i++) {

            if (countryViewModel.getCities().get(i).getCity_name() != null) {

                cityList.add(countryViewModel.getCities().get(i));
            }
        }

        adapter.addAll(cityList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openCityDetailScreen(CityEntity cityEntity) {

        CityDetailsActivity.open(CitiesActivity.this, country_id, cityEntity.getCity_id());

    }
}
