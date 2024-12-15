package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Adaptadores;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.Tarea;
import com.example.to02_pmdm_navia_juanmanuel.databinding.ItemSitioswebsBinding;

import java.util.List;

public class SitiosWebsAdapter extends RecyclerView.Adapter<SitiosWebsAdapter.TareaViewHolder> {


    private List<Tarea> tareas;
    private final OnTareaClickListener onTareaClickListener;
    private final OnEliminarClickListener onEliminarClickListener;


    public SitiosWebsAdapter(List<Tarea> tareas, OnTareaClickListener onTareaClickListener, OnEliminarClickListener onEliminarClickListener) {
        this.tareas = tareas;
        this.onTareaClickListener = onTareaClickListener;
        this.onEliminarClickListener = onEliminarClickListener;
    }


    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSitioswebsBinding binding = ItemSitioswebsBinding.inflate(inflater, parent, false);
        return new TareaViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        Tarea tarea = tareas.get(position);
        holder.bind(tarea, onTareaClickListener, onEliminarClickListener);
    }


    @Override
    public int getItemCount() {
        return tareas.size();
    }


    public static class TareaViewHolder extends RecyclerView.ViewHolder {
        private final ItemSitioswebsBinding binding;


        public TareaViewHolder(@NonNull ItemSitioswebsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(Tarea tarea, OnTareaClickListener onTareaClickListener, OnEliminarClickListener onEliminarClickListener) {
            binding.tvNombreTarea.setText(tarea.getNombre());
binding.imagenDetalleid.setImageResource(tarea.getImagenId());
            binding.getRoot().setOnClickListener(v -> onTareaClickListener.onTareaClick(tarea));
            binding.btnEliminar.setOnClickListener(v -> onEliminarClickListener.onEliminarClick(getAdapterPosition()));
        }
    }


    // Interfaz para manejar clics en las tareas
    public interface OnTareaClickListener {
        void onTareaClick(Tarea tarea);
    }


    // Interfaz para manejar clics en eliminar
    public interface OnEliminarClickListener {
        void onEliminarClick(int position);
    }
}

