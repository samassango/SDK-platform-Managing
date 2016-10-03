package com.example.sibusisomassango.sdkplatformmanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sibusisomassango.sdkplatformmanagement.adapters.SDKManagerListAdapter;
import com.example.sibusisomassango.sdkplatformmanagement.helper.SDKManagementHelper;
import com.example.sibusisomassango.sdkplatformmanagement.utils.SDKManagerItem;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sibusisomassango on 2016/10/03.
 */
public class SignInFragment extends Fragment {
    private SDKManagementHelper sdkDb;
    private SDKManagerListAdapter sdkManagerListAdapter;
    List<SDKManagerItem> sdkList;
    public SignInFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, null);

        final ViewHolder holder = new ViewHolder();
        holder.recycler_view = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        holder.txtTitle = (EditText) rootView.findViewById(R.id.txtTitle);
        holder.btnAdd = (Button) rootView.findViewById(R.id.btnAdd);
        holder.btnReset = (Button) rootView.findViewById(R.id.btnReset);

        sdkDb = new SDKManagementHelper(getActivity());

        sdkList = sdkDb.getSDKList();
        //if(sdkList != null) {
            sdkManagerListAdapter = new SDKManagerListAdapter(sdkList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            holder.recycler_view.setLayoutManager(mLayoutManager);
            holder.recycler_view.setItemAnimator(new DefaultItemAnimator());
            holder.recycler_view.setAdapter(sdkManagerListAdapter);
//        }else {
//            Toast.makeText(getActivity().getApplicationContext(),"list Empty",Toast.LENGTH_SHORT).show();
//        }
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = holder.txtTitle.getText().toString();
                if(title.isEmpty()){
                    Toast.makeText(getActivity().getApplicationContext(),"Type sdk name",Toast.LENGTH_SHORT).show();
                }else{

                    long _id = sdkDb.insertSDK(title);
                    //sdkDb.close();
                    sdkList = sdkDb.getSDKList();
                    sdkManagerListAdapter = new SDKManagerListAdapter(sdkList);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                    holder.recycler_view.setLayoutManager(mLayoutManager);
                    holder.recycler_view.setItemAnimator(new DefaultItemAnimator());
                    holder.recycler_view.setAdapter(sdkManagerListAdapter);
                   // sdkManagerListAdapter.notifyDataSetChanged();

                    if(_id>0){
                        holder.txtTitle.setText("");
                        Toast.makeText(getActivity().getApplicationContext(),"sdk added successful",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        holder.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              sdkDb.deleteAll();
                sdkList = sdkDb.getSDKList();
                sdkManagerListAdapter = new SDKManagerListAdapter(sdkList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                holder.recycler_view.setLayoutManager(mLayoutManager);
                holder.recycler_view.setItemAnimator(new DefaultItemAnimator());
                holder.recycler_view.setAdapter(sdkManagerListAdapter);
            }
        });

        return rootView;
    }

    public static class ViewHolder{
        RecyclerView recycler_view;
        EditText txtTitle;
        TextView txtDate;
        Button btnAdd,btnReset;
    }
}
