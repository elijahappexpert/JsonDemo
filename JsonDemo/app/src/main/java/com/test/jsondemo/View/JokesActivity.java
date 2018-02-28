package com.test.jsondemo.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.jsondemo.Presenter.JokesPresenter;
import com.test.jsondemo.R;
import com.test.jsondemo.model.DisplayDataAdapter;
import com.test.jsondemo.model.Joke;
import com.test.jsondemo.model.JokesDataSource;

import java.util.ArrayList;

public class JokesActivity extends AppCompatActivity implements JokesView  {

    private DisplayDataAdapter Adapter;
    private JokesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        presenter = new JokesPresenter(this, new JokesDataSource());

        RecyclerView rv = findViewById(R.id.list_users);

         Adapter = new DisplayDataAdapter(this);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(Adapter);

        presenter.getJokes();
    }

    @Override
    public void onShowJokes(ArrayList<Joke> value) {
        Adapter.addJokes(value);
    }
}
