package com.assignment.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.assignment.app.WeatherApplication;
import com.assignment.app.view.adapter.CityDailyReportAdapter;
import com.assignment.app.view.viewmodel.DailyModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.assignment.app.R;
import com.assignment.app.view.base.view.BaseActivity;
import com.assignment.app.view.presenter.CityDetailPresenter;
import com.assignment.app.view.viewmodel.CityViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class CityDetailsActivity extends BaseActivity implements CityDetailPresenter.View {

    private final static String COUNTRY_ID = "country_id";
    private final static String CITY_ID = "city_id";

    @Inject
    CityDetailPresenter presenter;
    @BindView(R.id.list_city_detail)
    RecyclerView cityDailyReportList;
    private CityDailyReportAdapter adapter;

    @BindView(R.id.tv_currently)
    TextView tv_currently;
    @BindView(R.id.tv_summary)
    TextView tv_summary;
    @BindView(R.id.tv_humidity)
    TextView tv_humidity;
    @BindView(R.id.tv_longitude)
    TextView tv_longitude;
    @BindView(R.id.tv_tempMaxCelcius)
    TextView tv_tempMaxCelcius;
    @BindView(R.id.tv_tempCelsius)
    TextView tv_tempCelsius;
    @BindView(R.id.tv_tempMinCelcius)
    TextView tv_tempMinCelcius;
    @BindView(R.id.tv_latitude)
    TextView tv_latitude;
    @BindView(R.id.tv_timeString)
    TextView tv_timeString;
    @BindView(R.id.image_view)
    ImageView image_view;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    public static void open(Context context, String country_id, String city_id) {

        Intent intent = new Intent(context, CityDetailsActivity.class);
        intent.putExtra(COUNTRY_ID, country_id);
        intent.putExtra(CITY_ID, city_id);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        super.initView();
        initializeToolbar();
        initializeDagger();
        initializeAdapter();
        initializeRecyclerView();
        initializePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_city_detail;
    }

    private void initializeDagger() {
        WeatherApplication weatherApplication = (WeatherApplication) getApplication();
        weatherApplication.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
        String country_id = getCountryId();
        String city_id = getCityId();
        presenter.setId(country_id, city_id);
        presenter.initialize();
    }

    private void initializeAdapter() {
        adapter = new CityDailyReportAdapter(presenter);
    }

    private void initializeRecyclerView() {

        cityDailyReportList.setLayoutManager(new LinearLayoutManager(this));


        cityDailyReportList.setAdapter(adapter);
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

    private String getCountryId() {
        return getIntent().getExtras().getString(COUNTRY_ID);
    }

    private String getCityId() {
        return getIntent().getExtras().getString(CITY_ID);
    }

    private void initializeToolbar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(
                    ContextCompat.getColor(CityDetailsActivity.this, R.color.colorPrimaryDark));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void showCityDetail(CityViewModel cityViewModel) {

        if (getToolbar() != null) {
            getToolbar().setTitle(cityViewModel.getCity_name());
        }

        String summary = cityViewModel.getWeather().getCurrently().getSummary();
        if (summary != null) {

            tv_summary.setText(summary);

        }
        String humidity = cityViewModel.getWeather().getCurrently().getHumidity();
        if (humidity != null) {

            tv_humidity.setText(humidity);

        }
        String longitude = cityViewModel.getWeather().getCurrently().getLongitude();

        if (longitude != null) {

            tv_longitude.setText(longitude);

        }
        String tempMaxCelcius = cityViewModel.getWeather().getCurrently().getTempMaxCelcius();

        if (tempMaxCelcius != null) {

            tv_tempMaxCelcius.setText("Max Temp: " + tempMaxCelcius + " \u2103");

        }
        String tempMinCelcius = cityViewModel.getWeather().getCurrently().getTempMinCelcius();

        if (tempMinCelcius != null) {

            tv_tempMinCelcius.setText("Min Temp: " + tempMinCelcius + " \u2103");

        }
        String latitude = cityViewModel.getWeather().getCurrently().getLatitude();

        if (latitude != null) {

            tv_latitude.setText(latitude);

        }

        String tempCelsius = cityViewModel.getWeather().getCurrently().getTempCelsius() ;

        if (tempCelsius != null) {

            tv_tempCelsius.setText(tempCelsius + " \u2103");

        }

        String timeString = cityViewModel.getWeather().getCurrently().getTimeString();

        if (timeString != null) {

            tv_timeString.setText(timeString);

        }

        Uri uri = Uri.parse(cityViewModel.getWeather().getCurrently().getIconUrl());
        SimpleDraweeView draweeView = findViewById(R.id.image_view);
        draweeView.setImageURI(uri);

        List<DailyModel> list = new ArrayList<>();
        list.add(cityViewModel.getWeather().getDaily().get("2015-06-22"));
        list.add(cityViewModel.getWeather().getDaily().get("2015-06-23"));
        list.add(cityViewModel.getWeather().getDaily().get("2015-06-24"));
        list.add(cityViewModel.getWeather().getDaily().get("2015-06-25"));
        list.add(cityViewModel.getWeather().getDaily().get("2015-06-26"));

        adapter.addAll(list);
        adapter.notifyDataSetChanged();

    }
}
