package com.assignment.app.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.assignment.app.view.viewmodel.DailyModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.assignment.app.R;
import com.assignment.app.view.presenter.CityDetailPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CityDailyReportViewHolder extends RecyclerView.ViewHolder {

    private final CityDetailPresenter cityDetailPresenter;
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


    public CityDailyReportViewHolder(@NonNull View itemView, @NonNull CityDetailPresenter cityDetailPresenter) {
        super(itemView);
        this.cityDetailPresenter = cityDetailPresenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(DailyModel dailyModel) {

        onItemClick(dailyModel);
        renderCityDailyName(dailyModel);

    }

    private void onItemClick(final DailyModel dailyModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    private void renderCityDailyName(DailyModel dailyModel) {

        String summary = dailyModel.getSummary();
        if (summary != null) {

            tv_summary.setText(summary);

        }
        String humidity = dailyModel.getHumidity();
        if (humidity != null) {

            tv_humidity.setText(humidity);

        }
        String longitude = dailyModel.getLongitude();

        if (longitude != null) {

            tv_longitude.setText(longitude);

        }
        String tempMaxCelcius = dailyModel.getTempMaxCelcius();

        if (tempMaxCelcius != null) {

            tv_tempMaxCelcius.setText("Max: "+ tempMaxCelcius+" \u2103");

        }
        String tempMinCelcius = dailyModel.getTempMinCelcius();

        if (tempMinCelcius != null) {

            tv_tempMinCelcius.setText("Min: "+tempMinCelcius+" \u2103");

        }
        String latitude = dailyModel.getLatitude();

        if (latitude != null) {

            tv_latitude.setText(latitude);

        }

        String tempCelsius = dailyModel.getTempCelsius();

        if (tempCelsius != null) {

            tv_tempCelsius.setText(tempCelsius);

        }

        String timeString = dailyModel.getTimeString();

        if (timeString != null) {

            tv_timeString.setText(timeString);

        }

        String image_url = dailyModel.getIconUrl();

        if (image_url != null) {

            Uri uri = Uri.parse(dailyModel.getIconUrl());
            SimpleDraweeView draweeView = itemView.findViewById(R.id.image_view);
            draweeView.setImageURI(uri);

        }

    }

    private Context getContext() {
        return itemView.getContext();
    }
}