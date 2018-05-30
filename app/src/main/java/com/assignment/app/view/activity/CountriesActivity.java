package com.assignment.app.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.assignment.app.WeatherApplication;
import com.assignment.app.R;
import com.assignment.app.view.adapter.CountriesAdapter;
import com.assignment.app.view.base.view.BaseActivity;
import com.assignment.app.view.presenter.CountryPresenter;
import com.assignment.app.view.viewmodel.CountryViewModel;
import java.util.List;
import javax.inject.Inject;

public class CountriesActivity extends BaseActivity implements CountryPresenter.View {

    @Inject
    CountryPresenter presenter;
    @BindView(R.id.list_country)
    RecyclerView countryList;
    @BindView(R.id.progress)
    ProgressBar countryProgress;
    private CountriesAdapter adapter;

    @Override
    public void initView() {
        super.initView();
        initializeDagger();
        initializePresenter();
        disableTitleFromToolbar();
        initializeAdapter();
        initializeRecyclerView();
        presenter.initialize();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_country;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void showCountryList(List<CountryViewModel> countryList) {
        adapter.addAll(countryList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openCityListScreen(CountryViewModel countryViewModel) {
        CitiesActivity.open(CountriesActivity.this, countryViewModel.getCountry_name());
    }

    @Override
    public void showLoading() {
        countryProgress.setVisibility(View.VISIBLE);
        countryList.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        countryProgress.setVisibility(View.GONE);
        countryList.setVisibility(View.VISIBLE);
    }

    private void initializeAdapter() {
        adapter = new CountriesAdapter(presenter);
    }

    private void initializeRecyclerView() {
        countryList.setLayoutManager(new LinearLayoutManager(this));
        /*countryList.addItemDecoration(new android.support.v7.widget.DividerItemDecoration(this,
                android.support.v7.widget.DividerItemDecoration.VERTICAL));*/
        countryList.setHasFixedSize(true);
        countryList.setAdapter(adapter);
    }

    private void initializeDagger() {
        WeatherApplication app = (WeatherApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    private void disableTitleFromToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
