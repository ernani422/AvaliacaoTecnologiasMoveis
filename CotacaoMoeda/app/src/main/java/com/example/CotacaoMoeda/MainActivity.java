package com.example.CotacaoMoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_VALOR_REAL = "VALOR_REAL";
    private Button buttonCalcular;
    private EditText editTextReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextReal = findViewById(R.id.editTextReal); //localiza o id do widget.
        editTextReal.setText("0.00");

    }

    //Inicializa a tela de resultados
    private void changeToResultScreen() {
        Intent intent = new Intent(this, ResultActivity.class);
        EditText editTextReal = (EditText) findViewById(R.id.editTextReal);
        intent.putExtra(EXTRA_VALOR_REAL, editTextReal.getText().toString());

        startActivity(intent);

        editTextReal.setText("0.00");

    }

    //Botão que inicializa a ResultActivity
    @Override
    public void onClick(View view) {

        changeToResultScreen();

    }
}