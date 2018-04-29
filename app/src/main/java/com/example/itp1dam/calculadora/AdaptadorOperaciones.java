package com.example.itp1dam.calculadora;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorOperaciones extends RecyclerView.Adapter<AdaptadorOperaciones.HolderOperacion>{

    private ArrayList<Operacion> operaciones;
    private Context contexto;
    private Historial mactiv;

    public AdaptadorOperaciones(ArrayList<Operacion> operaciones, Context contexto, Historial m) {
        this.operaciones = operaciones;
        this.contexto = contexto;
        this.mactiv = m;
    }

    public class HolderOperacion extends RecyclerView.ViewHolder{
        TextView tOperacion;

        HolderOperacion(View v){

            super(v);
            tOperacion = (TextView) v.findViewById(R.id.tOperacion);
        }
    }



    public void add(ArrayList<Operacion> operaciones){
        operaciones.clear();
        operaciones.addAll(operaciones);
    }

    public void refrescar(){
        notifyDataSetChanged();
    }

    @Override
    public HolderOperacion onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_operacion,
                        parent, false);
        HolderOperacion pvh = new HolderOperacion(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(HolderOperacion holder, int position) {
        holder.tOperacion.setText(operaciones.get(position).getNum1()+" "+operaciones.get(position).getOp()+" "+operaciones.get(position).getNum2()+"="+operaciones.get(position).getResul());
    }

    @Override
    public int getItemCount() {
        return operaciones.size();
    }
}
