package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Adaptadores.SitiosWebsAdapter;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.Tarea;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Interfaces.iComunicaFragments;
import com.example.to02_pmdm_navia_juanmanuel.databinding.ListasitioswebFragmentBinding;
import java.util.ArrayList;

public class listaSitiosWebsFragment extends Fragment {

    private ListasitioswebFragmentBinding binding;
    private ArrayList<Tarea> listaTareas;
    private iComunicaFragments interfaceComunicaFragments;
    private SitiosWebsAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof iComunicaFragments) {
            interfaceComunicaFragments = (iComunicaFragments) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement iComunicaFragments");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interfaceComunicaFragments = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Configurar ViewBinding
        binding = ListasitioswebFragmentBinding.inflate(inflater, container, false);

        // Configurar el RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Inicializar el adaptador
        adapter = new SitiosWebsAdapter(listaTareas,
                tarea -> {

                    interfaceComunicaFragments.enviarTarea(tarea);
                },
                position -> {

                    listaTareas.remove(position);
                    adapter.notifyItemRemoved(position);
                });

        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}
