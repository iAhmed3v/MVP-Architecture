package com.ahmed3v.mvparchitecture.model;

import android.os.Handler;

import com.ahmed3v.mvparchitecture.ExampleInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements ExampleInterface.Model {

    // array list of strings from which
    // random strings will be selected
    // to display in the activity

    private List <String> arrayList = Arrays.asList(
            "Example 1", "Example 2" , "Example 3", "Example 4 " , "Example 5 ",
            "Example 6 " , "Example 7 ", "Example 8 " , "Example 9 ");


    // this method will invoke when
    // user clicks on the button
    // and it will take a delay of
    // 1200 milliseconds to display next example
    @Override
    public void getNextExample(OnFinishedListener onFinishedListener) {

        new Handler().postDelayed(() -> {

            onFinishedListener.onFinished(getRandomString());

        },1200);
    }


    // method to select random
    // string from the list of strings
    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}
