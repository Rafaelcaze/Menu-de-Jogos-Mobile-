package com.cursos.allydn.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    //final é uma constante ou seja, um valor que não muda
    private static final String dadosApp = "ArquivoDados";

    private TextView txtTotalPontos;
    private Button btnTermo,btnSair;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializando os componentes
        txtTotalPontos = findViewById(R.id.txtTotalPontos);
        btnTermo = findViewById(R.id.btnTermo);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Fechar o aplicativo
                finish();

            }
        });

        btnTermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Abrir a tela do jogo do Termo
                Intent abreTela = new Intent(getApplication(), TermoActivity.class);
                startActivity(abreTela);

            }
        });
    }
    @Override
    protected void onStart() {

        //SharedPreferences para salvar os dados no celular do usuário
        //Cria um arquivo xml e dentro desse arqui, conseguimos salvar os dados
        //mode 0 - significa que esse arquivo que vai ser gerado só vai ser lido pelo nosso aplicativo
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        if (arquivos.contains("pontos")){

            Integer resultado = arquivos.getInt("pontos", 0);
            txtTotalPontos.setText("Pontos: " + resultado);

        }else {

            SharedPreferences.Editor editor = arquivos.edit();

            //Criando a coluna de pontos e salvando o valor 0
            editor.putInt("pontos", 0);
            editor.commit();

            txtTotalPontos.setText("Pontos: 0");

        }

        super.onStart();
    }
}