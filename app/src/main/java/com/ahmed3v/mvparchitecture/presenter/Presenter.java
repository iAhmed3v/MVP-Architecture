package com.ahmed3v.mvparchitecture.presenter;

import com.ahmed3v.mvparchitecture.ExampleInterface;

public class Presenter implements ExampleInterface.Presenter, ExampleInterface.Model.OnFinishedListener {

    // creating object of View Interface
    private ExampleInterface.View mainView;

    // creating object of Model Interface
    private final ExampleInterface.Model model;

    // instantiating the objects of View and Model Interface
    public Presenter(ExampleInterface.View mainView, ExampleInterface.Model model) {
        this.mainView = mainView;
        this.model = model;
    }


    // operations to be performed
    // on button click
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgressBar();
        }
        model.getNextExample(this);
    }


    public void onDestroy() {
        mainView = null;
    }

    // method to return the string
    // which will be displayed in the
    // Example TextView
    @Override
    public void onFinished(String string) {

        if (mainView != null) {
            mainView.setString(string);
            mainView.hideProgressBar();
        }
    }
}
