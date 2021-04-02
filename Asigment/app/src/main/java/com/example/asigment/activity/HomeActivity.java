package com.example.asigment.activity;

import android.app.AppComponentFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asigment.ApiManager;
import com.example.asigment.R;
import com.example.asigment.adapter.HomeAdapter;
import com.example.asigment.model.Weather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeActivity extends AppCompatActivity {

    TextView tvIconPhrase, tvDateTime, tvValue;
    ImageView ivCover;

    RecyclerView rvNews;
    List<Weather>listWeather = new ArrayList<>();
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //B1: Data source
        getData();

        //B2: Layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        //B3: Adapter
        adapter = new HomeAdapter(this, listWeather);

        //B4: RecyclerView
        rvNews = findViewById(R.id.rvNews);
        rvNews.setLayoutManager(layoutManager);
        rvNews.setAdapter(adapter);
    }
    public void initView(){
        tvDateTime = findViewById(R.id.tvDateTime);
        tvIconPhrase = findViewById(R.id.tvIconPhrase);
        tvValue = findViewById(R.id.tvValue);
        ivCover =findViewById(R.id.ivCover);
    }
    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager service = retrofit.create(ApiManager.class);
service.getDatas().enqueue(new Callback<List<Weather>>() {
    @Override
    public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
if (response.body() != null){
    listWeather = response.body();
adapter.reloadData(listWeather);
}
    }

    @Override
    public void onFailure(Call<List<Weather>> call, Throwable t) {

    }
});

}
}
