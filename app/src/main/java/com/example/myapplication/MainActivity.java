package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
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
}
