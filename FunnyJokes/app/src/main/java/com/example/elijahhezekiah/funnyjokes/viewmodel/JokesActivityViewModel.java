package com.example.elijahhezekiah.funnyjokes.viewmodel;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

import com.example.elijahhezekiah.funnyjokes.model.Joke;
import com.example.elijahhezekiah.funnyjokes.model.Jokes;
import com.example.elijahhezekiah.funnyjokes.model.JokesDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Elijah Hezekiah  on 02/03/2018.
 */

public class JokesActivityViewModel  implements viewModel{

    public Joke value;
    public sendData dataSender;
    private JokesDataSource dataSource;

    public final ObservableField<Jokes> Jokes = new ObservableField<>();




    public  JokesActivityViewModel(JokesDataSource DataSource){
        dataSource = DataSource;

    }

    public JokesActivityViewModel() {

    }

    @Override
    public void getRandomJoke() {
        Call<Jokes> jokers = dataSource.readJson();

        jokers.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {
                if (response.isSuccessful()) {
                    Jokes body = response.body();
                    value = body.getValue();
                    dataSender.onDataRetrieved(value);
                }

            }

            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {

            }


        });
    }

    @Override
    public void textInput() {

    }

    @Override
    public void NeverEndingList() {

    }

    public interface sendData {

        public void onDataRetrieved(ObservableField<Jokes> Jokes );


    }


}
