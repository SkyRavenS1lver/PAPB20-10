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
        getSpecificUser();
//        getBeers();
    }
    public void getSpecificUser() {
        Call<User> caller = RetrofitClient.getInstance().getMyApi().getUser(12);
        caller.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                tv1.setText(user.getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void getUsers(){
        Call<List<User>> caller = RetrofitClient.getInstance().getMyApi().getUser();
        caller.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
//    public void getRandomData(){
//        Call<Beer> caller = RetrofitClient.getInstance().getMyApi().getRandomBeer();
//
//        caller.enqueue(new Callback<Beer>() {
//            @Override
//            public void onResponse(Call<Beer> call, Response<Beer> response) {
//                Beer randomBeer = response.body();
//                tv1.setText(randomBeer.getName());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call call, Throwable t) {
//
//            }
//        });
//
//
//
//    }
//    public void getBeers(){
//        Call<List<Beer>> caller = RetrofitClient.getInstance().getMyApi().getBeers( 2);
//        caller.enqueue(new Callback<List<Beer>>() {
//            @Override
//            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
//                List<Beer> beerList = response.body();
//                String beer = " ";
//                        for (int i = 0 ; i<beerList.size();i++){
//                            Beer currentBeer = beerList.get(i);
//                            beer = beer+","+currentBeer.getBrand();
//                        }
//            }
//
//            @Override
//            public void onFailure(Call<List<Beer>> call, Throwable t) {
//
//            }
//        });
//    }
}
