package com.assignment.app.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.R;
import com.assignment.app.view.presenter.CityPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final CityPresenter presenter;
    private final List<CityEntity> cityList;

    public CitiesAdapter(@NonNull CityPresenter presenter) {
        this.presenter = presenter;
        cityList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
        return new CityViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CityViewHolder cityViewHolder = (CityViewHolder) holder;

        CityEntity city = cityList.get(position);
        cityViewHolder.render(city);

    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public void addAll(Collection<CityEntity> collection) {
        cityList.addAll(collection);
    }
}
