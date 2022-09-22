package com.example.CotacaoMoeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_VALOR_REAL = "VALOR_REAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        DecimalFormat money = new DecimalFormat("###.##"); //Cria uma máscara para a exibição do resultado.

        Intent intent = getIntent();
        String valorReal = intent.getStringExtra(MainActivity.EXTRA_VALOR_REAL);

        TextView editTextReal = findViewById(R.id.editTextReal); //localiza o id do widget.
        TextView editTextDolar = findViewById(R.id.editTextDolar); //localiza o id do widget.
        TextView editTextEuro = findViewById(R.id.editTextEuro); //localiza o id do widget.
        TextView editTextLibra = findViewById(R.id.editTextLibra); //localiza o id do widget.

        double valorRealBack = Double.parseDouble(valorReal);


        double valorDolar = valorRealBack / 5.25; //realiza a conversão das moedas.
        double valorEuro = valorRealBack / 5.26; //realiza a conversão das moedas.
        double valorLibra = valorRealBack / 5.99; //realiza a conversão das moedas.

        editTextReal.setText("" + money.format(valorRealBack)); //Não está funcionando sem o espaço na frente.
        editTextDolar.setText("" + money.format(valorDolar)); //Não está funcionando sem o espaço na frente.
        editTextEuro.setText("" + money.format(valorEuro)); //Não está funcionando sem o espaço na frente.
        editTextLibra.setText("" + money.format(valorLibra)); //Não está funcionando sem o espaço na frente.

    }
    
    //Retorna a tela inicial.
    @Override
    public void onClick(View view) {
        ResultActivity.super.onBackPressed();
    }

}