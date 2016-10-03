package com.example.sibusisomassango.sdkplatformmanagement.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sibusisomassango.sdkplatformmanagement.R;
import com.example.sibusisomassango.sdkplatformmanagement.utils.SDKManagerItem;

import java.util.List;

/**
 * Created by sibusisomassango on 2016/10/03.
 */
public class SDKManagerListAdapter extends RecyclerView.Adapter<SDKManagerListAdapter.SDKListViewHolder>{

    private List<SDKManagerItem> sdkManagerList;
    public SDKManagerListAdapter(List<SDKManagerItem> sdkManagerList){
        this.sdkManagerList = sdkManagerList;
    }

    @Override
    public SDKListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.manager_list_row, viewGroup, false);
        return new SDKListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SDKListViewHolder sdkListViewHolder, int position) {

        SDKManagerItem sdkManagerItem = sdkManagerList.get(position);

        sdkListViewHolder.sdkTitle.setText(sdkManagerItem.getSdktitle());
    }

    @Override
    public int getItemCount() {
        return sdkManagerList.size();
    }

    public class SDKListViewHolder extends RecyclerView.ViewHolder{
        public TextView sdkTitle;
        public SDKListViewHolder(View itemView) {
            super(itemView);

            sdkTitle =(TextView) itemView.findViewById(R.id.txtTitle);

        }
    }
}
