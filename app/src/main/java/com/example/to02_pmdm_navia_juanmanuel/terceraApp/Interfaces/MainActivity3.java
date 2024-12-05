package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Interfaces;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.sitioWeb;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Fragments.DetallesitioWebFragment;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Fragments.sitioWebFragment;
import com.example.to02_pmdm_navia_juanmanuel.R;

public class MainActivity3 extends AppCompatActivity implements iComunicaFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Cargar directamente el fragmento de la lista de personas
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new sitioWebFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void enviarPersona(sitioWeb sitioWeb) {
        // Crear el fragmento de detalles y enviarle los datos
        DetallesitioWebFragment detalleFragment = new DetallesitioWebFragment();

        // Utilizar un bundle para pasar los datos
        Bundle bundle = new Bundle();
        bundle.putSerializable("objeto", sitioWeb);
        detalleFragment.setArguments(bundle);

        // Reemplazar el fragmento actual con el de detalles
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, detalleFragment);
        fragmentTransaction.addToBackStack(null); // Añadir a la pila para permitir regresar
        fragmentTransaction.commit();
    }
}
