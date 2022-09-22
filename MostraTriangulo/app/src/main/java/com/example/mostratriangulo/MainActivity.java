package com.example.mostratriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextLadoUm;
    private EditText editTextLadoDois;
    private EditText editTextLadoTres;
    private EditText editTextResultado;
    private Button buttonResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLadoUm = findViewById(R.id.editTextLadoUm);
        editTextLadoDois = findViewById(R.id.editTextLadoDois);
        editTextLadoTres = findViewById(R.id.editTextLadoTres);
        editTextResultado = findViewById(R.id.editTextResultado);
        buttonResultado = (Button) findViewById(R.id.buttonExibir);
        buttonResultado.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int valor1 = Integer.parseInt(editTextLadoUm.getText().toString()); //Passa o valor do campo para a variável.
        int valor2 = Integer.parseInt(editTextLadoDois.getText().toString()); //Passa o valor do campo para a variável.
        int valor3 = Integer.parseInt(editTextLadoTres.getText().toString()); //Passa o valor do campo para a variável.

        if (valor1 == valor2 && valor2 == valor3) {
            editTextResultado.setText("Triângulo Equilátero");
        } else {
            if ((valor1 == valor2) || (valor1 == valor3) || (valor2 == valor3)) {
                editTextResultado.setText("Triângulo Isosceles");
            } else {
                if ((valor1 != valor2) && (valor1 != valor3) && (valor2 != valor3)) {
                    editTextResultado.setText("Triângulo Escaleno");
                }
            }
        }
    }
}