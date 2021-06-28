package com.ahmed3v.mvparchitecture;

public interface ExampleInterface {

    interface View {
        // method to display progress bar
        // when next random example
        // is being fetched
        void showProgressBar();

        // method to hide progress bar
        // when next random course details
        // is being fetched
        void hideProgressBar();

        // method to set random
        // text on the TextView
        void setString(String string);
    }

    interface Model {

        // nested interface to be
        interface OnFinishedListener {
            // function to be called
            // once the Handler of Model class
            // completes its execution
            void onFinished(String string);
        }

        void getNextExample(ExampleInterface.Model.OnFinishedListener onFinishedListener);

    }


    interface Presenter {

        // method to be called when
        // the button is clicked
        void onButtonClick();

        // method to destroy
        // lifecycle of MainActivity
        void onDestroy();
    }
}
