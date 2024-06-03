package com.cursos.allydn.jogodamemria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TermoActivity extends AppCompatActivity {

    //final é uma constante ou seja, um valor que não muda
    private static final String dadosApp = "ArquivoDados";

    private Button btnJogarNovamente, btnSair, btnEnviarPalavra;
    private TextView txtTotalPontos, txtPalavraCorreta, txtResultado;
    private TextView txtTermo_Linha1_Coluna1, txtTermo_Linha1_Coluna2, txtTermo_Linha1_Coluna3, txtTermo_Linha1_Coluna4, txtTermo_Linha1_Coluna5;
    private TextView txtTermo_Linha2_Coluna1, txtTermo_Linha2_Coluna2, txtTermo_Linha2_Coluna3, txtTermo_Linha2_Coluna4, txtTermo_Linha2_Coluna5;
    private TextView txtTermo_Linha3_Coluna1, txtTermo_Linha3_Coluna2, txtTermo_Linha3_Coluna3, txtTermo_Linha3_Coluna4, txtTermo_Linha3_Coluna5;
    private TextView txtTermo_Linha4_Coluna1, txtTermo_Linha4_Coluna2, txtTermo_Linha4_Coluna3, txtTermo_Linha4_Coluna4, txtTermo_Linha4_Coluna5;
    private TextView txtTermo_Linha5_Coluna1, txtTermo_Linha5_Coluna2, txtTermo_Linha5_Coluna3, txtTermo_Linha5_Coluna4, txtTermo_Linha5_Coluna5;
    private TextView txtTermo_Linha6_Coluna1, txtTermo_Linha6_Coluna2, txtTermo_Linha6_Coluna3, txtTermo_Linha6_Coluna4, txtTermo_Linha6_Coluna5;
    private TextView txtTermo_Linha7_Coluna1, txtTermo_Linha7_Coluna2, txtTermo_Linha7_Coluna3, txtTermo_Linha7_Coluna4, txtTermo_Linha7_Coluna5;

    private Button buttonLetraQ, buttonLetraW, buttonLetraE, buttonLetraR, buttonLetraT, buttonLetraY, buttonLetraU, buttonLetraI, buttonLetraO, buttonLetraP;
    private Button buttonLetraA, buttonLetraS, buttonLetraD, buttonLetraF, buttonLetraG, buttonLetraH, buttonLetraJ, buttonLetraK, buttonLetraL;
    private Button buttonLetraZ, buttonLetraX, buttonLetraC, buttonLetraV, buttonLetraB, buttonLetraN, buttonLetraM, buttonDeletarLetra;

    private String digitaLetra, nomeSelecionado, palavraCerta, letraParaVerificar;
    private String qualLinha;
    private int posicaoLista;
    private String palavraDigitada;

    private String letra0_PalavraCerta, letra1_PalavraCerta, letra2_PalavraCerta, letra3_PalavraCerta, letra4_PalavraCerta;
    private String letra0_PalavraDigitada, letra1_PalavraDigitada, letra2_PalavraDigitada, letra3_PalavraDigitada, letra4_PalavraDigitada;

    private LinearLayout llBotoesLinha1, llBotoesLinha2, llBotoesLinha3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termo);

        btnJogarNovamente = findViewById(R.id.btnJogarNovamente);
        btnSair = findViewById(R.id.btnSair);
        btnEnviarPalavra = findViewById(R.id.btnEnviarPalavra);

        txtTotalPontos = findViewById(R.id.txtTotalPontos);
        txtPalavraCorreta = findViewById(R.id.txtPalavraCorreta);
        txtResultado = findViewById(R.id.txtResultado);

        llBotoesLinha1 = findViewById(R.id.llBotoesLinha1);
        llBotoesLinha2 = findViewById(R.id.llBotoesLinha2);
        llBotoesLinha3 = findViewById(R.id.llBotoesLinha3);

        txtTermo_Linha1_Coluna1 = findViewById(R.id.txtTermo_Linha1_Coluna1);
        txtTermo_Linha1_Coluna2 = findViewById(R.id.txtTermo_Linha1_Coluna2);
        txtTermo_Linha1_Coluna3 = findViewById(R.id.txtTermo_Linha1_Coluna3);
        txtTermo_Linha1_Coluna4 = findViewById(R.id.txtTermo_Linha1_Coluna4);
        txtTermo_Linha1_Coluna5 = findViewById(R.id.txtTermo_Linha1_Coluna5);

        txtTermo_Linha2_Coluna1 = findViewById(R.id.txtTermo_Linha2_Coluna1);
        txtTermo_Linha2_Coluna2 = findViewById(R.id.txtTermo_Linha2_Coluna2);
        txtTermo_Linha2_Coluna3 = findViewById(R.id.txtTermo_Linha2_Coluna3);
        txtTermo_Linha2_Coluna4 = findViewById(R.id.txtTermo_Linha2_Coluna4);
        txtTermo_Linha2_Coluna5 = findViewById(R.id.txtTermo_Linha2_Coluna5);

        txtTermo_Linha3_Coluna1 = findViewById(R.id.txtTermo_Linha3_Coluna1);
        txtTermo_Linha3_Coluna2 = findViewById(R.id.txtTermo_Linha3_Coluna2);
        txtTermo_Linha3_Coluna3 = findViewById(R.id.txtTermo_Linha3_Coluna3);
        txtTermo_Linha3_Coluna4 = findViewById(R.id.txtTermo_Linha3_Coluna4);
        txtTermo_Linha3_Coluna5 = findViewById(R.id.txtTermo_Linha3_Coluna5);

        txtTermo_Linha4_Coluna1 = findViewById(R.id.txtTermo_Linha4_Coluna1);
        txtTermo_Linha4_Coluna2 = findViewById(R.id.txtTermo_Linha4_Coluna2);
        txtTermo_Linha4_Coluna3 = findViewById(R.id.txtTermo_Linha4_Coluna3);
        txtTermo_Linha4_Coluna4 = findViewById(R.id.txtTermo_Linha4_Coluna4);
        txtTermo_Linha4_Coluna5 = findViewById(R.id.txtTermo_Linha4_Coluna5);

        txtTermo_Linha5_Coluna1 = findViewById(R.id.txtTermo_Linha5_Coluna1);
        txtTermo_Linha5_Coluna2 = findViewById(R.id.txtTermo_Linha5_Coluna2);
        txtTermo_Linha5_Coluna3 = findViewById(R.id.txtTermo_Linha5_Coluna3);
        txtTermo_Linha5_Coluna4 = findViewById(R.id.txtTermo_Linha5_Coluna4);
        txtTermo_Linha5_Coluna5 = findViewById(R.id.txtTermo_Linha5_Coluna5);

        txtTermo_Linha6_Coluna1 = findViewById(R.id.txtTermo_Linha6_Coluna1);
        txtTermo_Linha6_Coluna2 = findViewById(R.id.txtTermo_Linha6_Coluna2);
        txtTermo_Linha6_Coluna3 = findViewById(R.id.txtTermo_Linha6_Coluna3);
        txtTermo_Linha6_Coluna4 = findViewById(R.id.txtTermo_Linha6_Coluna4);
        txtTermo_Linha6_Coluna5 = findViewById(R.id.txtTermo_Linha6_Coluna5);

        txtTermo_Linha7_Coluna1 = findViewById(R.id.txtTermo_Linha7_Coluna1);
        txtTermo_Linha7_Coluna2 = findViewById(R.id.txtTermo_Linha7_Coluna2);
        txtTermo_Linha7_Coluna3 = findViewById(R.id.txtTermo_Linha7_Coluna3);
        txtTermo_Linha7_Coluna4 = findViewById(R.id.txtTermo_Linha7_Coluna4);
        txtTermo_Linha7_Coluna5 = findViewById(R.id.txtTermo_Linha7_Coluna5);

        buttonLetraQ = findViewById(R.id.buttonLetraQ);
        buttonLetraW = findViewById(R.id.buttonLetraW);
        buttonLetraE = findViewById(R.id.buttonLetraE);
        buttonLetraR = findViewById(R.id.buttonLetraR);
        buttonLetraT = findViewById(R.id.buttonLetraT);
        buttonLetraY = findViewById(R.id.buttonLetraY);
        buttonLetraU = findViewById(R.id.buttonLetraU);
        buttonLetraI = findViewById(R.id.buttonLetraI);
        buttonLetraO = findViewById(R.id.buttonLetraO);
        buttonLetraP = findViewById(R.id.buttonLetraP);

        buttonLetraA = findViewById(R.id.buttonLetraA);
        buttonLetraS = findViewById(R.id.buttonLetraS);
        buttonLetraD = findViewById(R.id.buttonLetraD);
        buttonLetraF = findViewById(R.id.buttonLetraF);
        buttonLetraG = findViewById(R.id.buttonLetraG);
        buttonLetraH = findViewById(R.id.buttonLetraH);
        buttonLetraJ = findViewById(R.id.buttonLetraJ);
        buttonLetraK = findViewById(R.id.buttonLetraK);
        buttonLetraL = findViewById(R.id.buttonLetraL);

        buttonLetraZ = findViewById(R.id.buttonLetraZ);
        buttonLetraX = findViewById(R.id.buttonLetraX);
        buttonLetraC = findViewById(R.id.buttonLetraC);
        buttonLetraV = findViewById(R.id.buttonLetraV);
        buttonLetraB = findViewById(R.id.buttonLetraB);
        buttonLetraN = findViewById(R.id.buttonLetraN);
        buttonLetraM = findViewById(R.id.buttonLetraM);
        buttonDeletarLetra = findViewById(R.id.buttonDeletarLetra);

        configuracoesIniciais();

        btnJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                configuracoesIniciais();

                //Oculta o botão novamente
                btnJogarNovamente.setVisibility(View.GONE);

            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Fecha a tela do jogo
                finish();

            }
        });

        buttonLetraQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraQ.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraW.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraE.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraR.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraT.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraY.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraU.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraI.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraO.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraP.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraA.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraS.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraD.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraF.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraG.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraH.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraJ.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraK.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraL.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraZ.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraX.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraC.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraV.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraB.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraN.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonLetraM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Quando clicar no botão armazena o texto que tem no botão na variavel digitaLetra
                digitaLetra = buttonLetraM.getText().toString();

                enviaLetraParaCampoTexto();

            }
        });

        buttonDeletarLetra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if - se
                if (qualLinha.equals("1")){

                    //!= - Diferente
                    if (txtTermo_Linha1_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha1_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha1_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha1_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha1_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha1_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha1_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha1_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha1_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha1_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha1_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha1_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha1_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha1_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha1_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha1_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha1_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha1_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha1_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha1_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }else if (qualLinha.equals("2")){

                    //!= - Diferente
                    if (txtTermo_Linha2_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha2_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha2_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha2_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha2_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha2_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha2_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha2_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha2_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha2_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha2_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha2_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha2_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha2_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha2_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha2_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha2_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha2_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha2_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha2_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }else if (qualLinha.equals("3")){

                    //!= - Diferente
                    if (txtTermo_Linha3_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha3_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha3_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha3_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha3_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha3_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha3_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha3_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha3_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha3_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha3_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha3_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha3_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha3_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha3_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha3_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha3_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha3_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha3_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha3_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }else if (qualLinha.equals("4")){

                    //!= - Diferente
                    if (txtTermo_Linha4_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha4_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha4_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha4_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha4_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha4_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha4_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha4_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha4_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha4_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha4_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha4_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha4_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha4_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha4_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha4_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha4_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha4_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha4_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha4_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }else if (qualLinha.equals("5")){

                    //!= - Diferente
                    if (txtTermo_Linha5_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha5_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha5_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha5_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha5_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha5_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha5_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha5_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha5_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha5_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha5_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha5_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha5_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha5_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha5_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha5_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha5_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha5_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha5_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha5_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }else if (qualLinha.equals("6")){

                    //!= - Diferente
                    if (txtTermo_Linha6_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha6_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha6_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha6_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha6_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha6_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha6_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha6_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha6_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha6_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha6_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha6_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha6_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha6_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha6_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha6_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha6_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha6_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha6_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha6_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }else if (qualLinha.equals("7")){

                    //!= - Diferente
                    if (txtTermo_Linha7_Coluna5.getText().toString() != "-"){

                        txtTermo_Linha7_Coluna5.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha7_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha7_Coluna5.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha7_Coluna4.getText().toString() != "-"){

                        txtTermo_Linha7_Coluna4.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha7_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha7_Coluna4.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha7_Coluna3.getText().toString() != "-"){

                        txtTermo_Linha7_Coluna3.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha7_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha7_Coluna3.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha7_Coluna2.getText().toString() != "-"){

                        txtTermo_Linha7_Coluna2.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha7_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha7_Coluna2.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }else if (txtTermo_Linha7_Coluna1.getText().toString() != "-"){

                        txtTermo_Linha7_Coluna1.setText("-"); //Apagando texto / substituindo texto

                        txtTermo_Linha7_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6")); //Cor Cinza
                        txtTermo_Linha7_Coluna1.setTextColor(Color.parseColor("#000000")); //Cor preto

                    }

                }

            }
        });

        btnEnviarPalavra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                palavraDigitada = ""; //Limpando o texto da palavraDigitada

                if (qualLinha.equals("1")){
                    //Montando a palavra com as letras dos campos da linha
                    palavraDigitada = txtTermo_Linha1_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha1_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha1_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha1_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha1_Coluna5.getText().toString();
                }else if (qualLinha.equals("2")){
                    palavraDigitada = txtTermo_Linha2_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha2_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha2_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha2_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha2_Coluna5.getText().toString();
                }else if (qualLinha.equals("3")){
                    palavraDigitada = txtTermo_Linha3_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha3_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha3_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha3_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha3_Coluna5.getText().toString();
                }else if (qualLinha.equals("4")){
                    palavraDigitada = txtTermo_Linha4_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha4_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha4_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha4_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha4_Coluna5.getText().toString();
                }else if (qualLinha.equals("5")){
                    palavraDigitada = txtTermo_Linha5_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha5_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha5_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha5_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha5_Coluna5.getText().toString();
                }else if (qualLinha.equals("6")){
                    palavraDigitada = txtTermo_Linha6_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha6_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha6_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha6_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha6_Coluna5.getText().toString();
                }else if (qualLinha.equals("7")){
                    palavraDigitada = txtTermo_Linha7_Coluna1.getText().toString();
                    palavraDigitada += txtTermo_Linha7_Coluna2.getText().toString();
                    palavraDigitada += txtTermo_Linha7_Coluna3.getText().toString();
                    palavraDigitada += txtTermo_Linha7_Coluna4.getText().toString();
                    palavraDigitada += txtTermo_Linha7_Coluna5.getText().toString();
                }

                palavraCerta = listaPalavras5Letras();
                palavraCerta = palavraCerta.toUpperCase(); //Deixo tudo em maiusculo

                List<String> minhaLista = Arrays.asList("MEXER", "SENSO", "AFETO", "SUTIL", "INATO", "MUTUO",
                        "AUDAZ", "POREM", "TERMO", "NOBRE", "FAZER", "VIGOR", "LAPSO", "NEGRO", "IDEIA", "GENRO",
                        "DESDE", "POSSE", "FUTIL", "RAZAO", "EXPOR", "ANIMO", "HONRA", "ETICA", "PODER", "SANAR",
                        "ATRAS", "MUITO", "DIZER", "GESTO", "DIGNO", "CORJA", "JUSTO", "CEDER", "ANEXO", "FUGAZ",
                        "VIVAZ", "ASSIM", "HABIL", "MORAL", "DEVER", "COMUM", "FLUIR", "VICIO", "CAUSA", "ONTEM",
                        "CENSO", "SERIO", "CITAR", "IMPOR", "CISMA", "PUDOR", "NENEM", "ALIBI", "REGRA", "GERAR",
                        "OBTER", "LOUCO", "CRISE", "PESAR", "SABER", "PLENO", "ENTAO", "OBVIO", "FAVOR", "VISAR",
                        "TEMOR", "SINTO", "SABIO", "DENSO", "RETER", "JEITO", "HAVER", "SOBRE", "SONHO", "FUSAO",
                        "OBITO", "CRIAR", "CULTO", "ROGAR", "MANSO", "AMENO", "ADIAR", "JUIZO", "PRESA", "FORMA",
                        "BIRRA", "PEDIR", "PROSA", "VACUO", "MUNDO", "ESTAR", "FATOR", "TEMPO", "SERVO", "ARDUO",
                        "FALAR", "VARAO", "FARSA", "ACASO", "FORTE", "FALTA", "CUNHO", "AINDA", "EXATO", "GRATO",
                        "ETNIA", "FLUXO", "AMPLO", "SAUDE", "ACHAR", "FEIXE", "MAGOA", "ATUAR", "FELIZ", "TOMAR",
                        "RITMO", "HEROI", "HASTE", "NOCAO", "VITAL", "CRUEL", "DETER", "LEVAR", "AMIGO", "CASAL",
                        "GRACA", "VISAO", "ALGUM", "BEATA", "ORDEM", "CERTO", "RIGOR", "SAIDA", "EPICO", "LEITO",
                        "BRAVO", "CAPAZ", "SALVO", "ACIMA", "MESMO", "DORSO", "POSSA", "CISAO", "VALHA", "UNICO",
                        "VALOR", "FUGIR", "COISA", "VALIA", "TECER", "BANAL", "PUXAR", "SENDO", "DOCIL", "REGER",
                        "POBRE", "ARIDO", "IGUAL", "MAIOR", "BREVE", "ATIVO", "OUVIR", "SELAR", "VELAR", "ANELO",
                        "VIVER", "OLHAR", "MORAR", "GERIR", "SUMIR", "COPIA", "FACIL", "LEIGO", "MORTE", "TEDIO",
                        "NOITE", "REMIR", "HOMEM", "UNIAO", "SEGUE", "AVIAO", "VENDO", "TERNO", "CESTA", "ACESO",
                        "PEIXE", "VAZIO", "CLARO", "PARDO", "MESMA", "MOTIM", "SERIE", "PAUTA", "PASSO", "BANDO",
                        "VELHO", "GRAVE", "OTICA", "ANCIA", "REVER", "IMUNE", "HOUVE", "ARCAR", "HAVIA", "CAUDA",
                        "BOTAR", "FIXAR", "POSSO", "FLORA", "FENDA", "POUCO", "GENTE", "PONTO", "JOVEM", "QUOTA",
                        "CAIXA", "SAIBA", "VETOR", "EXAME", "FOSSE", "FAUNA", "LUGAR", "FONTE", "PRAZO", "VERBA",
                        "ARDOR", "CIUME", "NICHO", "PRESO", "OTIMO", "EPOCA", "JUNTO", "APOIO", "SOLTO", "PEGAR",
                        "ASTRO", "CALMA", "CHEIO", "ORFAO", "FICAR", "APEGO", "APELO", "FEITO", "FATAL", "FOLGA",
                        "OUTRO", "ASILO", "DERAM", "BATER", "CRIME", "SUPOR", "SIGNO", "PLANO", "FRACO", "TIRAR",
                        "CARRO", "FICHA", "NAVIO", "BURRO", "AMBAS", "PARTE", "RUINA", "MUDAR", "MASSA", "CREDO",
                        "BRISA", "LEGAL", "XEQUE", "CACHO", "COVER", "CAMPO", "NIVEL", "SETOR", "IDEAL", "REZAR",
                        "OPTAR", "GOLPE", "BICHO", "INDIO", "PRAIA", "SINAL", "PASMO", "ABRIR", "FRUIR", "GENIO",
                        "ICONE", "TROCA", "AGUDO", "EXIJO", "AROMA", "RUBRO", "LINDO", "PUDER", "PRADO", "REINO",
                        "AUTOR", "IRMAO", "ZELAR", "CORPO", "SUPRA", "TRAGA", "CERTA", "IMPAR", "PISAR", "LIDAR",
                        "RIVAL", "SABIA", "TERRA", "LIGAR", "RAPAZ", "RAIVA", "QUASE", "PAPEL", "RECEM", "CALDA",
                        "ELITE", "MEIGA", "LIDER", "LIVRO", "RETEM", "FIRME", "VERSO", "SITIO", "TRAMA", "PROVA",
                        "CICLO", "CHARA", "CHATO", "TRETA", "PREGO", "PLACA", "AMBOS", "SIGLA", "DENGO", "GIRIA",
                        "RACHA", "BESTA", "VETAR", "MIDIA", "FORAM", "AMIGA", "LEIGA", "CONTA", "PLENA", "SARRO",
                        "COQUE", "PREZA", "SOUBE", "NAIPE", "POSTO", "BOQUE", "PAREO", "CHATA", "MEIGO", "BONDE",
                        "RETRO", "BODAS", "NEURA", "DIGNA", "NORMA", "BAIXA", "SURTA", "ACUDE", "XUCRO", "POLIR",
                        "TRAVE", "DINDA", "MACRO", "ATEIA", "GURIA", "SURTO", "PARIU", "MALHO", "TROCO", "ZUMBA",
                        "SAROU", "DEMOS", "ANDAR", "BOLOU", "BREGA", "DOTES", "TENDA", "PARES", "ARDUA", "BIOTA",
                        "PARIS", "BODOU", "PUXOU", "SALVE", "BISCA", "VERBO", "IDOLO", "TEMOS", "SUAVE", "TRUTA",
                        "VEZES", "VILAO", "GRUPO", "ROSCA", "LABIA", "JUDEU", "LINDA", "LORDE", "LADRA", "CULTA",
                        "LAUDO", "TEXTO", "GRUDE", "SANTO", "ZUMBI", "PASSE", "TIETE", "MANHA", "GRIFE", "TRIBO",
                        "ALUNO", "GOLFO", "FUNDO", "FORUM", "URUBU", "FRASE", "FUMAR", "SABAO", "SONSA", "QUEDA",
                        "DEUSA", "SARAR", "SERRA", "RISCO", "BLEFE", "SEJAM", "CORRE", "BRUTO", "FERPA", "RALOU",
                        "ORGAO", "PODEM", "SAQUE", "LAZER", "SALMO", "FARPA", "BUCHA", "BROTO", "MOSSA", "ETICO",
                        "LETAL", "MINHA", "TABUA", "BRUXA", "VIVIA", "BUSCA", "INFRA", "TONGO", "PASSA", "INTER",
                        "DADOS", "NOSSA", "LERDA", "RELOU", "CARGO", "BUCHO", "GOMAR", "GOSTO", "LOGAR", "FIADO",
                        "ABONO", "CIVIL", "AMADA", "BOLAO", "OBRAS", "SAFRA", "DANCA", "EXIGE", "POMAR", "MAGIA",
                        "IDOSO", "COROA", "PENTE", "TUTOR", "FACAO", "LENTO", "GRATA", "CLIMA", "PALIO", "LIXAR",
                        "DINDO", "TRAGO", "VISTO", "FUNGO", "RAPTO", "OBESO", "JEJUM", "SORTE", "BEIJO", "PENSO",
                        "CASAR", "TALHO", "MALHA", "FRAGA", "PIADA", "MIMAR", "MEXEU", "PODIO", "COSMO", "COCHO",
                        "RAMAL", "AJUDA", "BODAR", "CACHE", "BOREL", "POETA", "COBRA", "ATIVA", "RUMOR", "ADORO",
                        "LANCE", "JEGUE", "GREGO", "MICRO", "LENDA", "METRO", "PAGAR", "TESTE", "BOATO", "BUFAR",
                        "DOBRO", "MUQUE", "CABRA", "TOSCA", "CULPA", "NATAL", "MAFIA", "LESAO", "FURIA", "SOGRA",
                        "PRIMA", "COICE", "FRITO", "VERME", "PIADO", "POSTE", "CHINA", "PODRE", "DOLAR", "SADIA",
                        "MAGRO", "DUZIA");

                String palavraExisteNaLista = "nao";
                String palavraLista = "";

                //for - para
                //Verifica se a palavra que digitamos existe na lista
                for (int item = 0; item < minhaLista.size(); item++){

                    palavraLista = minhaLista.get(item).toUpperCase();

                    if (palavraLista.equals(palavraDigitada)){
                        palavraExisteNaLista = "sim";
                    }else {

                    }

                }

                if (palavraExisteNaLista.equals("nao")){
                    Toast.makeText(TermoActivity.this, "Essa palavra não existe na lista!", Toast.LENGTH_LONG).show();
                }else {
                    verificarSeAcertouPalavra();
                    pintaBotoesQueJaForam();
                }



            }
        });


    }

    private void pintaBotoesQueJaForam() {

        String letraDigitada_1 = String.valueOf(palavraDigitada.charAt(0));
        String letraDigitada_2 = String.valueOf(palavraDigitada.charAt(1));
        String letraDigitada_3 = String.valueOf(palavraDigitada.charAt(2));
        String letraDigitada_4 = String.valueOf(palavraDigitada.charAt(3));
        String letraDigitada_5 = String.valueOf(palavraDigitada.charAt(4));

        if (letraDigitada_1.equals("A") || letraDigitada_2.equals("A") ||
                letraDigitada_3.equals("A") || letraDigitada_4.equals("A") ||
                letraDigitada_5.equals("A")){

            letraParaVerificar = "A";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraA.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraA.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraA.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraA.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("B") || letraDigitada_2.equals("B") ||
                letraDigitada_3.equals("B") || letraDigitada_4.equals("B") ||
                letraDigitada_5.equals("B")){

            letraParaVerificar = "B";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraB.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraB.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraB.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraB.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("C") || letraDigitada_2.equals("C") ||
                letraDigitada_3.equals("C") || letraDigitada_4.equals("C") ||
                letraDigitada_5.equals("C")){

            letraParaVerificar = "C";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraC.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraC.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraC.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraC.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }



        }

        if (letraDigitada_1.equals("D") || letraDigitada_2.equals("D") ||
                letraDigitada_3.equals("D") || letraDigitada_4.equals("D") ||
                letraDigitada_5.equals("D")){

            letraParaVerificar = "D";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraD.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraD.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraD.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraD.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("E") || letraDigitada_2.equals("E") ||
                letraDigitada_3.equals("E") || letraDigitada_4.equals("E") ||
                letraDigitada_5.equals("E")){

            letraParaVerificar = "E";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraE.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraE.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraE.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraE.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("F") || letraDigitada_2.equals("F") ||
                letraDigitada_3.equals("F") || letraDigitada_4.equals("F") ||
                letraDigitada_5.equals("F")){

            letraParaVerificar = "F";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraF.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraF.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraF.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraF.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("G") || letraDigitada_2.equals("G") ||
                letraDigitada_3.equals("G") || letraDigitada_4.equals("G") ||
                letraDigitada_5.equals("G")){

            letraParaVerificar = "G";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraG.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraG.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraG.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraG.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("H") || letraDigitada_2.equals("H") ||
                letraDigitada_3.equals("H") || letraDigitada_4.equals("H") ||
                letraDigitada_5.equals("H")){

            letraParaVerificar = "H";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraH.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraH.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraH.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraH.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("I") || letraDigitada_2.equals("I") ||
                letraDigitada_3.equals("I") || letraDigitada_4.equals("I") ||
                letraDigitada_5.equals("I")){

            letraParaVerificar = "I";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraI.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraI.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraI.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraI.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("J") || letraDigitada_2.equals("J") ||
                letraDigitada_3.equals("J") || letraDigitada_4.equals("J") ||
                letraDigitada_5.equals("J")){

            letraParaVerificar = "J";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraJ.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraJ.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraJ.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraJ.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("K") || letraDigitada_2.equals("K") ||
                letraDigitada_3.equals("K") || letraDigitada_4.equals("K") ||
                letraDigitada_5.equals("K")){

            letraParaVerificar = "K";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraK.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraK.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraK.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraK.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("L") || letraDigitada_2.equals("L") ||
                letraDigitada_3.equals("L") || letraDigitada_4.equals("L") ||
                letraDigitada_5.equals("L")){

            letraParaVerificar = "L";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraL.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraL.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraL.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraL.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("M") || letraDigitada_2.equals("M") ||
                letraDigitada_3.equals("M") || letraDigitada_4.equals("M") ||
                letraDigitada_5.equals("M")){

            letraParaVerificar = "M";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraM.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraM.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraM.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraM.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("N") || letraDigitada_2.equals("N") ||
                letraDigitada_3.equals("N") || letraDigitada_4.equals("N") ||
                letraDigitada_5.equals("N")){

            letraParaVerificar = "N";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraN.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraN.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraN.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraN.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("O") || letraDigitada_2.equals("O") ||
                letraDigitada_3.equals("O") || letraDigitada_4.equals("O") ||
                letraDigitada_5.equals("O")){

            letraParaVerificar = "O";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraO.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraO.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraO.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraO.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("P") || letraDigitada_2.equals("P") ||
                letraDigitada_3.equals("P") || letraDigitada_4.equals("P") ||
                letraDigitada_5.equals("P")){

            letraParaVerificar = "P";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraP.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraP.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraP.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraP.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("Q") || letraDigitada_2.equals("Q") ||
                letraDigitada_3.equals("Q") || letraDigitada_4.equals("Q") ||
                letraDigitada_5.equals("Q")){

            letraParaVerificar = "Q";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraQ.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraQ.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraQ.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraQ.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("R") || letraDigitada_2.equals("R") ||
                letraDigitada_3.equals("R") || letraDigitada_4.equals("R") ||
                letraDigitada_5.equals("R")){

            letraParaVerificar = "R";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraR.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraR.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraR.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraR.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("S") || letraDigitada_2.equals("S") ||
                letraDigitada_3.equals("S") || letraDigitada_4.equals("S") ||
                letraDigitada_5.equals("S")){

            letraParaVerificar = "S";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraS.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraS.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraS.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraS.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("T") || letraDigitada_2.equals("T") ||
                letraDigitada_3.equals("T") || letraDigitada_4.equals("T") ||
                letraDigitada_5.equals("T")){

            letraParaVerificar = "T";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraT.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraT.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraT.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraT.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("U") || letraDigitada_2.equals("U") ||
                letraDigitada_3.equals("U") || letraDigitada_4.equals("U") ||
                letraDigitada_5.equals("U")){

            letraParaVerificar = "U";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraU.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraU.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraU.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraU.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("V") || letraDigitada_2.equals("V") ||
                letraDigitada_3.equals("V") || letraDigitada_4.equals("V") ||
                letraDigitada_5.equals("V")){

            letraParaVerificar = "V";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraV.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraV.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraV.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraV.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("X") || letraDigitada_2.equals("X") ||
                letraDigitada_3.equals("X") || letraDigitada_4.equals("X") ||
                letraDigitada_5.equals("X")){

            letraParaVerificar = "X";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraX.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraX.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraX.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraX.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("Z") || letraDigitada_2.equals("Z") ||
                letraDigitada_3.equals("Z") || letraDigitada_4.equals("Z") ||
                letraDigitada_5.equals("Z")){

            letraParaVerificar = "Z";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraZ.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraZ.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraZ.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraZ.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("W") || letraDigitada_2.equals("W") ||
                letraDigitada_3.equals("W") || letraDigitada_4.equals("W") ||
                letraDigitada_5.equals("W")){

            letraParaVerificar = "W";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraW.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraW.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraW.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraW.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

        if (letraDigitada_1.equals("Y") || letraDigitada_2.equals("Y") ||
                letraDigitada_3.equals("Y") || letraDigitada_4.equals("Y") ||
                letraDigitada_5.equals("Y")){

            letraParaVerificar = "Y";
            String temLetraPalavra = verificaPalavra(palavraCerta);

            if (temLetraPalavra.equals("sim")){

                buttonLetraY.setBackgroundColor(Color.parseColor("#3370DC")); //Cor do Background Azul
                buttonLetraY.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp


            }else {

                buttonLetraY.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor do Background Cinza
                buttonLetraY.setTextColor(Color.parseColor("#FFFFFF")); //Cor do texto brancp

            }

        }

    }

    private String verificaPalavra(String palavra) {

        List<String> letras = Collections.singletonList(palavra);

        String palavraEmbaralhada = "";
        //for - para
        for (String palavraCompleta : letras){

            String letra1 = String.valueOf(palavraCompleta.charAt(0));
            String letra2 = String.valueOf(palavraCompleta.charAt(1));
            String letra3 = String.valueOf(palavraCompleta.charAt(2));
            String letra4 = String.valueOf(palavraCompleta.charAt(3));
            String letra5 = String.valueOf(palavraCompleta.charAt(4));

            //letra1, 2, 3, 4 e 5 são as letras da palavra que o aplicativo escolheu
            //letraParaVerificar é a letra que estamos verificando
            if (letra1.equals(letraParaVerificar) || letra2.equals(letraParaVerificar) ||
                    letra3.equals(letraParaVerificar) || letra4.equals(letraParaVerificar) ||
                    letra5.equals(letraParaVerificar) ){

                palavraEmbaralhada = "sim";

            }

        }

        return palavraEmbaralhada;

    }

    private void verificarSeAcertouPalavra() {

        letra0_PalavraCerta = String.valueOf(palavraCerta.charAt(0));
        letra1_PalavraCerta = String.valueOf(palavraCerta.charAt(1));
        letra2_PalavraCerta = String.valueOf(palavraCerta.charAt(2));
        letra3_PalavraCerta = String.valueOf(palavraCerta.charAt(3));
        letra4_PalavraCerta = String.valueOf(palavraCerta.charAt(4));

        letra0_PalavraDigitada = String.valueOf(palavraDigitada.charAt(0));
        letra1_PalavraDigitada = String.valueOf(palavraDigitada.charAt(1));
        letra2_PalavraDigitada = String.valueOf(palavraDigitada.charAt(2));
        letra3_PalavraDigitada = String.valueOf(palavraDigitada.charAt(3));
        letra4_PalavraDigitada = String.valueOf(palavraDigitada.charAt(4));

        pintaLetrasErradas();
        pintaLetrasErradasMasQueExistem();
        pintaLetrasCorretas();

        if (palavraCerta.equals(palavraDigitada)){

            salvaPontos();

            //Deixando visivel
            llBotoesLinha1.setVisibility(View.GONE);
            llBotoesLinha2.setVisibility(View.GONE);
            llBotoesLinha3.setVisibility(View.GONE);

            //Desabilitar o botão que envia a palavra
            btnEnviarPalavra.setEnabled(false);

            //Ocultando
            txtPalavraCorreta.setVisibility(View.VISIBLE);
            btnJogarNovamente.setVisibility(View.VISIBLE);
            txtResultado.setVisibility(View.VISIBLE);

            txtResultado.setText("Parabéns! Você acertou a palavra!");


        }else {

            //Se não acertar a palavra e estiver na linha 7 perdeu o jogo
            if (qualLinha.equals("7")){

                txtPalavraCorreta.setVisibility(View.VISIBLE);
                btnJogarNovamente.setVisibility(View.VISIBLE);
                txtResultado.setVisibility(View.VISIBLE);

                //Deixando visivel
                llBotoesLinha1.setVisibility(View.GONE);
                llBotoesLinha2.setVisibility(View.GONE);
                llBotoesLinha3.setVisibility(View.GONE);

                //Desabilitar o botão que envia a palavra
                btnEnviarPalavra.setEnabled(false);

                txtResultado.setText("Você não acertou a palavra!");

            }



        }

        //Pega o número da linha se acertou ou não
        int linha = Integer.parseInt(qualLinha);

        //Acrescenta 1 na variável linha
        linha = linha + 1;

        //Coloca o número correto na linha da variavel
        qualLinha = String.valueOf(linha);


    }

    private void salvaPontos() {

        //SharedPreferences para salvar os dados no celular do usuário
        //Cria um arquivo xml e dentro desse arqui, conseguimos salvar os dados
        //mode 0 - significa que esse arquivo que vai ser gerado só vai ser lido pelo nosso aplicativo
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        if (arquivos.contains("pontos")){

            SharedPreferences.Editor editor = arquivos.edit();

            int qtdPontos = arquivos.getInt("pontos", 0);
            qtdPontos++; //qtdPontos = qtdPontos + 1

            //Criando a coluna de pontos e salvando o valor 0
            editor.putInt("pontos", qtdPontos);
            editor.commit();

            txtTotalPontos.setText("Pontos: " + qtdPontos);

        }else {

            SharedPreferences.Editor editor = arquivos.edit();

            //Criando a coluna de pontos e salvando o valor 0
            editor.putInt("pontos", 0);
            editor.commit();

            txtTotalPontos.setText("Pontos: 0");

        }

    }

    private void pintaLetrasCorretas() {

        if (letra0_PalavraCerta.equals(letra0_PalavraDigitada)){

            if (qualLinha.equals("1")){
                txtTermo_Linha1_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha1_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){
                txtTermo_Linha2_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha2_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){
                txtTermo_Linha3_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha3_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){
                txtTermo_Linha4_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha4_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){
                txtTermo_Linha5_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha5_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){
                txtTermo_Linha6_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha6_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){
                txtTermo_Linha7_Coluna1.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha7_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        if (letra1_PalavraCerta.equals(letra1_PalavraDigitada)){

            if (qualLinha.equals("1")){
                txtTermo_Linha1_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha1_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){
                txtTermo_Linha2_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha2_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){
                txtTermo_Linha3_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha3_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){
                txtTermo_Linha4_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha4_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){
                txtTermo_Linha5_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha5_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){
                txtTermo_Linha6_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha6_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){
                txtTermo_Linha7_Coluna2.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha7_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        if (letra2_PalavraCerta.equals(letra2_PalavraDigitada)){

            if (qualLinha.equals("1")){
                txtTermo_Linha1_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha1_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){
                txtTermo_Linha2_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha2_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){
                txtTermo_Linha3_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha3_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){
                txtTermo_Linha4_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha4_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){
                txtTermo_Linha5_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha5_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){
                txtTermo_Linha6_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha6_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){
                txtTermo_Linha7_Coluna3.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha7_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        if (letra3_PalavraCerta.equals(letra3_PalavraDigitada)){

            if (qualLinha.equals("1")){
                txtTermo_Linha1_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha1_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){
                txtTermo_Linha2_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha2_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){
                txtTermo_Linha3_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha3_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){
                txtTermo_Linha4_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha4_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){
                txtTermo_Linha5_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha5_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){
                txtTermo_Linha6_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha6_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){
                txtTermo_Linha7_Coluna4.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha7_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        if (letra4_PalavraCerta.equals(letra4_PalavraDigitada)){

            if (qualLinha.equals("1")){
                txtTermo_Linha1_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha1_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){
                txtTermo_Linha2_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha2_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){
                txtTermo_Linha3_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha3_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){
                txtTermo_Linha4_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha4_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){
                txtTermo_Linha5_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha5_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){
                txtTermo_Linha6_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha6_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){
                txtTermo_Linha7_Coluna5.setBackgroundColor(Color.parseColor("#3370DC")); //Cor Azul
                txtTermo_Linha7_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

    }

    private void pintaLetrasErradasMasQueExistem() {

        //|| - Ou
        //Letra 0 ou seja primeira letra digitada
        if (letra0_PalavraDigitada.equals(letra0_PalavraCerta) || letra0_PalavraDigitada.equals(letra1_PalavraCerta) ||
                letra0_PalavraDigitada.equals(letra2_PalavraCerta) || letra0_PalavraDigitada.equals(letra3_PalavraCerta) ||
                letra0_PalavraDigitada.equals(letra4_PalavraCerta)){

            if (qualLinha.equals("1")){

                txtTermo_Linha1_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha1_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){

                txtTermo_Linha2_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha2_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){

                txtTermo_Linha3_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha3_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){

                txtTermo_Linha4_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha4_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){

                txtTermo_Linha5_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha5_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){

                txtTermo_Linha6_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha6_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){

                txtTermo_Linha7_Coluna1.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha7_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        //Letra 1 ou seja segunda letra digitada
        if (letra1_PalavraDigitada.equals(letra0_PalavraCerta) || letra1_PalavraDigitada.equals(letra1_PalavraCerta) ||
                letra1_PalavraDigitada.equals(letra2_PalavraCerta) || letra1_PalavraDigitada.equals(letra3_PalavraCerta) ||
                letra1_PalavraDigitada.equals(letra4_PalavraCerta)){

            if (qualLinha.equals("1")){

                txtTermo_Linha1_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha1_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){

                txtTermo_Linha2_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha2_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){

                txtTermo_Linha3_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha3_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){

                txtTermo_Linha4_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha4_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){

                txtTermo_Linha5_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha5_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){

                txtTermo_Linha6_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha6_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){

                txtTermo_Linha7_Coluna2.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha7_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        //Letra 2 ou seja terceita letra digitada
        if (letra2_PalavraDigitada.equals(letra0_PalavraCerta) || letra2_PalavraDigitada.equals(letra1_PalavraCerta) ||
                letra2_PalavraDigitada.equals(letra2_PalavraCerta) || letra2_PalavraDigitada.equals(letra3_PalavraCerta) ||
                letra2_PalavraDigitada.equals(letra4_PalavraCerta)){

            if (qualLinha.equals("1")){

                txtTermo_Linha1_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha1_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){

                txtTermo_Linha2_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha2_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){

                txtTermo_Linha3_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha3_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){

                txtTermo_Linha4_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha4_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){

                txtTermo_Linha5_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha5_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){

                txtTermo_Linha6_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha6_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){

                txtTermo_Linha7_Coluna3.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha7_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        //Letra 3 ou seja quarta letra digitada
        if (letra3_PalavraDigitada.equals(letra0_PalavraCerta) || letra3_PalavraDigitada.equals(letra1_PalavraCerta) ||
                letra3_PalavraDigitada.equals(letra2_PalavraCerta) || letra3_PalavraDigitada.equals(letra3_PalavraCerta) ||
                letra3_PalavraDigitada.equals(letra4_PalavraCerta)){

            if (qualLinha.equals("1")){

                txtTermo_Linha1_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha1_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){

                txtTermo_Linha2_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha2_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){

                txtTermo_Linha3_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha3_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){

                txtTermo_Linha4_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha4_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){

                txtTermo_Linha5_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha5_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){

                txtTermo_Linha6_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha6_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){

                txtTermo_Linha7_Coluna4.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha7_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

        //Letra 4 ou seja quinta letra digitada
        if (letra4_PalavraDigitada.equals(letra0_PalavraCerta) || letra4_PalavraDigitada.equals(letra1_PalavraCerta) ||
                letra4_PalavraDigitada.equals(letra2_PalavraCerta) || letra4_PalavraDigitada.equals(letra3_PalavraCerta) ||
                letra4_PalavraDigitada.equals(letra4_PalavraCerta)){

            if (qualLinha.equals("1")){

                txtTermo_Linha1_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha1_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("2")){

                txtTermo_Linha2_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha2_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("3")){

                txtTermo_Linha3_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha3_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("4")){

                txtTermo_Linha4_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha4_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("5")){

                txtTermo_Linha5_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha5_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("6")){

                txtTermo_Linha6_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha6_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }else if (qualLinha.equals("7")){

                txtTermo_Linha7_Coluna5.setBackgroundColor(Color.parseColor("#ECC143")); //Cor laranja
                txtTermo_Linha7_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor Branca

            }

        }

    }

    private void pintaLetrasErradas() {

        if (qualLinha.equals("1")){

            //Mudando a cor do Background
            txtTermo_Linha1_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha1_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha1_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha1_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha1_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha1_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha1_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha1_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha1_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha1_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }else if (qualLinha.equals("2")){

            //Mudando a cor do Background
            txtTermo_Linha2_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha2_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha2_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha2_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha2_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha2_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha2_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha2_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha2_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha2_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }else if (qualLinha.equals("3")){

            //Mudando a cor do Background
            txtTermo_Linha3_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha3_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha3_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha3_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha3_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha3_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha3_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha3_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha3_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha3_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }else if (qualLinha.equals("4")){

            //Mudando a cor do Background
            txtTermo_Linha4_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha4_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha4_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha4_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha4_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha4_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha4_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha4_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha4_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha4_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }else if (qualLinha.equals("5")){

            //Mudando a cor do Background
            txtTermo_Linha5_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha5_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha5_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha5_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha5_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha5_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha5_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha5_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha5_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha5_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }else if (qualLinha.equals("6")){

            //Mudando a cor do Background
            txtTermo_Linha6_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha6_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha6_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha6_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha6_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha6_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha6_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha6_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha6_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha6_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }else if (qualLinha.equals("7")){

            //Mudando a cor do Background
            txtTermo_Linha7_Coluna1.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha7_Coluna2.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha7_Coluna3.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha7_Coluna4.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza
            txtTermo_Linha7_Coluna5.setBackgroundColor(Color.parseColor("#3A3C3C")); //Cor Cinza

            txtTermo_Linha7_Coluna1.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha7_Coluna2.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha7_Coluna3.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha7_Coluna4.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca
            txtTermo_Linha7_Coluna5.setTextColor(Color.parseColor("#FFFFFF")); //Cor branca

        }

    }

    private String listaPalavras5Letras() {

        List<String> minhaLista = Arrays.asList("MEXER", "SENSO", "AFETO", "SUTIL", "INATO", "MUTUO",
                "AUDAZ", "POREM", "TERMO", "NOBRE", "FAZER", "VIGOR", "LAPSO", "NEGRO", "IDEIA", "GENRO",
                "DESDE", "POSSE", "FUTIL", "RAZAO", "EXPOR", "ANIMO", "HONRA", "ETICA", "PODER", "SANAR",
                "ATRAS", "MUITO", "DIZER", "GESTO", "DIGNO", "CORJA", "JUSTO", "CEDER", "ANEXO", "FUGAZ",
                "VIVAZ", "ASSIM", "HABIL", "MORAL", "DEVER", "COMUM", "FLUIR", "VICIO", "CAUSA", "ONTEM",
                "CENSO", "SERIO", "CITAR", "IMPOR", "CISMA", "PUDOR", "NENEM", "ALIBI", "REGRA", "GERAR",
                "OBTER", "LOUCO", "CRISE", "PESAR", "SABER", "PLENO", "ENTAO", "OBVIO", "FAVOR", "VISAR",
                "TEMOR", "SINTO", "SABIO", "DENSO", "RETER", "JEITO", "HAVER", "SOBRE", "SONHO", "FUSAO",
                "OBITO", "CRIAR", "CULTO", "ROGAR", "MANSO", "AMENO", "ADIAR", "JUIZO", "PRESA", "FORMA",
                "BIRRA", "PEDIR", "PROSA", "VACUO", "MUNDO", "ESTAR", "FATOR", "TEMPO", "SERVO", "ARDUO",
                "FALAR", "VARAO", "FARSA", "ACASO", "FORTE", "FALTA", "CUNHO", "AINDA", "EXATO", "GRATO",
                "ETNIA", "FLUXO", "AMPLO", "SAUDE", "ACHAR", "FEIXE", "MAGOA", "ATUAR", "FELIZ", "TOMAR",
                "RITMO", "HEROI", "HASTE", "NOCAO", "VITAL", "CRUEL", "DETER", "LEVAR", "AMIGO", "CASAL",
                "GRACA", "VISAO", "ALGUM", "BEATA", "ORDEM", "CERTO", "RIGOR", "SAIDA", "EPICO", "LEITO",
                "BRAVO", "CAPAZ", "SALVO", "ACIMA", "MESMO", "DORSO", "POSSA", "CISAO", "VALHA", "UNICO",
                "VALOR", "FUGIR", "COISA", "VALIA", "TECER", "BANAL", "PUXAR", "SENDO", "DOCIL", "REGER",
                "POBRE", "ARIDO", "IGUAL", "MAIOR", "BREVE", "ATIVO", "OUVIR", "SELAR", "VELAR", "ANELO",
                "VIVER", "OLHAR", "MORAR", "GERIR", "SUMIR", "COPIA", "FACIL", "LEIGO", "MORTE", "TEDIO",
                "NOITE", "REMIR", "HOMEM", "UNIAO", "SEGUE", "AVIAO", "VENDO", "TERNO", "CESTA", "ACESO",
                "PEIXE", "VAZIO", "CLARO", "PARDO", "MESMA", "MOTIM", "SERIE", "PAUTA", "PASSO", "BANDO",
                "VELHO", "GRAVE", "OTICA", "ANCIA", "REVER", "IMUNE", "HOUVE", "ARCAR", "HAVIA", "CAUDA",
                "BOTAR", "FIXAR", "POSSO", "FLORA", "FENDA", "POUCO", "GENTE", "PONTO", "JOVEM", "QUOTA",
                "CAIXA", "SAIBA", "VETOR", "EXAME", "FOSSE", "FAUNA", "LUGAR", "FONTE", "PRAZO", "VERBA",
                "ARDOR", "CIUME", "NICHO", "PRESO", "OTIMO", "EPOCA", "JUNTO", "APOIO", "SOLTO", "PEGAR",
                "ASTRO", "CALMA", "CHEIO", "ORFAO", "FICAR", "APEGO", "APELO", "FEITO", "FATAL", "FOLGA",
                "OUTRO", "ASILO", "DERAM", "BATER", "CRIME", "SUPOR", "SIGNO", "PLANO", "FRACO", "TIRAR",
                "CARRO", "FICHA", "NAVIO", "BURRO", "AMBAS", "PARTE", "RUINA", "MUDAR", "MASSA", "CREDO",
                "BRISA", "LEGAL", "XEQUE", "CACHO", "COVER", "CAMPO", "NIVEL", "SETOR", "IDEAL", "REZAR",
                "OPTAR", "GOLPE", "BICHO", "INDIO", "PRAIA", "SINAL", "PASMO", "ABRIR", "FRUIR", "GENIO",
                "ICONE", "TROCA", "AGUDO", "EXIJO", "AROMA", "RUBRO", "LINDO", "PUDER", "PRADO", "REINO",
                "AUTOR", "IRMAO", "ZELAR", "CORPO", "SUPRA", "TRAGA", "CERTA", "IMPAR", "PISAR", "LIDAR",
                "RIVAL", "SABIA", "TERRA", "LIGAR", "RAPAZ", "RAIVA", "QUASE", "PAPEL", "RECEM", "CALDA",
                "ELITE", "MEIGA", "LIDER", "LIVRO", "RETEM", "FIRME", "VERSO", "SITIO", "TRAMA", "PROVA",
                "CICLO", "CHARA", "CHATO", "TRETA", "PREGO", "PLACA", "AMBOS", "SIGLA", "DENGO", "GIRIA",
                "RACHA", "BESTA", "VETAR", "MIDIA", "FORAM", "AMIGA", "LEIGA", "CONTA", "PLENA", "SARRO",
                "COQUE", "PREZA", "SOUBE", "NAIPE", "POSTO", "BOQUE", "PAREO", "CHATA", "MEIGO", "BONDE",
                "RETRO", "BODAS", "NEURA", "DIGNA", "NORMA", "BAIXA", "SURTA", "ACUDE", "XUCRO", "POLIR",
                "TRAVE", "DINDA", "MACRO", "ATEIA", "GURIA", "SURTO", "PARIU", "MALHO", "TROCO", "ZUMBA",
                "SAROU", "DEMOS", "ANDAR", "BOLOU", "BREGA", "DOTES", "TENDA", "PARES", "ARDUA", "BIOTA",
                "PARIS", "BODOU", "PUXOU", "SALVE", "BISCA", "VERBO", "IDOLO", "TEMOS", "SUAVE", "TRUTA",
                "VEZES", "VILAO", "GRUPO", "ROSCA", "LABIA", "JUDEU", "LINDA", "LORDE", "LADRA", "CULTA",
                "LAUDO", "TEXTO", "GRUDE", "SANTO", "ZUMBI", "PASSE", "TIETE", "MANHA", "GRIFE", "TRIBO",
                "ALUNO", "GOLFO", "FUNDO", "FORUM", "URUBU", "FRASE", "FUMAR", "SABAO", "SONSA", "QUEDA",
                "DEUSA", "SARAR", "SERRA", "RISCO", "BLEFE", "SEJAM", "CORRE", "BRUTO", "FERPA", "RALOU",
                "ORGAO", "PODEM", "SAQUE", "LAZER", "SALMO", "FARPA", "BUCHA", "BROTO", "MOSSA", "ETICO",
                "LETAL", "MINHA", "TABUA", "BRUXA", "VIVIA", "BUSCA", "INFRA", "TONGO", "PASSA", "INTER",
                "DADOS", "NOSSA", "LERDA", "RELOU", "CARGO", "BUCHO", "GOMAR", "GOSTO", "LOGAR", "FIADO",
                "ABONO", "CIVIL", "AMADA", "BOLAO", "OBRAS", "SAFRA", "DANCA", "EXIGE", "POMAR", "MAGIA",
                "IDOSO", "COROA", "PENTE", "TUTOR", "FACAO", "LENTO", "GRATA", "CLIMA", "PALIO", "LIXAR",
                "DINDO", "TRAGO", "VISTO", "FUNGO", "RAPTO", "OBESO", "JEJUM", "SORTE", "BEIJO", "PENSO",
                "CASAR", "TALHO", "MALHA", "FRAGA", "PIADA", "MIMAR", "MEXEU", "PODIO", "COSMO", "COCHO",
                "RAMAL", "AJUDA", "BODAR", "CACHE", "BOREL", "POETA", "COBRA", "ATIVA", "RUMOR", "ADORO",
                "LANCE", "JEGUE", "GREGO", "MICRO", "LENDA", "METRO", "PAGAR", "TESTE", "BOATO", "BUFAR",
                "DOBRO", "MUQUE", "CABRA", "TOSCA", "CULPA", "NATAL", "MAFIA", "LESAO", "FURIA", "SOGRA",
                "PRIMA", "COICE", "FRITO", "VERME", "PIADO", "POSTE", "CHINA", "PODRE", "DOLAR", "SADIA",
                "MAGRO", "DUZIA");

        //SharedPreferences para salvar os dados no celular do usuário
        //Cria um arquivo xml e dentro desse arqui, conseguimos salvar os dados
        //mode 0 - significa que esse arquivo que vai ser gerado só vai ser lido pelo nosso aplicativo
        SharedPreferences arquivos = getSharedPreferences(dadosApp, 0);

        if (arquivos.contains("pontos")){

            posicaoLista = arquivos.getInt("pontos", 0);
            nomeSelecionado = minhaLista.get(posicaoLista);

            txtPalavraCorreta.setText("A palavra é: " + nomeSelecionado);

        }else {

            posicaoLista = 0;
            nomeSelecionado = minhaLista.get(posicaoLista);

            txtPalavraCorreta.setText("A palavra é: " + nomeSelecionado);

        }

        return nomeSelecionado;

    }

    private void enviaLetraParaCampoTexto() {

        //If - Se
        if (qualLinha.equals("1")){

            if (txtTermo_Linha1_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha1_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha1_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha1_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha1_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha1_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha1_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha1_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha1_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha1_Coluna5.setText(digitaLetra);

            }

        }else if (qualLinha.equals("2")){

            if (txtTermo_Linha2_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha2_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha2_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha2_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha2_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha2_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha2_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha2_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha2_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha2_Coluna5.setText(digitaLetra);

            }

        }else if (qualLinha.equals("3")){

            if (txtTermo_Linha3_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha3_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha3_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha3_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha3_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha3_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha3_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha3_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha3_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha3_Coluna5.setText(digitaLetra);

            }

        }else if (qualLinha.equals("4")){

            if (txtTermo_Linha4_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha4_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha4_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha4_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha4_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha4_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha4_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha4_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha4_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha4_Coluna5.setText(digitaLetra);

            }

        }else if (qualLinha.equals("5")){

            if (txtTermo_Linha5_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha5_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha5_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha5_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha5_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha5_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha5_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha5_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha5_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha5_Coluna5.setText(digitaLetra);

            }

        }else if (qualLinha.equals("6")){

            if (txtTermo_Linha6_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha6_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha6_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha6_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha6_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha6_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha6_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha6_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha6_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha6_Coluna5.setText(digitaLetra);

            }

        }else if (qualLinha.equals("7")){

            if (txtTermo_Linha7_Coluna1.getText().toString().equals("-")){

                txtTermo_Linha7_Coluna1.setText(digitaLetra);

            }else if (txtTermo_Linha7_Coluna2.getText().toString().equals("-")){

                txtTermo_Linha7_Coluna2.setText(digitaLetra);

            }else if (txtTermo_Linha7_Coluna3.getText().toString().equals("-")){

                txtTermo_Linha7_Coluna3.setText(digitaLetra);

            }else if (txtTermo_Linha7_Coluna4.getText().toString().equals("-")){

                txtTermo_Linha7_Coluna4.setText(digitaLetra);

            }else if (txtTermo_Linha7_Coluna5.getText().toString().equals("-")){

                txtTermo_Linha7_Coluna5.setText(digitaLetra);

            }

        }

    }

    private void configuracoesIniciais() {

        qualLinha = "1";
        palavraCerta = listaPalavras5Letras();
        palavraCerta = palavraCerta.toUpperCase(); //Colocando todas as letras em maiusculo

        txtPalavraCorreta.setText("A palavra é: " + palavraCerta);
        txtPalavraCorreta.setVisibility(View.GONE);

        //Habilita o botão que envia a palavra
        btnEnviarPalavra.setEnabled(true);

        //Deixando visivel
        llBotoesLinha1.setVisibility(View.VISIBLE);
        llBotoesLinha2.setVisibility(View.VISIBLE);
        llBotoesLinha3.setVisibility(View.VISIBLE);

        //Ocultar
        btnJogarNovamente.setVisibility(View.GONE);
        txtResultado.setVisibility(View.GONE);

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

        //Vonta a cor do Background para cor cinza
        txtTermo_Linha1_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha1_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha1_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha1_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha1_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha2_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha2_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha2_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha2_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha2_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha3_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha3_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha3_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha3_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha3_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha4_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha4_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha4_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha4_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha4_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha5_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha5_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha5_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha5_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha5_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha6_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha6_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha6_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha6_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha6_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha7_Coluna1.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha7_Coluna2.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha7_Coluna3.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha7_Coluna4.setBackgroundColor(Color.parseColor("#E6E6E6"));
        txtTermo_Linha7_Coluna5.setBackgroundColor(Color.parseColor("#E6E6E6"));


        //Vonta a cor do Cor Fonte para cor preto
        txtTermo_Linha1_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha1_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha1_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha1_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha1_Coluna5.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha2_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha2_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha2_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha2_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha2_Coluna5.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha3_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha3_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha3_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha3_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha3_Coluna5.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha4_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha4_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha4_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha4_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha4_Coluna5.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha5_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha5_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha5_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha5_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha5_Coluna5.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha6_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha6_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha6_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha6_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha6_Coluna5.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha7_Coluna1.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha7_Coluna2.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha7_Coluna3.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha7_Coluna4.setTextColor(Color.parseColor("#000000"));
        txtTermo_Linha7_Coluna5.setTextColor(Color.parseColor("#000000"));

        //Zero o texto como se apagasse tudo
        txtTermo_Linha1_Coluna1.setText("-");
        txtTermo_Linha1_Coluna2.setText("-");
        txtTermo_Linha1_Coluna3.setText("-");
        txtTermo_Linha1_Coluna4.setText("-");
        txtTermo_Linha1_Coluna5.setText("-");
        txtTermo_Linha2_Coluna1.setText("-");
        txtTermo_Linha2_Coluna2.setText("-");
        txtTermo_Linha2_Coluna3.setText("-");
        txtTermo_Linha2_Coluna4.setText("-");
        txtTermo_Linha2_Coluna5.setText("-");
        txtTermo_Linha3_Coluna1.setText("-");
        txtTermo_Linha3_Coluna2.setText("-");
        txtTermo_Linha3_Coluna3.setText("-");
        txtTermo_Linha3_Coluna4.setText("-");
        txtTermo_Linha3_Coluna5.setText("-");
        txtTermo_Linha4_Coluna1.setText("-");
        txtTermo_Linha4_Coluna2.setText("-");
        txtTermo_Linha4_Coluna3.setText("-");
        txtTermo_Linha4_Coluna4.setText("-");
        txtTermo_Linha4_Coluna5.setText("-");
        txtTermo_Linha5_Coluna1.setText("-");
        txtTermo_Linha5_Coluna2.setText("-");
        txtTermo_Linha5_Coluna3.setText("-");
        txtTermo_Linha5_Coluna4.setText("-");
        txtTermo_Linha5_Coluna5.setText("-");
        txtTermo_Linha6_Coluna1.setText("-");
        txtTermo_Linha6_Coluna2.setText("-");
        txtTermo_Linha6_Coluna3.setText("-");
        txtTermo_Linha6_Coluna4.setText("-");
        txtTermo_Linha6_Coluna5.setText("-");
        txtTermo_Linha7_Coluna1.setText("-");
        txtTermo_Linha7_Coluna2.setText("-");
        txtTermo_Linha7_Coluna3.setText("-");
        txtTermo_Linha7_Coluna4.setText("-");
        txtTermo_Linha7_Coluna5.setText("-");

        //Muda a cor do Background para cinza nos botões
        buttonLetraQ.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraW.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraE.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraR.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraT.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraY.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraU.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraI.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraO.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraP.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraA.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraS.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraD.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraF.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraG.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraH.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraJ.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraK.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraL.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraZ.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraX.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraC.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraV.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraB.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraN.setBackgroundColor(Color.parseColor("#E6E6E6"));
        buttonLetraM.setBackgroundColor(Color.parseColor("#E6E6E6"));

        //Muda a cor do texto / fonte para preto nos botões
        buttonLetraQ.setTextColor(Color.parseColor("#000000"));
        buttonLetraW.setTextColor(Color.parseColor("#000000"));
        buttonLetraE.setTextColor(Color.parseColor("#000000"));
        buttonLetraR.setTextColor(Color.parseColor("#000000"));
        buttonLetraT.setTextColor(Color.parseColor("#000000"));
        buttonLetraY.setTextColor(Color.parseColor("#000000"));
        buttonLetraU.setTextColor(Color.parseColor("#000000"));
        buttonLetraI.setTextColor(Color.parseColor("#000000"));
        buttonLetraO.setTextColor(Color.parseColor("#000000"));
        buttonLetraP.setTextColor(Color.parseColor("#000000"));
        buttonLetraA.setTextColor(Color.parseColor("#000000"));
        buttonLetraS.setTextColor(Color.parseColor("#000000"));
        buttonLetraD.setTextColor(Color.parseColor("#000000"));
        buttonLetraF.setTextColor(Color.parseColor("#000000"));
        buttonLetraG.setTextColor(Color.parseColor("#000000"));
        buttonLetraH.setTextColor(Color.parseColor("#000000"));
        buttonLetraJ.setTextColor(Color.parseColor("#000000"));
        buttonLetraK.setTextColor(Color.parseColor("#000000"));
        buttonLetraL.setTextColor(Color.parseColor("#000000"));
        buttonLetraZ.setTextColor(Color.parseColor("#000000"));
        buttonLetraX.setTextColor(Color.parseColor("#000000"));
        buttonLetraC.setTextColor(Color.parseColor("#000000"));
        buttonLetraV.setTextColor(Color.parseColor("#000000"));
        buttonLetraB.setTextColor(Color.parseColor("#000000"));
        buttonLetraN.setTextColor(Color.parseColor("#000000"));
        buttonLetraM.setTextColor(Color.parseColor("#000000"));

    }
}