package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.sitioWeb;
import com.example.to02_pmdm_navia_juanmanuel.R;

public class DetallesitioWebFragment extends Fragment {
    private TextView nombreDetalle, linkDetalle, descripcionDetalle, emailDetalle;
    private ImageView imagenDetalle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalle_sitioweb_fragment, container, false);

        nombreDetalle = view.findViewById(R.id.nombre_detalle);
        linkDetalle = view.findViewById(R.id.link_detalle);
        descripcionDetalle = view.findViewById(R.id.descripcion_detalle);
        emailDetalle = view.findViewById(R.id.email_detalle);
        imagenDetalle = view.findViewById(R.id.imagen_detalleid);

        if (getArguments() != null) {
            sitioWeb persona = (sitioWeb) getArguments().getSerializable("objeto");
            if (persona != null) {
                nombreDetalle.setText(persona.getNombre());
                linkDetalle.setText("Link: " + persona.getLink());
                descripcionDetalle.setText("Descripción: " + persona.getDescripcion());
                emailDetalle.setText("Email: " + persona.getEmailAdministrador());
                imagenDetalle.setImageResource(persona.getImagenId());
            }
        }

        return view;
    }
}
