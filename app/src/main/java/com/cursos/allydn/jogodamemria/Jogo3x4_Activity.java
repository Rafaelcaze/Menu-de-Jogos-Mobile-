package com.cursos.allydn.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class Jogo3x4_Activity extends AppCompatActivity {

    private static final String dadosApp = "ArquivosDados";

    TextView txtPontosAlcados, txtTempo;
    ImageView imagem_L1xC1, imagem_L1xC2, imagem_L1xC3, imagem_L1xC4;
    ImageView imagem_L2xC1, imagem_L2xC2, imagem_L2xC3, imagem_L2xC4;
    ImageView imagem_L3xC1, imagem_L3xC2, imagem_L3xC3, imagem_L3xC4;
    Button btnParar;
    Button btnRecomecar;

    private Timer tempo;
    private int contaTempo = 0;
    private int cliquesBomba = 0;
    private int abriuDuasImagens1 = 0;
    private int abriuDuasImagens2 = 0;
    private int abriuDuasImagens3 = 0;
    private int abriuDuasImagens4 = 0;
    private int abriuDuasImagens5 = 0;
    private int abriuDuasImagens6 = 0;

    Integer[] arrayPosicoesImagens = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    //Número das imagens
    int imagemJogo1, imagemJogo2, imagemJogo3, imagemJogo4, imagemJogo5, imagemJogo6,
    imagemJogo7, imagemJogo8, imagemJogo9, imagemJogo10, imagemJogo11, imagemJogo12;

    int imagemEscolha1, imagemEscolha2;
    int cliqueImage1, cliqueImage2;
    int imagemNumero = 1;

    int pontos = 4;

    private String exibirSom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo3x4);

        configuracoesIniciais();

        imagem_L1xC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L1xC1, posicao);

            }
        });

        imagem_L1xC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L1xC2, posicao);

            }
        });

        imagem_L1xC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L1xC3, posicao);

            }
        });

        imagem_L1xC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L1xC4, posicao);

            }
        });

        imagem_L2xC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L2xC1, posicao);

            }
        });

        imagem_L2xC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L2xC2, posicao);

            }
        });


        imagem_L2xC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L2xC3, posicao);

            }
        });

        imagem_L2xC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L2xC4, posicao);

            }
        });

        imagem_L3xC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L3xC1, posicao);

            }
        });

        imagem_L3xC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L3xC2, posicao);

            }
        });

        imagem_L3xC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L3xC3, posicao);

            }
        });

        imagem_L3xC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Executa som ao clicar na imagem
                executarSom();

                //v - Contém o número da tag que foi passada
                //String - Cast que é uma conversão
                int posicao = Integer.parseInt((String) v.getTag());
                trocarImagem(imagem_L3xC4, posicao);

            }
        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if - se
                if (btnParar.getText().toString().equals("Continuar")){

                    if(contaTempo > 0){

                        if (tempo != null){

                            btnParar.setText("Parar");
                            iniciarContagemTempo();

                            imagem_L1xC1.setEnabled(true);
                            imagem_L1xC2.setEnabled(true);
                            imagem_L1xC3.setEnabled(true);
                            imagem_L1xC4.setEnabled(true);
                            imagem_L2xC1.setEnabled(true);
                            imagem_L2xC2.setEnabled(true);
                            imagem_L2xC3.setEnabled(true);
                            imagem_L2xC4.setEnabled(true);
                            imagem_L3xC1.setEnabled(true);
                            imagem_L3xC2.setEnabled(true);
                            imagem_L3xC3.setEnabled(true);
                            imagem_L3xC4.setEnabled(true);

                        }

                    }

                }else if (btnParar.getText().toString().equals("Parar")){

                    if(contaTempo > 0){

                        if (tempo != null){

                            //Encerro termino o tempo
                            tempo.cancel();

                            contaTempo = Integer.parseInt(txtTempo.getText().toString());

                            btnParar.setText("Continuar");


                            imagem_L1xC1.setEnabled(false);
                            imagem_L1xC2.setEnabled(false);
                            imagem_L1xC3.setEnabled(false);
                            imagem_L1xC4.setEnabled(false);
                            imagem_L2xC1.setEnabled(false);
                            imagem_L2xC2.setEnabled(false);
                            imagem_L2xC3.setEnabled(false);
                            imagem_L2xC4.setEnabled(false);
                            imagem_L3xC1.setEnabled(false);
                            imagem_L3xC2.setEnabled(false);
                            imagem_L3xC3.setEnabled(false);
                            imagem_L3xC4.setEnabled(false);

                        }

                    }

                }

            }
        });

        btnRecomecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Zero o contador de tempo
                contaTempo = 0;

                //Cancelando o tempo
                tempo.cancel();

                //Zero a quantidade de pontos
                pontos = 0;

                txtPontosAlcados.setText("Pontos: " + pontos);

                configuracoesIniciais();

            }
        });

    }

    private void executarSom(){

        if (exibirSom.equals("sim")){

            final MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.som_click);
            mediaPlayer.start();

        }else {

        }

    }

    private void somTrocaTela(){

        if (exibirSom.equals("sim")){

            final MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.level_completed);
            mediaPlayer.start();

        }else {

        }

    }

    private void fimDeJogo(){

        if (exibirSom.equals("sim")){

            final MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.game_over);
            mediaPlayer.start();

        }else {

        }

    }

    private void salvaPontos(){

        //SharedPreferences para salvar os dados no celular do usuário
        //Cria um arquivo xml e dentro desse arquivo conseguimos salvar os dados
        //mode 0 - significa que esse arquivo só vai ser lido por esse app
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        //if - se
        if(arquivos.contains("pontos")){
            SharedPreferences.Editor editor = arquivos.edit();

            //Recupero a quantidade de pontos que tem na memória do celular
            int qtdPontos = arquivos.getInt("pontos", 0);

            //Acrescento 1 na quantidade de pontos
            qtdPontos++;
            editor.putInt("pontos", qtdPontos);

            //Salvo a nava quantidade de pontos
            editor.commit();


        }

    }

    private void configuracoesIniciais(){

        //SharedPreferences para salvar os dados no celular do usuário
        //Cria um arquivo xml e dentro desse arquivo conseguimos salvar os dados
        //mode 0 - significa que esse arquivo só vai ser lido por esse app
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        //if - se
        if(arquivos.contains("som")){

            //Recupero a informação de é para o App exibir som ou não
            String resultado = arquivos.getString("som", "não");
            exibirSom = resultado;

        }else {

            exibirSom = "sim";

        }

        txtPontosAlcados = findViewById(R.id.txtPontos);

        txtPontosAlcados.setText("Pontos: " + pontos);

        txtTempo = findViewById(R.id.txtTempo);

        btnParar = findViewById(R.id.btnParar);
        btnRecomecar = findViewById(R.id.btnRecomecar);

        imagem_L1xC1 = findViewById(R.id.imgMatriz3x4_L1xC1);
        imagem_L1xC2 = findViewById(R.id.imgMatriz3x4_L1xC2);
        imagem_L1xC3 = findViewById(R.id.imgMatriz3x4_L1xC3);
        imagem_L1xC4 = findViewById(R.id.imgMatriz3x4_L1xC4);


        imagem_L2xC1 = findViewById(R.id.imgMatriz3x4_L2xC1);
        imagem_L2xC2 = findViewById(R.id.imgMatriz3x4_L2xC2);
        imagem_L2xC3 = findViewById(R.id.imgMatriz3x4_L2xC3);
        imagem_L2xC4 = findViewById(R.id.imgMatriz3x4_L2xC4);

        imagem_L3xC1 = findViewById(R.id.imgMatriz3x4_L3xC1);
        imagem_L3xC2 = findViewById(R.id.imgMatriz3x4_L3xC2);
        imagem_L3xC3 = findViewById(R.id.imgMatriz3x4_L3xC3);
        imagem_L3xC4 = findViewById(R.id.imgMatriz3x4_L3xC4);

        //Começa a contar o tempo com 60 segundos
        contaTempo = 60;

        iniciarContagemTempo();

        //Define a ordem de cada imagem
        imagem_L1xC1.setTag("0");
        imagem_L1xC2.setTag("1");
        imagem_L1xC3.setTag("2");
        imagem_L1xC4.setTag("3");
        imagem_L2xC1.setTag("4");
        imagem_L2xC2.setTag("5");
        imagem_L2xC3.setTag("6");
        imagem_L2xC4.setTag("7");
        imagem_L3xC1.setTag("8");
        imagem_L3xC2.setTag("9");
        imagem_L3xC3.setTag("10");
        imagem_L3xC4.setTag("11");

        imagensParaOJogo();

        //shuffle - Embaralha as imagens
        Collections.shuffle(Arrays.asList(arrayPosicoesImagens));

        //Deixa as imagens visiveis
        imagem_L1xC1.setVisibility(View.VISIBLE);
        imagem_L1xC2.setVisibility(View.VISIBLE);
        imagem_L1xC3.setVisibility(View.VISIBLE);
        imagem_L1xC4.setVisibility(View.VISIBLE);


        imagem_L2xC1.setVisibility(View.VISIBLE);
        imagem_L2xC2.setVisibility(View.VISIBLE);
        imagem_L2xC3.setVisibility(View.VISIBLE);
        imagem_L2xC4.setVisibility(View.VISIBLE);

        imagem_L3xC1.setVisibility(View.VISIBLE);
        imagem_L3xC2.setVisibility(View.VISIBLE);
        imagem_L3xC3.setVisibility(View.VISIBLE);
        imagem_L3xC4.setVisibility(View.VISIBLE);

        //Mudo todas as imagens para o padrão
        imagem_L1xC1.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L1xC2.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L1xC3.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L1xC4.setImageResource(R.drawable.ic_close_preto_24dp);

        imagem_L2xC1.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L2xC2.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L2xC3.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L2xC4.setImageResource(R.drawable.ic_close_preto_24dp);

        imagem_L3xC1.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L3xC2.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L3xC3.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L3xC4.setImageResource(R.drawable.ic_close_preto_24dp);

    }

    private void imagensParaOJogo(){

        //Número das imagens
        imagemJogo1 = R.drawable.animal8;
        imagemJogo2 = R.drawable.bomba;
        imagemJogo3 = R.drawable.animal10;
        imagemJogo4 = R.drawable.animal11;
        imagemJogo5 = R.drawable.animal12;
        imagemJogo6 = R.drawable.animal13;

        imagemJogo7 = R.drawable.animal8;
        imagemJogo8 = R.drawable.bomba;
        imagemJogo9 = R.drawable.animal10;
        imagemJogo10 = R.drawable.animal11;
        imagemJogo11 = R.drawable.animal12;
        imagemJogo12 = R.drawable.animal13;

    }

    private void trocarImagem(ImageView imagem, int posicao){

        //if - se
        //Integer[] arrayPosicoesImagens = {101, 102, 201, 202};
        if(arrayPosicoesImagens[posicao] == 101){
            imagem.setImageResource(imagemJogo1);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens1++;

        }else if(arrayPosicoesImagens[posicao] == 102){
            imagem.setImageResource(imagemJogo2);

            //Como é uma bomba eu acrescento 1 na qtd cliques na bomba
            cliquesBomba++;

            //if - se
            if(cliquesBomba == 2){

                Toast.makeText(this, "Fim de Jogo", Toast.LENGTH_LONG).show();
                Intent abreTelaBomba = new Intent(getApplication(), Bomba_Activity.class);
                startActivity(abreTelaBomba);

                finish();

            }

        }else if(arrayPosicoesImagens[posicao] == 103){
            imagem.setImageResource(imagemJogo3);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens3++;

        }else if(arrayPosicoesImagens[posicao] == 104){
            imagem.setImageResource(imagemJogo4);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens4++;

        }else if(arrayPosicoesImagens[posicao] == 105){
            imagem.setImageResource(imagemJogo5);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens5++;

        }else if(arrayPosicoesImagens[posicao] == 106){
            imagem.setImageResource(imagemJogo6);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens6++;

        }else if(arrayPosicoesImagens[posicao] == 201){
            imagem.setImageResource(imagemJogo7);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens1++;

        }else if(arrayPosicoesImagens[posicao] == 202){
            imagem.setImageResource(imagemJogo8);

            //Como é uma bomba eu acrescento 1 na qtd cliques na bomba
            cliquesBomba++;

            //if - se
            if(cliquesBomba == 2){

                Toast.makeText(this, "Fim de Jogo", Toast.LENGTH_LONG).show();

                Intent abreTelaBomba = new Intent(getApplication(), Bomba_Activity.class);
                startActivity(abreTelaBomba);

                finish();

            }

        }else if(arrayPosicoesImagens[posicao] == 203){
            imagem.setImageResource(imagemJogo9);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens3++;

        }else if(arrayPosicoesImagens[posicao] == 204){
            imagem.setImageResource(imagemJogo10);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens4++;

        }else if(arrayPosicoesImagens[posicao] == 205){
            imagem.setImageResource(imagemJogo11);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens5++;

        }else if(arrayPosicoesImagens[posicao] == 206){
            imagem.setImageResource(imagemJogo12);

            //Como não é uma bomba eu zero a quantidade de cliques na bomba
            cliquesBomba = 0;

            //Atribiu um clique na imagem
            abriuDuasImagens6++;

        }

        //if - se
        //Se clicarmos na primeira imagem
        if(imagemNumero == 1){

            //Pega o número da posição do array das imagens
            imagemEscolha1 = arrayPosicoesImagens[posicao];

            //Verifica se o número do array que foi passado para a imagem é maior que 200
            if(imagemEscolha1 > 200){

                //Deixa o número com o mesmo número da imagem 1
                imagemEscolha1 = imagemEscolha1 - 100;

            }

            //Troca o número da imagem para 2 por que a imagem já foi aberta
            imagemNumero = 2;

            //Adiciona o número / posição da imagem que foi clicada
            cliqueImage1 = posicao;

            //Desabilita a imagem para não ser clicada mais de uma vez
            imagem.setEnabled(false);

        }else if(imagemNumero == 2){

            //Pega o número da posição do array das imagens
            imagemEscolha2 = arrayPosicoesImagens[posicao];

            //Verifica se o número do array que foi passado para a imagem é maior que 200
            if(imagemEscolha2 > 200){

                //Deixa o número com o mesmo número da imagem 1
                imagemEscolha2 = imagemEscolha2 - 100;

            }

            //Troca o número da imagem para 2 por que a imagem já foi aberta
            imagemNumero = 1;

            //Adiciona o número / posição da imagem que foi clicada
            cliqueImage2 = posicao;

            //Desabilita todas as imagens
            imagem_L1xC1.setEnabled(false);
            imagem_L1xC2.setEnabled(false);
            imagem_L1xC3.setEnabled(false);
            imagem_L1xC4.setEnabled(false);

            imagem_L2xC1.setEnabled(false);
            imagem_L2xC2.setEnabled(false);
            imagem_L2xC3.setEnabled(false);
            imagem_L2xC4.setEnabled(false);

            imagem_L3xC1.setEnabled(false);
            imagem_L3xC2.setEnabled(false);
            imagem_L3xC3.setEnabled(false);
            imagem_L3xC4.setEnabled(false);

            //Depois que clicar nas duas imagens, trava o clique por 1 segundo
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Verifica se as duas imagens são iguais
                    verificaImagensIguais();

                }
            }, 1000);


        }


    }

    private void verificaImagensIguais(){

        //if - se
        if (imagemEscolha1 == imagemEscolha2){

            if (cliqueImage1 == 0){
                imagem_L1xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 1){
                imagem_L1xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 2){
                imagem_L1xC3.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 3){
                imagem_L1xC4.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 4){
                imagem_L2xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 5){
                imagem_L2xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 6){
                imagem_L2xC3.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 7){
                imagem_L2xC4.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 8){
                imagem_L3xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 9){
                imagem_L3xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 10){
                imagem_L3xC3.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 11){
                imagem_L3xC4.setVisibility(View.INVISIBLE);
            }

            if (cliqueImage2 == 0){
                imagem_L1xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 1){
                imagem_L1xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 2){
                imagem_L1xC3.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 3){
                imagem_L1xC4.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 4){
                imagem_L2xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 5){
                imagem_L2xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 6){
                imagem_L2xC3.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 7){
                imagem_L2xC4.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 8){
                imagem_L3xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 9){
                imagem_L3xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 10){
                imagem_L3xC3.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 11){
                imagem_L3xC4.setVisibility(View.INVISIBLE);
            }

            //ponto = 0 + 1
            pontos++;
            txtPontosAlcados.setText("Pontos: " + pontos);
            salvaPontos();

        }else {

            zeraCliques();

            //Se as duas imagens não forem iguais eu coloco o ícone do X novamente
            imagem_L1xC1.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L1xC2.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L1xC3.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L1xC4.setImageResource(R.drawable.ic_close_preto_24dp);


            imagem_L2xC1.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L2xC2.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L2xC3.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L2xC4.setImageResource(R.drawable.ic_close_preto_24dp);

            imagem_L3xC1.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L3xC2.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L3xC3.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L3xC4.setImageResource(R.drawable.ic_close_preto_24dp);

        }

        //Habilita todas as imagens
        imagem_L1xC1.setEnabled(true);
        imagem_L1xC2.setEnabled(true);
        imagem_L1xC3.setEnabled(true);
        imagem_L1xC4.setEnabled(true);

        imagem_L2xC1.setEnabled(true);
        imagem_L2xC2.setEnabled(true);
        imagem_L2xC3.setEnabled(true);
        imagem_L2xC4.setEnabled(true);

        imagem_L3xC1.setEnabled(true);
        imagem_L3xC2.setEnabled(true);
        imagem_L3xC3.setEnabled(true);
        imagem_L3xC4.setEnabled(true);

        //Verifica se o jogo acabou
        verificaSeTerminouJogo();

    }

    private void zeraCliques(){

        if (abriuDuasImagens1 == 2){

        }else {
            abriuDuasImagens1 = 0;
        }

        if (abriuDuasImagens2 == 2){

        }else {
            abriuDuasImagens2 = 0;
        }

        if (abriuDuasImagens3 == 2){

        }else {
            abriuDuasImagens3 = 0;
        }

        if (abriuDuasImagens4 == 2){

        }else {
            abriuDuasImagens4 = 0;
        }

        if (abriuDuasImagens5 == 2){

        }else {
            abriuDuasImagens5 = 0;
        }

        if (abriuDuasImagens6 == 2){

        }else {
            abriuDuasImagens6 = 0;
        }

        cliquesBomba = 0;

    }

    private void verificaSeTerminouJogo(){

        //if - se
        //&& - E
        if(abriuDuasImagens1 == 2 &&
                abriuDuasImagens3 == 2 && abriuDuasImagens4 == 2 &&
                abriuDuasImagens5 == 2 && abriuDuasImagens6 == 2){

            //Zerar o contador
            contaTempo = 0;

            //Cancela a contagem do tempo
            tempo.cancel();

            //Se ganhar avança para próxima etapa
            Intent trocaTela = new Intent(getApplication(), Jogo4x3_Activity.class);
            startActivity(trocaTela);

            //Verifica se o som está ligado para executar o som de nível completado
            somTrocaTela();

            //Encerro a tela dessa fase
            finish();

        }

    }

    public void iniciarContagemTempo(){

        tempo = new Timer();
        tempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //if - se
                        if (contaTempo > 0){
                            contaTempo--;
                            txtTempo.setText(String.valueOf(contaTempo));
                        }else {

                            tempo.cancel();

                            //Toco o som de Game Over
                            fimDeJogo();

                            Toast.makeText(Jogo3x4_Activity.this, "Seu tempo acabou! Até a próxima!", Toast.LENGTH_LONG).show();
                            finish();

                        }

                    }
                });
            }
        }, 1000, 1000);

    }

    @Override
    protected void onStop() {
        super.onStop();
        tempo.cancel();
    }
}