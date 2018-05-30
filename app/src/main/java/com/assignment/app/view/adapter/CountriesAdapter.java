package com.assignment.app.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.app.R;
import com.assignment.app.view.presenter.CountryPresenter;
import com.assignment.app.view.viewmodel.CountryViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final CountryPresenter presenter;
    private final List<CountryViewModel> countryList;

    public CountriesAdapter(@NonNull CountryPresenter presenter) {
        this.presenter = presenter;
        countryList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountryViewHolder countryViewHolder = (CountryViewHolder) holder;
        CountryViewModel country = countryList.get(position);
        countryViewHolder.render(country);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void addAll(Collection<CountryViewModel> collection) {
        countryList.addAll(collection);
    }
}
