package com.example.itp1dam.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    private TextView texto;
    private RecyclerView ListaOperaciones;
    private AdaptadorOperaciones adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaOperaciones = (RecyclerView) findViewById (R.id.ListaOperaciones);
        texto = (TextView) findViewById(R.id.texto);

        Intent intent = getIntent();
        //Extrayendo el extra de tipo cadena
        String op = intent.getStringExtra("op");
        texto.setText(op);

        BDOperaciones bd = new BDOperaciones(this);
        ArrayList<Operacion> operacions = bd.consultarOperacion(op);
        System.out.println("fuck"+operacions.get(0).getNum1());
        texto.setText(""+operacions.get(0).getNum1()+operacions.get(0).getOp());
        bd.cerrarBD();

        // Asigno la flecha de atras a la toolbar
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
        // Hago que cuando se pulse la flecha de atras se cierre la actividad
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        ListaOperaciones.setHasFixedSize(true);

        ListaOperaciones.addItemDecoration(new SpaceItemDecoration(this, R.dimen.list_space, true, true));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        ListaOperaciones.setLayoutManager(llm);

        adaptador = new AdaptadorOperaciones(operacions, this, this);

        ListaOperaciones.setAdapter(adaptador);
        adaptador.refrescar();
    }

}
