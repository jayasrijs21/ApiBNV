package com.example.apibnv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    ListView listView;
    //TextView tv;
    //ProgressBar pb;
    List<BnvModel> bnvModelList = new ArrayList<>();
    listAdapter adapter ;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        listView  = view.findViewById(R.id.lv1);

        fetchContents();

        return view;
    }

    private void fetchContents() {

        RetrofitClient.getRetrofitClient().getBnvModels().enqueue(new Callback<List<BnvModel>>() {
            @Override
            public void onResponse(Call<List<BnvModel>> call, Response<List<BnvModel>> response) {
              //  bnvModelList.addAll(response.body());

                List<BnvModel> bnvModelList = response.body();
                if (bnvModelList != null && bnvModelList.size() > 0) {
                    String[] names = new String[bnvModelList.size()];
                    for (int i = 0; i < bnvModelList.size(); i++) {
                        names[i] = bnvModelList.get(i).getName();

                        adapter = new listAdapter(getActivity() , names);
                        listView.setAdapter(adapter);

                    }
                }

            }

            @Override
            public void onFailure(Call<List<BnvModel>> call, Throwable t) {

            }
        });

    }
}