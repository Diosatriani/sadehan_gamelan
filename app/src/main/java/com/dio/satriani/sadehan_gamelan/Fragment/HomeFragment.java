package com.dio.satriani.sadehan_gamelan.Fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dio.satriani.sadehan_gamelan.Adapter.IklanAdapter;
import com.dio.satriani.sadehan_gamelan.Api.ApiService;
import com.dio.satriani.sadehan_gamelan.Api.RetroClient;
import com.dio.satriani.sadehan_gamelan.Beans.Iklan;
import com.dio.satriani.sadehan_gamelan.Beans.IklanList;
import com.dio.satriani.sadehan_gamelan.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Iklan> iklans;
    private ProgressDialog dialog;
    Activity activity = getActivity();
    private RecyclerView recyclerView;
    private IklanAdapter eAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= (RecyclerView) rootView.findViewById(R.id.recycler_view);

//        dialog = new ProgressDialog(HomeFragment.this);
//        dialog.setMessage("Loading Data.. Please wait...");
//        dialog.setIndeterminate(false);
//        dialog.setCancelable(false);
//        dialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<IklanList> call = api.getMyJSONMarker();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<IklanList>() {
            @Override
            public void onResponse(Call<IklanList> call, Response<IklanList> response) {
                //Dismiss Dialog
//                dialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    iklans = response.body().getWisata();

                    eAdapter = new IklanAdapter(iklans);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
//                    Toast.makeText(HomeFragment.this, "kk"+iklans, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IklanList> call, Throwable t) {
//                dialog.dismiss();
            }
        });

        return rootView;
    }

}
