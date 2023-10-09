package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private Spinner spinnerOperacion;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyApplication myApp = (MyApplication) getApplication();

        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        spinnerOperacion = findViewById(R.id.spinnerOperacion);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.operaciones_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperacion.setAdapter(adapter);

        buttonCalcular.setOnClickListener(view -> {
            double num1 = Double.parseDouble(editTextNumero1.getText().toString());
            double num2 = Double.parseDouble(editTextNumero2.getText().toString());
            String operacion = spinnerOperacion.getSelectedItem().toString();

            switch (operacion) {
                case "+":
                    myApp.sumar(num1, num2);
                    break;
                case "-":
                    myApp.restar(num1, num2);
                    break;
                case "*":
                    myApp.multiplicar(num1, num2);
                    break;
                case "/":
                    if (num2 != 0) {
                        myApp.dividir(num1, num2);
                    } else {
                        textViewResultado.setText(R.string.no_se_puede_dividir_por_cero);
                    }
                    break;
            }

            textViewResultado.setText((int) myApp.getResultado());


        });
    }
}
