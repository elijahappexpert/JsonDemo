package com.test.jsondemo.View;

import com.test.jsondemo.model.Joke;

import java.util.ArrayList;

/**
 * Created by Elijah Hezekiah  on 23/02/2018.
 */

public interface JokesView {

    void onShowJokes(ArrayList<Joke> value);
}
