package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
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
    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        spinnerOperacion = findViewById(R.id.spinnerOperacion);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.operaciones_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperacion.setAdapter(adapter);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        String numero1Str = editTextNumero1.getText().toString();
        String numero2Str = editTextNumero2.getText().toString();

        if (numero1Str.isEmpty() || numero2Str.isEmpty()) {
            textViewResultado.setText("Debe ingresar ambos números");
            return;
        }

        double numero1 = Double.parseDouble(numero1Str);
        double numero2 = Double.parseDouble(numero2Str);

        String operacion = spinnerOperacion.getSelectedItem().toString();
        double resultado = 0;

        if (operacion.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operacion.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operacion.equals("*")) {
            resultado = numero1 * numero2;
        } else if (operacion.equals("/")) {
            if (numero2 != 0) {
                resultado = numero1 / numero2;
            } else {
                textViewResultado.setText("No se puede dividir por cero");
                return;
            }
        }

        textViewResultado.setText("Resultado: " + resultado);
    }
}
