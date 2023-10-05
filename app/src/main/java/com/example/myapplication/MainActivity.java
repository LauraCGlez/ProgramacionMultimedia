package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private RadioGroup radioGroup;
    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumero1 = findViewById(R.id.textView);
        editTextNumero2 = findViewById(R.id.textView2);
        radioGroup = findViewById(R.id.radioGroup);
        buttonCalcular = findViewById(R.id.button);
        textViewResultado = findViewById(R.id.textView3);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        // Obtener los números ingresados por el usuario
        String numero1Str = editTextNumero1.getText().toString();
        String numero2Str = editTextNumero2.getText().toString();

        if (numero1Str.isEmpty() || numero2Str.isEmpty()) {
            textViewResultado.setText("Debe ingresar ambos números");
            return;
        }

        // Convertir los números a valores numéricos
        double numero1 = Double.parseDouble(numero1Str);
        double numero2 = Double.parseDouble(numero2Str);

        // Verificar la operación seleccionada
        int radioId = radioGroup.getCheckedRadioButtonId();
        double resultado = 0;

        /*

        switch (radioId) {
            case R.id.radioButton:
                resultado = numero1 + numero2;
                break;
            case R.id.radioButton3:
                resultado = numero1 - numero2;
                break;
            case R.id.radioButton2:
                resultado = numero1 * numero2;
                break;
            case R.id.radioButton4:
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    textViewResultado.setText("No se puede dividir por cero");
                    return;
                }
                break;
        }

        textViewResultado.setText("Resultado: " + resultado);
    } */
    }

}
