package com.lounes.application_des;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class PageResult extends AppCompatActivity {
    private Button btRelancer;
    private Button btBack;
    private TextView txtNbrFace;
    private TextView txtResult;

    private TextView txtFinald1;
    private TextView txtFinald2;
    private TextView txtFinald3;
    private TextView txtFinald4;
    private TextView txtFinald5;

    private ImageView d1;
    private ImageView d2;
    private ImageView d4;
    private ImageView d5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_result);

        btRelancer = (Button) findViewById(R.id.btRelancer);
        btBack = (Button) findViewById(R.id.btBack);
        txtNbrFace = (TextView) findViewById(R.id.txtNbrFace);
        txtResult = (TextView) findViewById(R.id.txtResultDee);

        txtFinald1 = (TextView) findViewById(R.id.txtResultFinalD1);
        txtFinald2 = (TextView) findViewById(R.id.txtResultFinalD2);
        txtFinald3 = (TextView) findViewById(R.id.txtResultFinalD3);
        txtFinald4 = (TextView) findViewById(R.id.txtResultFinalD4);
        txtFinald4 = (TextView) findViewById(R.id.txtResultFinalD5);

        d1 = (ImageView) findViewById(R.id.d1);
        d2 = (ImageView) findViewById(R.id.d2);
        d4 = (ImageView) findViewById(R.id.d4);
        d5 = (ImageView) findViewById(R.id.d5);

        d1.setImageResource(R.drawable.db6);
        d2.setImageResource(R.drawable.db6);
        d4.setImageResource(R.drawable.db6);
        d5.setImageResource(R.drawable.db6);

        Intent afficher = getIntent();
        String nbrFace = afficher.getStringExtra("nbrFace");
        String nbrDes = afficher.getStringExtra("nbrDes");
        int[] diffNbr = afficher.getIntArrayExtra("result");
        int resultat =0;
        txtNbrFace.setText("Le nombre de face choisit est de "+nbrFace+" faces.");

        for  (int i=0; i<Integer.valueOf(nbrDes); i++){
            resultat += diffNbr[i];
            if (i+1 == 1){
                txtResult.append("Le "+Integer.toString(i+1)+"er dés vaut "+Integer.toString(diffNbr[i])+"\n");
                txtFinald1.setText(Integer.toString(diffNbr[i]));}
            else
                txtResult.append("Le "+Integer.toString(i+1)+"ème dés vaut "+Integer.toString(diffNbr[i])+"\n");
                if (i+1 == 2){
                    d1.setImageResource(R.drawable.nd6);
                    txtFinald2.setText("           "+Integer.toString(diffNbr[i]));
                }
                if (i+1 == 3){
                    d2.setImageResource(R.drawable.nd6);
                    txtFinald2.setText(Integer.toString(diffNbr[i])+"           ");
                }
        }
        txtResult.append("Le résultat vaut "+resultat);



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
            if (i+1 == 1)
                txtResult.append("Le "+Integer.toString(i+1)+"er dés vaut "+Integer.toString(diffNbr[i])+"\n");
            else
                txtResult.append("Le "+Integer.toString(i+1)+"ème dés vaut "+Integer.toString(diffNbr[i])+"\n");
        }
        txtResult.append("Le résultat vaut "+resultat);
        txtFinald1.setText(Integer.toString(resultat));
    }
}