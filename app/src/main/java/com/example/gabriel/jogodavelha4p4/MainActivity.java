package com.example.gabriel.jogodavelha4p4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button[] arrayButton = new Button[17];
    private String vez = "X";
    private int jogadas = 0;
    private String[] matriz = new String[17];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaButtons();
        onClickButtons();

    }

    private void inicializaButtons(){
        arrayButton[1] = (Button) findViewById(R.id.btn1);
        arrayButton[2] = (Button) findViewById(R.id.btn2);
        arrayButton[3] = (Button) findViewById(R.id.btn3);
        arrayButton[4] = (Button) findViewById(R.id.btn4);
        arrayButton[5] = (Button) findViewById(R.id.btn5);
        arrayButton[6] = (Button) findViewById(R.id.btn6);
        arrayButton[7] = (Button) findViewById(R.id.btn7);
        arrayButton[8] = (Button) findViewById(R.id.btn8);
        arrayButton[9] = (Button) findViewById(R.id.btn9);
        arrayButton[10] = (Button) findViewById(R.id.btn10);
        arrayButton[11] = (Button) findViewById(R.id.btn11);
        arrayButton[12] = (Button) findViewById(R.id.btn12);
        arrayButton[13] = (Button) findViewById(R.id.btn13);
        arrayButton[14] = (Button) findViewById(R.id.btn14);
        arrayButton[15] = (Button) findViewById(R.id.btn15);
        arrayButton[16] = (Button) findViewById(R.id.btn16);
    }

    private void onClickButtons(){
        for (int x = 1; x<17;x++){
            final int finalX = x;
            arrayButton[finalX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jogada(finalX); int a = 1; a = a +2;
                }
            });
            matriz[x]="";
        }
    }

    private void jogada(int x){
        if(matriz[x] == ""){
            matriz[x] = vez;
            jogadas++;
            if (vez == "X"){
                vez = "O";
            }else{
                vez = "X";
            }
        }
        exibirButtons();
        verifica();
    }

    private void exibirButtons(){
        for (int x = 1; x<17;x++){
            arrayButton[x].setText(matriz[x]);
        }
    }

    private void verifica(){

        //horizontal
        if(matriz[1].equals(matriz[2]) && matriz[1].equals(matriz[3]) && matriz[1].equals(matriz[4]) && matriz[1].toString() != ""){
            ganhador(matriz[1]);
            return;
        }

        if(matriz[5].equals(matriz[6]) && matriz[5].equals(matriz[7]) && matriz[5].equals(matriz[8]) && matriz[5].toString() != ""){
            ganhador(matriz[5]);
            return;
        }

        if(matriz[9].equals(matriz[10]) && matriz[9].equals(matriz[11]) && matriz[9].equals(matriz[12]) && matriz[9].toString() != ""){
            ganhador(matriz[9]);
            return;
        }

        if(matriz[13].equals(matriz[14]) && matriz[13].equals(matriz[15]) && matriz[13].equals(matriz[16]) && matriz[13].toString() != "") {
            ganhador(matriz[13]);
            return;
        }

        //vertical

        if(matriz[1].equals(matriz[5]) && matriz[1].equals(matriz[9]) && matriz[1].equals(matriz[13]) && matriz[1].toString() != ""){
            ganhador(matriz[1]);
            return;
        }

        if(matriz[2].equals(matriz[6]) && matriz[2].equals(matriz[10]) && matriz[2].equals(matriz[14]) && matriz[2].toString() != ""){
            ganhador(matriz[2]);
            return;
        }

        if(matriz[3].equals(matriz[7]) && matriz[3].equals(matriz[11]) && matriz[3].equals(matriz[15]) && matriz[3].toString() != ""){
            ganhador(matriz[3]);
            return;
        }

        if(matriz[4].equals(matriz[8]) && matriz[4].equals(matriz[12]) && matriz[4].equals(matriz[16]) && matriz[4].toString() != "") {
            ganhador(matriz[4]);
            return;
        }

        //diagonal

        if(matriz[1].equals(matriz[6]) && matriz[1].equals(matriz[11]) && matriz[1].equals(matriz[16]) && matriz[1].toString() != ""){
            ganhador(matriz[1]);
            return;
        }

        if(matriz[4].equals(matriz[7]) && matriz[4].equals(matriz[10]) && matriz[4].equals(matriz[13]) && matriz[4].toString() != ""){
            ganhador(matriz[4]);
            return;
        }

        if (jogadas == 16){
            ganhador("");
            return;
        }
    }

    private void ganhador(String ganhador){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Resultado da Partida:");
        if (ganhador.equals("")){
            builder.setMessage("O Jogo Empatou!");
        }else{
            if (ganhador.equals("X")){
                builder.setMessage("O Jogador \"X\" Venceu!");
            }else{
                builder.setMessage("O Jogador \"O\" Venceu!");
            }
        }
        builder.setPositiveButton("Jogar Novamente", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                jogadas = 0;
                for (int x = 1;x<17;x++){
                    matriz[x]="";
                }
                exibirButtons();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
