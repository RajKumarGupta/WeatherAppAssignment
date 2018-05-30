package com.assignment.app.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.R;
import com.assignment.app.view.presenter.CityPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CityViewHolder extends RecyclerView.ViewHolder {

    private final CityPresenter cityPresenter;
    @BindView(R.id.tv_city)
    TextView nameLabel;

    public CityViewHolder(@NonNull View itemView, @NonNull CityPresenter cityPresenter) {
        super(itemView);
        this.cityPresenter = cityPresenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(CityEntity city) {

        onItemClick(city);
        renderCityName(city.getCity_name());

    }

    private void onItemClick(final CityEntity cityEntity) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityPresenter.onItemClicked(cityEntity);
            }
        });
    }

    private void renderCityName(String name) {

        if (name != null) {

            nameLabel.setText(name);

        }

    }
    private Context getContext() {
        return itemView.getContext();
    }
}
