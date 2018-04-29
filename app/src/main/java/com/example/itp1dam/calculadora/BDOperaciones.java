package com.example.itp1dam.calculadora;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDOperaciones extends SQLiteOpenHelper {

    private Context contexto;
    // Sentencia SQL para crear la tabla de Usuarios
    private final String SQLCREATE = "CREATE TABLE Operaciones (codigo INTEGER, num1 DECIMAL(10,5), op TEXT, num2 DECIMAL(10,5), resul DECIMAL(10,5))";
    // Sentencia SQL para eliminar la tabla de Usuarios
    private final String SQLDROP = "DROP TABLE IF EXISTS Operaciones";
    // Base de datos
    private SQLiteDatabase bd = null;
    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "DBOperaciones.db";

    public BDOperaciones(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL(SQLDROP);
        // Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(SQLCREATE);
    }

    public void cerrarBD() {
        if( bd != null )
            bd.close();
    }

    public void insertarValores(){
        // Obtengo los datos en modos de escritura
        bd = getWritableDatabase();
        String[] ops = {"","+","-","*","/","%"};
        // Si hemos abierto correctamente la base de datos
        if(bd != null) {
            long newRowId;
            //Insertamos 5 usuarios de ejemplo
            for (int i = 1; i <= 5; i++) {
                try {
                    // Creo un mapa con los valores a insertar
                    ContentValues values = new ContentValues();
                    values.put("codigo", i);
                    values.put("num1", 1);
                    values.put("op", ops[i]);
                    values.put("num2", 2);
                    values.put("resul", 3);
                    // Inserta la nueva fila, devolviendo el valor de la clave primaria de la nueva fila
                    newRowId = bd.insert("Operaciones", "", values);
                }
                catch (Exception e) {
                    newRowId = -1;
                    System.out.println("Error -> " + e.toString());
                }
            }
        }

    }

    public void insertarOperacion(String op, double num1, double num2, double resul){
        bd = getWritableDatabase();
        if(bd != null) {
            long newRowId;
            try {
                ContentValues values = new ContentValues();
                values.put("num1", num1);
                values.put("op", op);
                values.put("num2", num2);
                values.put("resul", resul);
                newRowId = bd.insert("Operaciones", "", values);
            } catch (Exception e) {
                newRowId = -1;
                System.out.println("Error -> " + e.toString());
            }
        }
    }

    public ArrayList<Operacion> consultarOperacion(String op)
    {
        ArrayList<Operacion> resultado = new ArrayList<>();
        // Obtengo los datos en modo de lectura
        bd = getReadableDatabase();
        // Si hemos abierto correctamente la base de datos
        if(bd != null)
        {
            // Defino la parte del WHERE
            String selection = "op LIKE ?";
            // Valores para borrar en orden
            String[] selectionArgs = { op };
            // Indico como quiero que se ordenen los resultados
            String sortOrder = "codigo ASC";
            // Creo el cursor de la consulta
            Cursor c = bd.query (
                            "Operaciones", // Tabla para consultar
                            null, // Columnas a devolver
                            selection, // Columnas de la clausula WHERE
                            selectionArgs, // Valores de la columna de la clausulaWHERE
                            null, // Valores de la clausula GROUP BY
                            null, // Valores de la clausula HAVING
                            sortOrder // Orden de la clausula ORDER BY
                    );
            // Obtengo los datos
            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    Operacion u = new Operacion( c.getDouble(1),c.getString(2).charAt(0),c.getDouble(3),c.getDouble(4));
                    resultado.add(u);
                } while (c.moveToNext());
            }
        }
        return resultado;
    }

}
