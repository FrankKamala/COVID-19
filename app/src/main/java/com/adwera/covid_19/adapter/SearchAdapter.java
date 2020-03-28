package com.adwera.covid_19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adwera.covid_19.R;
import com.adwera.covid_19.models.Country;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private Country country;
    private Context mContext;

    public SearchAdapter(Country country, Context mContext) {
        this.country = country;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.BindCountry(country);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.country_flag)
        ImageView mCountryFlag;
        @BindView(R.id.country_name)
        TextView mCountryName;
        private Context mContext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }
        public void BindCountry(Country country){
            Picasso.get().load(country.getCountryInfo().getFlag()).into(mCountryFlag);
            mCountryName.setText(country.getCountry());
        }
    }
}
