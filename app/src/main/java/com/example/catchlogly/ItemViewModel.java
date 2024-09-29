package com.example.catchlogly;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Method;

public class ItemViewModel extends ViewModel{
    private final MutableLiveData<String> selectedString = new MutableLiveData<>();
    public void selectString(String s) {
        selectedString.setValue(s);
    }
    public LiveData<String> getSelectedString() {
        return selectedString;
    }
}




