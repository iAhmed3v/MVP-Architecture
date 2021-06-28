package com.ahmed3v.mvparchitecture.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ahmed3v.mvparchitecture.ExampleInterface;
import com.ahmed3v.mvparchitecture.R;
import com.ahmed3v.mvparchitecture.model.Model;
import com.ahmed3v.mvparchitecture.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements ExampleInterface.View {

    // creating object of TextView class
    private TextView textView;

    // creating object of Button class
    private Button button;

    // creating object of ProgressBar class
    private ProgressBar progressBar;

    // creating object of Presenter interface in ExampleInterface
     ExampleInterface.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning ID of the TextView
        textView = findViewById(R.id.example_text_view);

        // assigning ID of the Button
        button = findViewById(R.id.next_example_btn);

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar);

        // instantiating object of Presenter Interface
        presenter = new Presenter(this, new Model());

        // operations to be performed when
        // user clicks the button
        button.setOnClickListener(v -> {

            presenter.onButtonClick();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    // method to display the Example TextView
    @Override
    public void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);

    }

    // method to hide the Example TextView
    @Override
    public void hideProgressBar() {

        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    // method to set random string
    // in the Example TextView
    @Override
    public void setString(String string) {

        textView.setText(string);
    }
}