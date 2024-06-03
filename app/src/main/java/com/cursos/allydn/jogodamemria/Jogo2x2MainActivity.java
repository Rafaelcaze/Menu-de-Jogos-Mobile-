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

import com.google.android.material.shadow.ShadowRenderer;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class Jogo2x2MainActivity extends AppCompatActivity {

    private static final String dadosApp = "ArquivosDados";

    TextView txtPontosAlcados, txtTempo;
    ImageView imagem_L1xC1, imagem_L1xC2;
    ImageView imagem_L2xC1,imagem_L2xC2;
    Button btnParar;
    Button btnRecomecar;

    private Timer tempo;
    private int contaTempo = 0;

    Integer[] arrayPosicoesImagens = {101, 102, 201, 202};

    //Número das imagens
    int imagemJogo1, imagemJogo2, imagemJogo3,imagemJogo4;

    int imagemEscolha1, imagemEscolha2;
    int cliqueImage1, cliqueImage2;
    int imagemNumero = 1;

    int pontos = 0;

    private String exibirSom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo2x2_main);

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
                            imagem_L2xC1.setEnabled(true);
                            imagem_L2xC2.setEnabled(true);

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
                            imagem_L2xC1.setEnabled(false);
                            imagem_L2xC2.setEnabled(false);

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
        //if - se
        if(arquivos.contains("som")){

            //Recupero a informação de é para o App exibir som ou não
            String resultado = arquivos.getString("som", "não");
            exibirSom = resultado;

        }else {

            exibirSom = "sim";

        }

        txtPontosAlcados = findViewById(R.id.txtPontos);
        txtTempo = findViewById(R.id.txtTempo);

        btnParar = findViewById(R.id.btnParar);
        btnRecomecar = findViewById(R.id.btnRecomecar);

        imagem_L1xC1 = findViewById(R.id.imgMatriz2x2_L1xC1);
        imagem_L1xC2 = findViewById(R.id.imgMatriz2x2_L1xC2);
        imagem_L2xC1 = findViewById(R.id.imgMatriz2x2_L2xC1);
        imagem_L2xC2 = findViewById(R.id.imgMatriz2x2_L2xC2);

        //Começa a contar o tempo com 30 segundos
        contaTempo = 30;

        iniciarContagemTempo();

        //Define a ordem de cada imagem
        imagem_L1xC1.setTag("0");
        imagem_L1xC2.setTag("1");
        imagem_L2xC1.setTag("2");
        imagem_L2xC2.setTag("3");

        imagensParaOJogo();

        //shuffle - Embaralha as imagens
        Collections.shuffle(Arrays.asList(arrayPosicoesImagens));

        //Deixa as imagens visiveis
        imagem_L1xC1.setVisibility(View.VISIBLE);
        imagem_L1xC2.setVisibility(View.VISIBLE);
        imagem_L2xC1.setVisibility(View.VISIBLE);
        imagem_L2xC2.setVisibility(View.VISIBLE);

        //Mudo todas as imagens para o padrão
        imagem_L1xC1.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L1xC2.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L2xC1.setImageResource(R.drawable.ic_close_preto_24dp);
        imagem_L2xC2.setImageResource(R.drawable.ic_close_preto_24dp);

    }

    private void imagensParaOJogo(){

        //Número das imagens
        imagemJogo1 = R.drawable.animal1;
        imagemJogo2 = R.drawable.animal2;
        imagemJogo3 = R.drawable.animal1;
        imagemJogo4 = R.drawable.animal2;

    }

    private void trocarImagem(ImageView imagem, int posicao){

        //if - se
        //Integer[] arrayPosicoesImagens = {101, 102, 201, 202};
        if(arrayPosicoesImagens[posicao] == 101){
            imagem.setImageResource(imagemJogo1);
        }else if(arrayPosicoesImagens[posicao] == 102){
            imagem.setImageResource(imagemJogo2);
        }else if(arrayPosicoesImagens[posicao] == 201){
            imagem.setImageResource(imagemJogo3);
        }else if(arrayPosicoesImagens[posicao] == 202){
            imagem.setImageResource(imagemJogo4);
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
            imagem_L2xC1.setEnabled(false);
            imagem_L2xC2.setEnabled(false);

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
                imagem_L2xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage1 == 3){
                imagem_L2xC2.setVisibility(View.INVISIBLE);
            }

            if (cliqueImage2 == 0){
                imagem_L1xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 1){
                imagem_L1xC2.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 2){
                imagem_L2xC1.setVisibility(View.INVISIBLE);
            }else if (cliqueImage2 == 3){
                imagem_L2xC2.setVisibility(View.INVISIBLE);
            }

            //ponto = 0 + 1
            pontos++;
            txtPontosAlcados.setText("Pontos: " + pontos);
            salvaPontos();

        }else {

            //Se as duas imagens não forem iguais eu coloco o ícone do X novamente
            imagem_L1xC1.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L1xC2.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L2xC1.setImageResource(R.drawable.ic_close_preto_24dp);
            imagem_L2xC2.setImageResource(R.drawable.ic_close_preto_24dp);

        }

        //Habilita todas as imagens
        imagem_L1xC1.setEnabled(true);
        imagem_L1xC2.setEnabled(true);
        imagem_L2xC1.setEnabled(true);
        imagem_L2xC2.setEnabled(true);

        //Verifica se o jogo acabou
        verificaSeTerminouJogo();

    }

    private void verificaSeTerminouJogo(){

        //if - se
        //&& - E
        if(imagem_L1xC1.getVisibility() == View.INVISIBLE &&
                imagem_L1xC2.getVisibility() == View.INVISIBLE &&
                imagem_L2xC1.getVisibility() == View.INVISIBLE &&
                imagem_L2xC2.getVisibility() == View.INVISIBLE){

            //Zerar o contador
            contaTempo = 0;

            //Cancela a contagem do tempo
            tempo.cancel();

            //Se ganhar avança para próxima etapa
            Intent trocaTela = new Intent(getApplication(), Jogo3x2_Activity.class);
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

                            Toast.makeText(Jogo2x2MainActivity.this, "Seu tempo acabou! Até a próxima!", Toast.LENGTH_LONG).show();
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