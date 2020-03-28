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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adwera.covid_19.Constants.Constants;
import com.adwera.covid_19.CoronaNewsAdapter.CoronaNewsAdapter;
import com.adwera.covid_19.R;
import com.adwera.covid_19.models.news.NewsSearchResponse;
import com.adwera.covid_19.network.news.NewsApi;
import com.adwera.covid_19.network.news.NewsClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    @BindView(R.id.newsRecycler)
    RecyclerView mNewsRecycler;
    private NewsSearchResponse mNews;
    private View root;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        ButterKnife.bind(this, root);
        getNewsAll();
        return root;
    }

   public void getNewsAll(){
        ////news?q=corona&type=headlines&locale=en-KE&output=json&page=1&api_key=391591438ADF4258A668756FC309BB54

    NewsApi tangaza = NewsClient.getClient();
       Call<NewsSearchResponse> news = tangaza.getNews("corona","headlines","en-KE","json",1, Constants.API_KEY);
       news.enqueue(new Callback<NewsSearchResponse>() {
           @Override
           public void onResponse(Call<NewsSearchResponse> call, Response<NewsSearchResponse> response) {
               mNews = response.body();
               CoronaNewsAdapter adapter = new CoronaNewsAdapter(mNews.getArticles(), root.getContext());
               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
               mNewsRecycler.setLayoutManager(layoutManager);
               mNewsRecycler.setHasFixedSize(true);
               mNewsRecycler.setAdapter(adapter);
               adapter.notifyDataSetChanged();

               Log.d(TAG, "onResponse: "+mNews.getArticles().get(0).getTitle());

           }

           @Override
           public void onFailure(Call<NewsSearchResponse> call, Throwable t) {

               Log.d(TAG, "onFailure: " + t.getMessage());
           }
       });
   }
}