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
import androidx.recyclerview.widget.RecyclerView;

import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Adaptadores.sitioWebAdapter;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.sitioWeb;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Interfaces.iComunicaFragments;
import com.example.to02_pmdm_navia_juanmanuel.R;

import java.util.ArrayList;

public class sitioWebFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<sitioWeb> listaSitioWebs;
    private iComunicaFragments interfaceComunicaFragments;

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
        View view = inflater.inflate(R.layout.sitioweb_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Cargar datos de ejemplo
        listaSitioWebs = new ArrayList<>();
        listaSitioWebs.add(new sitioWeb("DeepMind", R.drawable.mind, "https://www.deepmind.com","DeepMind es una subsidiaria de Alphabet que se enfoca en investigación avanzada en inteligencia artificial, con herramientas y proyectos para programadores y científicos." , "info@deepmind.com"));
        listaSitioWebs.add(new sitioWeb("TensorFlow", R.drawable.tenssor, "https://www.tensorflow.org", "TensorFlow es una plataforma de machine learning de código abierto que facilita la creación de modelos de IA para desarrolladores en diversos lenguajes de programación.", "tensorflow-support@google.com"));
        listaSitioWebs.add(new sitioWeb("OpenAI", R.drawable.openai, "https://www.openai.com",                 "OpenAI es una organización líder en el desarrollo de modelos de lenguaje y herramientas de IA, como GPT-4 y DALL·E, utilizadas para programación asistida y creación de contenido.", "support@openai.com"));
        listaSitioWebs.add(new sitioWeb("GitHub Copilot", R.drawable.githubcopilott,"https://github.com/features/copilot", "GitHub Copilot, impulsado por OpenAI, es un asistente de codificación de IA que ayuda a los programadores a escribir código más rápido y con mayor eficiencia.", "copilot-support@github.com"));
        listaSitioWebs.add(new sitioWeb("Hugging Face", R.drawable.faceeee,"https://huggingface.co/","Hugging Face ofrece herramientas avanzadas de procesamiento del lenguaje natural y modelos de machine learning, con una biblioteca activa y comunidad para desarrolladores.", "api@huggingface.co"));


        // Configurar el adaptador
        sitioWebAdapter adapter = new sitioWebAdapter(listaSitioWebs, getContext(), persona -> {
            // Enviar la persona seleccionada al activity
            interfaceComunicaFragments.enviarPersona(persona);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}
