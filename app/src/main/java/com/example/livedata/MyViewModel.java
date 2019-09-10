package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MyViewModel extends ViewModel {
    MutableLiveData<String> number1 = null;
    MutableLiveData<String> number2 = null;
    int num1;
    int num2;

    MutableLiveData<String> generateRandomNumber1() {
        if (number1 == null) {
            number1 = new MutableLiveData<>();
            createNumber1();
        }

        return number1;
    }

    MutableLiveData<String> generateRandomNumber2() {
        if (number2 == null) {
            number2 = new MutableLiveData<>();
            createNumber2();
        }

        return number2;
    }

    MutableLiveData<String> plusNumber1() {
        number1 = new MutableLiveData<>();
        plus1();

        return number1;
    }

    MutableLiveData<String> plusNumber2() {
        number2 = new MutableLiveData<>();
        plus2();

        return number2;
    }

    MutableLiveData<String> minusNumber1() {
        number1 = new MutableLiveData<>();
        minus1();

        return number1;
    }

    MutableLiveData<String> minusNumber2() {
        number2 = new MutableLiveData<>();
        minus2();

        return number2;
    }

    void createNumber1() {
        Random random = new Random();
        number1.setValue(String.valueOf(random.nextInt(1000)));
    }

    void createNumber2() {
        Random random = new Random();
        number2.setValue(String.valueOf(random.nextInt(1000)));
    }

    void plus1() {
        number1.setValue(String.valueOf(++num1));
    }

    void plus2() {
        number2.setValue(String.valueOf(++num2));
    }

    void minus1() {
        number1.setValue(String.valueOf(--num1));
    }

    void minus2() {
        number2.setValue(String.valueOf(--num2));
    }
}