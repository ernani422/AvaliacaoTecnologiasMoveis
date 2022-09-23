package desktop.senac.diziplus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity{

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();

        String valorUm = intent.getStringExtra(MainActivity.EXTRA_VALOR_UM);
        String valorDois = intent.getStringExtra(MainActivity.EXTRA_VALOR_DOIS);

        String consumoGasolina = intent.getStringExtra(MainActivity.EXTRA_CONSUMO_GASOLINA);
        String consumoEtanol = intent.getStringExtra(MainActivity.EXTRA_CONSUMO_ETANOL);

        TextView resultadoView = findViewById(R.id.resultadoView);
        TextView resultadoValor = findViewById(R.id.resultadoValor);
        TextView resultadoKmL = findViewById(R.id.resultadoKmL);
        TextView resultadoValorEtanol = findViewById(R.id.resultadoValorEtanol);
        TextView resultadoKmLEtanol = findViewById(R.id.resultadoKmLEtanol);
        TextView resultadoEconomia = findViewById(R.id.resultadoEconomia);
        TextView ResultadoConsumo = findViewById(R.id.ResultadoConsumo);

        double valorGasolinaBack = Double.parseDouble(valorUm);
        double valorEtanolBack = Double.parseDouble(valorDois);
        double consumoGasolinaBack = Double.parseDouble(consumoGasolina);
        double consumoEtanolBack = Double.parseDouble(consumoEtanol);
        double resultadoConsumoGasolina = valorGasolinaBack / consumoGasolinaBack;
        double resultadoConsumoEtanol = valorEtanolBack / consumoEtanolBack;
        double resultadoConsumo = valorEtanolBack / consumoEtanolBack;
        double relacaoCombustivel = (valorEtanolBack / valorGasolinaBack) * 100;

        resultadoValor.setText("Gasolina R$ " + valorUm);
        resultadoKmL.setText(consumoGasolina + "km/l gasolina");
        resultadoValorEtanol.setText("Etanol R$ " + valorDois);
        resultadoKmLEtanol.setText(consumoEtanol + "km/l etanol");

        ResultadoConsumo.setText(
                String.format("Relação Etanol/Gasolina %.2f", relacaoCombustivel) + ("%") +
                        String.format("\nGasto com Gasolina R$%.2f", valorGasolinaBack / consumoGasolinaBack) +
                        String.format("\nGasto com Etanol R$%.2f", valorEtanolBack / consumoEtanolBack));

        if (resultadoConsumoGasolina < resultadoConsumoEtanol) {
            resultadoEconomia.setText(String.format("Economia de R$%.2f", resultadoConsumoGasolina) + " por litro");
        } else {
            resultadoEconomia.setText(String.format("Economia de R$%.2f", resultadoConsumoEtanol) + " por litro");
        }

        if(relacaoCombustivel >= 70) {
            resultadoView.setText("Abasteça com Gasolina");
        } else {
            resultadoView.setText("Abasteça com Etanol");
        }

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ResultActivity.super.onBackPressed();
            }
        });
        }
}


