package com.example.itp1dam.calculadora;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculadora extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener  {

    private double n1;
    private double n2;
    private char op=' ';
    private String last;
    String entradatxt;
    String resultadotxt;
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
    private Button bResto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDOperaciones bd = new BDOperaciones(this);
        if(bd.getReadableDatabase()!=null)
            bd.insertarValores();
        bd.cerrarBD();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        bResto=(Button)findViewById(R.id.bResto);

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
        bResto.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_hDivisiones) {
            Intent intent = new Intent(this, Historial.class);
            intent.putExtra("op", "/");
            startActivity(intent);
        } else if (id == R.id.nav_hProductos) {
            Intent intent = new Intent(this, Historial.class);
            intent.putExtra("op", "*");
            startActivity(intent);
        } else if (id == R.id.nav_hRestas) {
            Intent intent = new Intent(this, Historial.class);
            intent.putExtra("op", "-");
            startActivity(intent);
        } else if (id == R.id.nav_hRestos) {
            Intent intent = new Intent(this, Historial.class);
            intent.putExtra("op", "/%");
            startActivity(intent);
        } else if (id == R.id.nav_hSumas) {
            Intent intent = new Intent(this, Historial.class);
            intent.putExtra("op", "+");
            startActivity(intent);
        } else if (id == R.id.nav_hTodo) {
            Intent intent = new Intent(this, Historial.class);
            intent.putExtra("op", "%");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void borrar(){
        entrada.setText(null);
        resultado.setText(null);
        entradatxt=null;
        resultadotxt=null;
        n1=0;
        n2=0;
        op=' ';
    }

    @Override
    public void onClick(View v){
        entradatxt = String.valueOf(entrada.getText());
        resultadotxt = String.valueOf(resultado.getText());
        if (!entradatxt.isEmpty())
            try {
                n1 = Double.parseDouble(entradatxt);
            }catch (NumberFormatException ex){
                entrada.setText("");
                resultado.setText("");
            }

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
                borrar();
                break;
            case R.id.bSumar:
                op='+';
                operacion();
                break;
            case R.id.bRestar:
                op='-';
                operacion();
                break;
            case R.id.bMulti:
                op='*';
                operacion();
                break;
            case R.id.bDividir:
                op='/';
                operacion();
                break;
            case R.id.bResto:
                op='%';
                operacion();
                break;
            case R.id.bLast:
                Toast toast = Toast.makeText(getApplicationContext(), last, Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.bBack:
                if (!entradatxt.isEmpty() && entradatxt!=null) {
                    entrada.setText(entradatxt.substring(0, entradatxt.length() - 1));
                }
                break;
            case R.id.bDecimal:
                if (!entradatxt.isEmpty() && entradatxt!=null && !entradatxt.contains(".")) {
                    entrada.setText(entradatxt+".");
                }
                break;
            case R.id.bResult:
                if(op!=' ') {
                    double resul = 0;
                    resultado.setText(resultadotxt + entradatxt);
                    switch (op) {
                        case '+':
                            resul = n1 + n2;
                            break;
                        case '-':
                            resul = n1 - n2;
                            break;
                        case '*':
                            resul = n1 * n2;
                            break;
                        case '/':
                            resul = n1 / n2;
                            break;
                        case '%':
                            resul = n1 % n2;
                            break;
                    }
                    BDOperaciones bd = new BDOperaciones(this);
                    bd.insertarOperacion(""+op,n1,n2,resul);
                    entrada.setText("" + resul);
                    last = "Última operación:"+n2 + " " + op + " " + n1 + "=" + resul;
                    op = ' ';

                }
                break;

        }
    }

    public void operacion(){
        if (!entradatxt.isEmpty() && entradatxt != null) {
            n2 = n1;
            resultado.setText(entradatxt+op);
            entrada.setText("");
        }
    }
}
