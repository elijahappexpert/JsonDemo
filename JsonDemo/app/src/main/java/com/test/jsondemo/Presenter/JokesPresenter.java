package com.test.jsondemo.Presenter;

import com.test.jsondemo.View.JokesView;
import com.test.jsondemo.model.Joke;
import com.test.jsondemo.model.JokesDataSource;

import java.util.ArrayList;

/**
 * Created by Elijah Hezekiah  on 23/02/2018.
 */

public class JokesPresenter {

    private final JokesView view;
    private final JokesDataSource dataSource;

    public JokesPresenter(JokesView view, JokesDataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;
    }

    public void getJokes() {
        this.dataSource.readGson(JokesDataSource.JOKES_BASE_URL, new JokesDataSource.MyCallback() {
            @Override
            public void onDataRetrieved(ArrayList<Joke> Value) {
                view.onShowJokes(Value);
            }
        });
    }
}
