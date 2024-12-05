package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.sitioWeb;
import com.example.to02_pmdm_navia_juanmanuel.R;

import java.util.ArrayList;

public class sitioWebAdapter extends RecyclerView.Adapter<sitioWebAdapter.ViewHolder> {

    private final ArrayList<sitioWeb> listaSitioWebs;
    private final Context context;
    private final OnPersonaClickListener listener;

    public interface OnPersonaClickListener {
        void onPersonaClick(sitioWeb sitioWeb);
    }

    public sitioWebAdapter(ArrayList<sitioWeb> listaSitioWebs, Context context, OnPersonaClickListener listener) {
        this.listaSitioWebs = listaSitioWebs;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_sitioweb, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        sitioWeb sitioWeb = listaSitioWebs.get(position);
        holder.nombre.setText(sitioWeb.getNombre());
        holder.imagen.setImageResource(sitioWeb.getImagenId());

        holder.itemView.setOnClickListener(v -> listener.onPersonaClick(sitioWeb));
    }

    @Override
    public int getItemCount() {
        return listaSitioWebs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        ImageView imagen;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombres);
            imagen = itemView.findViewById(R.id.imagen_persona);
        }
    }
}
