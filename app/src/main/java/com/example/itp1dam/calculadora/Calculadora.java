package com.example.itp1dam.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private double n1;
    private double n2;
    private TextView entrada;
    private TextView resultado;
    private ImageButton bLast;
    private ImageButton bBack;
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bC;
    private Button bSumar;
    private Button bRestar;
    private Button bDividir;
    private Button bMulti;
    private Button bResult;
    private Button bDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        entrada=(TextView)findViewById(R.id.entrada);
        resultado=(TextView)findViewById(R.id.resultado);
        bLast=(ImageButton)findViewById(R.id.bLast);
        bBack=(ImageButton)findViewById(R.id.bBack);
        b0=(Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        bC=(Button)findViewById(R.id.bC);
        bSumar=(Button)findViewById(R.id.bSumar);
        bRestar=(Button)findViewById(R.id.bRestar);
        bDividir=(Button)findViewById(R.id.bDividir);
        bMulti=(Button)findViewById(R.id.bMulti);
        bResult=(Button)findViewById(R.id.bResult);
        bDecimal=(Button)findViewById(R.id.bDecimal);

        bLast.setOnClickListener(this);
        bBack.setOnClickListener(this);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bC.setOnClickListener(this);
        bSumar.setOnClickListener(this);
        bRestar.setOnClickListener(this);
        bDividir.setOnClickListener(this);
        bMulti.setOnClickListener(this);
        bResult.setOnClickListener(this);
        bDecimal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.b0:
                    entrada.append("0");
                break;
            case R.id.b1:
                	entrada.append("1");
                break;
            case R.id.b2:
                	entrada.append("2");
                break;
            case R.id.b3:
                	entrada.append("3");
                break;
            case R.id.b4:
                	entrada.append("4");
                break;
            case R.id.b5:
                	entrada.append("5");
                break;
            case R.id.b6:
                	entrada.append("6");
                break;
            case R.id.b7:
                	entrada.append("7");
                break;
            case R.id.b8:
                	entrada.append("8");
                break;
            case R.id.b9:
                	entrada.append("9");
                break;
            case R.id.bC:
                entrada.setText("");
                resultado.setText("");
                break;
            case R.id.bSumar:
                n1=Integer.parseInt(String.valueOf(entrada.getText()));
                resultado.setText("+ "+entrada.getText());
                entrada.setText("");
                break;

        }
    }
}
