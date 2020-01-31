package com.chentong.keepapp.ui.fitness;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FitnessViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FitnessViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}