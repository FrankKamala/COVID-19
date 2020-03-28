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
import com.adwera.covid_19.models.CountryInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    List<Country> countries;
    private Context mContext;
    public static OnCLickListener clickListener;

    public CountryAdapter(List<Country> countries, Context mContext) {
        this.countries = countries;
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
    holder.bindCountry(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.country_flag)
        ImageView mCountryFlag;
        @BindView(R.id.country_name)
        TextView mCountryName;
        private Context mContext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);

        }

        public void bindCountry(Country country){
            Picasso.get().load(country.getCountryInfo().getFlag()).into(mCountryFlag);
            mCountryName.setText(country.getCountry());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setOnClickListener(OnCLickListener clickListener){
        CountryAdapter.clickListener = clickListener;

    }

    public interface OnCLickListener{
        void onClick(View view, int position);
    }
}
