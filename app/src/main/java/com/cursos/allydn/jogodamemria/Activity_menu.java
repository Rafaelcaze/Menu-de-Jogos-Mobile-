package com.cursos.allydn.jogodamemria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_menu extends AppCompatActivity {
    private ImageButton Tela_jogos_L1xC1;
    private ImageButton Tela_jogos_L1xC2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inicializa os componentes visuais
        Tela_jogos_L1xC1 = findViewById(R.id.btnTela_jogos_L1xC1);
        Tela_jogos_L1xC2 = findViewById(R.id.btnTela_jogos_L1xC2);

        // Define os listeners para os botões
        Tela_jogos_L1xC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela1 = new Intent(Activity_menu.this, MainActivity.class);
                startActivity(abreTela1);
            }
        });

        Tela_jogos_L1xC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(Activity_menu.this, MainActivity2.class);
                startActivity(abreTela);
            }
        });
    }
}
