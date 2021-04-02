package com.example.asigment.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asigment.R;
import com.example.asigment.model.Weather;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Weather> listWeather;

    public HomeAdapter(Activity activity, List<Weather> listWeather){
            this.activity = activity;
            this.listWeather = listWeather;
    }

    public void reloadData(List<Weather> list){
        this.listWeather = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View weatherView = activity.getLayoutInflater().inflate(R.layout.activity_main, parent,false);
        HomeHolder homeHolder = new HomeHolder(weatherView);
        return homeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    HomeHolder homeHolder =(HomeHolder) holder;
    Weather model = listWeather.get(position);
    homeHolder.tvDateTime.setText(model.getDateTime());
    homeHolder.tvValue.setText(model.getTemperature().getValue());
    homeHolder.tvIconPhrase.setText(model.get);

    }

    @Override
    public int getItemCount() {
    return listWeather.size();
    }
public class HomeHolder extends RecyclerView.ViewHolder {
    TextView tvIconPhrase, tvDateTime, tvValue;
    ImageView ivCover;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);
        tvDateTime = itemView.findViewById(R.id.tvDateTime);
        tvIconPhrase = itemView.findViewById(R.id.tvIconPhrase);
        tvValue = itemView.findViewById(R.id.tvValue);
        ivCover = itemView.findViewById(R.id.ivCover);


    }
}

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }




}
