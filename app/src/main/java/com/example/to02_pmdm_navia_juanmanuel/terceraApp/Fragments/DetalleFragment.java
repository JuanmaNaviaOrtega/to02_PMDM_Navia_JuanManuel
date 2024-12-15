package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.to02_pmdm_navia_juanmanuel.databinding.FragmentDetalleSitioswebBinding;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.Tarea;

public class DetalleFragment extends Fragment {

    private FragmentDetalleSitioswebBinding binding;
    private Tarea tarea;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetalleSitioswebBinding.inflate(inflater, container, false);


        if (getArguments() != null) {
            tarea = (Tarea) getArguments().getSerializable("tarea"); // Clave "tarea"

            // Mostrar los detalles de la tarea
            if (tarea != null) {
                binding.imagenDetalleid.setImageResource(tarea.getImagenId());
                binding.tvNombreDetalle.setText(tarea.getNombre());
                binding.tvDescripcionDetalle.setText("Descripción: " + tarea.getDescripcion());
                binding.tvEmail.setText("Email: " + tarea.getEmailAdministrador());
            }
        }

        // Configuracion del botón para abrir la URL de la pagina web
        binding.btnAbrirUrl.setOnClickListener(v -> {
            if (tarea != null && tarea.getUrl() != null && !tarea.getUrl().isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tarea.getUrl()));
                startActivity(intent);
            }


        });
        // Configurar el TextView del emailAdministrador para que sea clickable y nos mande a la aplicación para mandar el correo electronico
        binding.tvEmail.setOnClickListener(v -> {
            if (tarea != null && tarea.getEmailAdministrador() != null && !tarea.getEmailAdministrador().isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + tarea.getEmailAdministrador())); // Usar la dirección de email de la tarea

                startActivity(Intent.createChooser(intent, "Enviar correo electrónico"));
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}