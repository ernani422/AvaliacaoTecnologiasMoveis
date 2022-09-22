package com.example.JogoAdivinhe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final Random myRandom = new Random();
    private Button buttonJogar;
    private TextView textViewDica;
    private EditText numTentativa;

    int num, num_random = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numTentativa = findViewById(R.id.numTentativa); //localiza o id do widget.
        textViewDica = findViewById(R.id.textViewDica); //localiza o id do widget.
        buttonJogar = findViewById(R.id.buttonJogar); //localiza o id do widget.
    }

    //Verifica se o número foi gerado, e inicializa um dos métodos.
    @Override
    public void onClick(View view) {
        buttonJogar.setText("Jogar");

            if (num_random == 0) {
                getNumRandom(view);
                textViewDica.setText("");
                numTentativa.setTextColor(Color.BLACK);
            } else {
                buttonJogar.setText("tentativa");
                tentativa(view);
            }
        }
    

    //Gera o número Random e ativa o EditText
    public void getNumRandom(View view) {
        numTentativa.setEnabled(true);
        num_random = myRandom.nextInt(100);
    }

    //Verifica o número digitado e informa a distâcia em relação ao número gerado
    public void tentativa(View view) {
        num = Integer.parseInt(numTentativa.getText().toString());



            if (num_random == num) {
                textViewDica.setText("Correto!");
                textViewDica.setTextColor(Color.GREEN);
                numTentativa.setTextColor(Color.GREEN);
                numTentativa.setEnabled(false);
                buttonJogar.setText("Jogar Novamente");
                num_random = 0;
            } else if ((num < (num_random - 5) || (num > (num_random + 5)))) {
                textViewDica.setText("Está frio!");
                textViewDica.setTextColor(Color.YELLOW);
            } else {
                textViewDica.setText("Está quente!");
                textViewDica.setTextColor(Color.WHITE);
            }
        }
    }

