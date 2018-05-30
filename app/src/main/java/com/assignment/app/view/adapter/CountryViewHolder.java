package com.assignment.app.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.assignment.app.R;
import com.assignment.app.view.presenter.CountryPresenter;
import com.assignment.app.view.viewmodel.CountryViewModel;


public class CountryViewHolder extends RecyclerView.ViewHolder {

    private final CountryPresenter countryPresenter;

    @BindView(R.id.image_flag)
    ImageView flagImage;
    @BindView(R.id.tv_country)
    TextView nameLabel;

    public CountryViewHolder(@NonNull View itemView, @NonNull CountryPresenter countryPresenter) {
        super(itemView);
        this.countryPresenter = countryPresenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(CountryViewModel model) {
        onItemClick(model);

        renderCountryFlagImage(model.getFlag_image_url());
        renderCountryName(model.getCountry_name());
    }

    private void onItemClick(final CountryViewModel countryViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryPresenter.onCountryClicked(countryViewModel);
            }
        });
    }

    private void renderCountryFlagImage(String urlFlagImage) {
        getImage(urlFlagImage, flagImage);
    }

    private void renderCountryName(String name) {
        nameLabel.setText(name);
    }

    private void getImage(String photo, ImageView photoImageView) {

        Glide.with(getContext())
                .load(photo)
                .centerCrop()
                .into(photoImageView);
    }

    private Context getContext() {
        return itemView.getContext();
    }
}
