package com.cursos.allydn.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    // Constante para o nome do arquivo de dados
    private static final String DADOS_APP = "ArquivoDados";

    private TextView txtTotalPontos;
    private Button btnTermo, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Certifique-se de que este layout é o correto

        // Inicializando os componentes
        txtTotalPontos = findViewById(R.id.txtTotalPontos);
        btnTermo = findViewById(R.id.btnTermo);
        btnSair = findViewById(R.id.btnSair);

        // Configurando o listener do botão Sair
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(getApplicationContext(), Activity_menu.class);
                startActivity(abreTela);
            }
        });

        // Configurando o listener do botão Termo
        btnTermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a tela do jogo do Termo
                Intent abreTela = new Intent(getApplicationContext(), TermoActivity.class);
                startActivity(abreTela);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // SharedPreferences para salvar os dados no celular do usuário
        SharedPreferences arquivos = getSharedPreferences(DADOS_APP, 0);

        if (arquivos.contains("pontos")) {
            int resultado = arquivos.getInt("pontos", 0);
            txtTotalPontos.setText("Pontos: " + resultado);
        } else {
            SharedPreferences.Editor editor = arquivos.edit();
            // Criando a coluna de pontos e salvando o valor 0
            editor.putInt("pontos", 0);
            editor.apply();
            txtTotalPontos.setText("Pontos: 0");
        }
    }
}
