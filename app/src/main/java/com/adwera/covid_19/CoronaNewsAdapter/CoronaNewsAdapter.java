package com.adwera.covid_19.CoronaNewsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adwera.covid_19.R;
import com.adwera.covid_19.models.news.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoronaNewsAdapter extends RecyclerView.Adapter<CoronaNewsAdapter.MyHolder> {
    private List<Article> articles;
    private Context context ;

    public CoronaNewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public CoronaNewsAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        MyHolder viewHolder = new MyHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaNewsAdapter.MyHolder holder, int position) {
        holder.bindArticle(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    //class MyHolder
    public class MyHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.news_title) TextView mTitle;
        @BindView(R.id.news_author) TextView mAuthor;
        @BindView(R.id.news_detail) TextView mDescription;
        private Context mContext;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext=itemView.getContext();
        }
        public void bindArticle(Article article) {
            mTitle.setText(article.getTitle());
            mAuthor.setText(article.getPrimaryAuthor());
            mDescription.setText(article.getSnippet());

        }

    }
}
