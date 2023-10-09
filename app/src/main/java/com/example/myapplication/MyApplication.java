package com.example.myapplication;

import android.app.Application;

public class MyApplication extends Application {
    private double resultado = 0;

    public void sumar(double numero1, double numero2) {
        resultado = numero1 + numero2;
    }

    public void restar(double numero1, double numero2) {
        resultado = numero1 - numero2;
    }

    public void multiplicar(double numero1, double numero2) {
        resultado = numero1 * numero2;
    }

    public void dividir (double numero1, double numero2) {
        resultado = numero1 / numero2;
    }

    public double getResultado() {
        return resultado;
    }


}
