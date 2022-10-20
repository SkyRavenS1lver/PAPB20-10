package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.TV1);
        getRandomData();
        getBeers();
    }
    public void getRandomData(){
        Call<Beer> caller = RetrofitClient.getInstance().getMyApi().getRandomBeer();

        caller.enqueue(new Callback<Beer>() {
            @Override
            public void onResponse(Call<Beer> call, Response<Beer> response) {
                Beer randomBeer = response.body();
                tv1.setText(randomBeer.getName());
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {

            }
        });



    }
    public void getBeers(){
        Call<List<Beer>> caller = RetrofitClient.getInstance().getMyApi().getBeers( 2);
        caller.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                List<Beer> beerList = response.body();
                String beer = " ";
                        for (int i = 0 ; i<beerList.size();i++){
                            Beer currentBeer = beerList.get(i);
                            beer = beer+","+currentBeer.getBrand();
                        }
                tv1.setText(beer);
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {

            }
        });
    }
}
