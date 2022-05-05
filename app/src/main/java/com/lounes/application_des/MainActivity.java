package com.lounes.application_des;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private Spinner spNbrDes;
    private String nbrD;
    private String nbrD_;
    private int positionInt_Nbr;
    private Spinner spFace;
    private String nbrF;
    private String nbrF_;
    private int positionInt_F;
    private Button btLancer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spNbrDes = (Spinner) findViewById(R.id.spNbrDes);
        spFace = (Spinner) findViewById(R.id.spFace);
        btLancer = (Button) findViewById(R.id.btLancer);

        ArrayAdapter<CharSequence> nbrDes = ArrayAdapter.createFromResource(this,R.array.NbrDes, android.R.layout.simple_spinner_item);
        nbrDes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNbrDes.setAdapter(nbrDes);

       spNbrDes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               nbrD = adapterView.getItemAtPosition(i).toString();
               nbrD_= String.valueOf(i);
               positionInt_Nbr = Integer.valueOf(nbrD_);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

        ArrayAdapter<CharSequence> faceDes = ArrayAdapter.createFromResource(this,R.array.FaceDes, android.R.layout.simple_spinner_item);
        faceDes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFace.setAdapter(faceDes);

        spFace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nbrF = adapterView.getItemAtPosition(i).toString();
                nbrF_= String.valueOf(i);
                positionInt_F= Integer.valueOf(nbrF_);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btLancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lancer();
            }
        });
    }

    private void Lancer(){
        /* test du Random
        SecureRandom random = new SecureRandom();
        int lo = random.nextInt(20);
         String t = Integer.toString(lo);
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();

        for  (int i=0; i<=positionInt_Nbr; i++){
            String t = Integer.toString(result[i]);
            Toast.makeText(this, "oui", Toast.LENGTH_SHORT).show();
        }
        */

        int k = positionInt_Nbr+1 ;
        String t = Integer.toString(k);
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();

        /*
        Intent intent = new Intent(this, PageResult.class);
        SecureRandom random = new SecureRandom();
        int[] result = new int[4];

        int nbr;
        if (positionInt_F==0){//f4
            for  (int i=0; i<=positionInt_Nbr; i++){
                nbr =random.nextInt(4); // tester plus tard aves le positionInt_F
                result[i]=nbr;
            }
        }



        if (positionInt_F==1){//f6

        }
        if (positionInt_F==2){//f8

        }
        if (positionInt_F==3){//f10

        }
        if (positionInt_F==4){//f12

        }
        if (positionInt_F==4){//f20

        }*/


    }
}




