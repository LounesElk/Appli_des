package com.lounes.application_des;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class PageResult extends AppCompatActivity {
    private Button btRelancer;
    private Button btBack;
    private TextView txtNbrFace;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_result);

        btRelancer = (Button) findViewById(R.id.btRelancer);
        btBack = (Button) findViewById(R.id.btBack);
        txtNbrFace = (TextView) findViewById(R.id.txtNbrFace);
        txtResult = (TextView) findViewById(R.id.txtResult);

        Intent afficher = getIntent();
        String nbrFace = afficher.getStringExtra("nbrFace");
        String nbrDes = afficher.getStringExtra("nbrDes");
        int[] diffNbr = afficher.getIntArrayExtra("result");
        int resultat =0;
        txtNbrFace.setText("Le nombre de face choisit est de "+nbrFace+" faces.");

        for  (int i=0; i<Integer.valueOf(nbrDes); i++){
            resultat += diffNbr[i];
            if (i == Integer.valueOf(nbrDes)-1)
                txtResult.append(Integer.toString(diffNbr[i])+" = "+ Integer.toString(resultat));
            else
                txtResult.append(Integer.toString(diffNbr[i])+"+");
        }


        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onDestroy();}
        });

        btRelancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Relancer();}
        });
    }

    private void Relancer(){
        SecureRandom random = new SecureRandom();
        int nbr;
        Intent afficher = getIntent();
        String nbrFace = afficher.getStringExtra("nbrFace");
        String nbrDes = afficher.getStringExtra("nbrDes");
        int[] diffNbr = afficher.getIntArrayExtra("result");
        int resultat =0;


        for  (int i=0; i<Integer.valueOf(nbrDes); i++){ //Je relance des chiffes au hasard
            nbr = random.nextInt(Integer.valueOf(nbrFace))+1;
            diffNbr[i]=nbr;
        }
        txtResult.setText("");
        for  (int i=0; i<Integer.valueOf(nbrDes); i++){
            resultat += diffNbr[i];
            if (i == Integer.valueOf(nbrDes)-1)
                txtResult.append(Integer.toString(diffNbr[i])+" = "+ Integer.toString(resultat));
            else
                txtResult.append(Integer.toString(diffNbr[i])+"+");
        }
    }
}