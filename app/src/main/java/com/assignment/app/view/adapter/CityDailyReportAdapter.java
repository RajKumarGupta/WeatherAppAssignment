package com.assignment.app.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.app.view.viewmodel.DailyModel;
import com.assignment.app.R;
import com.assignment.app.view.presenter.CityDetailPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CityDailyReportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final CityDetailPresenter presenter;
    private final List<DailyModel> list;

    public CityDailyReportAdapter(@NonNull CityDetailPresenter presenter) {
        this.presenter = presenter;
        list = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_detail_item, parent, false);
        return new CityDailyReportViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CityDailyReportViewHolder cityDailyReportViewHolder = (CityDailyReportViewHolder) holder;

        DailyModel model = list.get(position);
        cityDailyReportViewHolder.render(model);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(Collection<DailyModel> collection) {
        list.addAll(collection);
    }
}
