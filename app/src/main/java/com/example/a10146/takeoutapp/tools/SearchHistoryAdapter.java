package com.example.a10146.takeoutapp.tools;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a10146.takeoutapp.R;

import java.util.List;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder> {

    private List<String> mHistoryList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView hisName;

        public ViewHolder(View view) {
            super(view);
            hisName = (TextView) view.findViewById(R.id.his_name);
        }
    }

    public SearchHistoryAdapter(List<String> HistoryList) {
        mHistoryList = HistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.his_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String hisName = mHistoryList.get(i);
        viewHolder.hisName.setText(hisName);
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
//        return 4;
    }
}
