package com.example.elijahhezekiah.funnyjokes.View;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.elijahhezekiah.funnyjokes.R;
import com.example.elijahhezekiah.funnyjokes.viewmodel.JokesActivityViewModel;

public class JokeActivity extends AppCompatActivity implements View.OnClickListener {
    JokesActivityViewModel viewModel = new JokesActivityViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }


    @Override
    public void onClick(View v) {


    }

    public void createRandomJokesDialog(String Title,String displayOnText){

        // custom dialog
        final Dialog dialog = new Dialog(this.getApplicationContext());
        dialog.setContentView(R.layout.activity_random_joke);
        dialog.setTitle(Title);

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textViewRandomJokes);
        text.setText(displayOnText);


        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }


}
