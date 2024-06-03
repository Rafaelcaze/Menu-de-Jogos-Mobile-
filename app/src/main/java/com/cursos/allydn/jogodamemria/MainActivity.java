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

public class MainActivity extends AppCompatActivity {

    private static final String dadosApp = "ArquivosDados";

    private Button jogar;
    private Button voltar;
    private ImageView imgSom;
    private TextView pontos;
    private String exibirSom = "sim";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogar = findViewById(R.id.btnJogar);
        voltar = findViewById(R.id.btnVoltar);
        imgSom = findViewById(R.id.imgAudioMain);
        pontos = findViewById(R.id.txtQtdPontos);

        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (exibirSom.equals("sim")){

                    final MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.level_completed);
                    mediaPlayer.start();

                }else {

                }

                Intent abreTela = new Intent(getApplication(), Jogo2x2MainActivity.class);
                startActivity(abreTela);

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(getApplication(), Activity_menu.class);
                startActivity(abreTela);
            }
        });


        imgSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences para salvar os dados no celular do usuário
                //Cria um arquivo xml e dentro desse arquivo conseguimos salvar os dados
                //mode 0 - significa que esse arquivo só vai ser lido por esse app
                SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

                if (arquivos.contains("som")){

                    //Recupero a informação de é para o App exibir som ou não
                    String resultado = arquivos.getString("som", "não");


                    //Desligo o som
                    if (resultado.equals("sim")){

                        SharedPreferences.Editor editor = arquivos.edit();

                        //Se não existe a coluna de som eu crio ela e coloco o valor sim
                        editor.putString("som", "não");

                        //Salvo a opção de ouvir som
                        editor.commit();

                        exibirSom = "não";
                        Toast.makeText(MainActivity.this, "Som delisgado com sucesso!", Toast.LENGTH_LONG).show();

                    }else{

                        SharedPreferences.Editor editor = arquivos.edit();

                        //Se não existe a coluna de som eu crio ela e coloco o valor sim
                        editor.putString("som", "sim");

                        //Salvo a opção de ouvir som
                        editor.commit();

                        exibirSom = "sim";
                        Toast.makeText(MainActivity.this, "Som ligado com sucesso!", Toast.LENGTH_LONG).show();

                    }

                }else{

                    SharedPreferences.Editor editor = arquivos.edit();

                    //Se não existe a coluna de som eu crio ela e coloco o valor sim
                    editor.putString("som", "sim");

                    //Salvo a opção de ouvir som
                    editor.commit();

                    exibirSom = "sim";
                    Toast.makeText(MainActivity.this, "Som ligado com sucesso!", Toast.LENGTH_LONG).show();

                }



            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        //SharedPreferences para salvar os dados no celular do usuário
        //Cria um arquivo xml e dentro desse arquivo conseguimos salvar os dados
        //mode 0 - significa que esse arquivo só vai ser lido por esse app
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        //if - se
        if(arquivos.contains("pontos")){

            //Recupero a quantidade de pontos que tem na memória do celular
            int pontosRecuperados = arquivos.getInt("pontos", 0);
            pontos.setText("Pontos: " + pontosRecuperados);

        }else {

            SharedPreferences.Editor editor = arquivos.edit();

            //Se não existe a coluna de pontos eu crio ela e coloco o valor 0
            editor.putInt("pontos", 0);

            //Salvo a nava quantidade de pontos
            editor.commit();

        }

        //if - se
        if(arquivos.contains("som")){

            //Recupero a informação de é para o App exibir som ou não
            String resultado = arquivos.getString("som", "não");
            exibirSom = resultado;

        }else {

            SharedPreferences.Editor editor = arquivos.edit();

            //Se não existe a coluna de som eu crio ela e coloco o valor sim
            editor.putString("som", "sim");

            //Salvo a opção de ouvir som
            editor.commit();

            exibirSom = "sim";

        }

    }


}