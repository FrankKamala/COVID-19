package com.adwera.covid_19.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.adwera.covid_19.R;
import com.adwera.covid_19.models.news.CoronaNews;
import com.adwera.covid_19.network.news.NewsApi;
import com.adwera.covid_19.network.news.NewsClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

   public void getnewsAll(){

    NewsApi tangaza = NewsClient.getClient();
       Call<List<CoronaNews>> countryCall = tangaza.getnewsAll();
       countryCall.enqueue(new Callback<List<CoronaNews>>() {
           @Override
           public void onResponse(Call<List<CoronaNews>> call, Response<List<CoronaNews>> response) {
               List<CoronaNews> countryList = response.body();


           }

           @Override
           public void onFailure(Call<List<CoronaNews>> call, Throwable t) {


           }
       });
   }
}