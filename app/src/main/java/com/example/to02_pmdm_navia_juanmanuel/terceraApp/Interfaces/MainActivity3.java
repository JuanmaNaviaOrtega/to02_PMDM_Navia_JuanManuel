package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Interfaces;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.to02_pmdm_navia_juanmanuel.R;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Adaptadores.SitiosWebsAdapter;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades.Tarea;
import com.example.to02_pmdm_navia_juanmanuel.terceraApp.Fragments.DetalleFragment;
import com.example.to02_pmdm_navia_juanmanuel.databinding.ActivityMain3Binding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements iComunicaFragments {

    private ActivityMain3Binding binding;
    private SitiosWebsAdapter adapter;
    private List<Tarea> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar View Binding
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar lista de tareas
        tareas = new ArrayList<>();
        tareas.add(new Tarea("DeepMind", R.drawable.mind, "https://www.deepmind.com","DeepMind es una subsidiaria de Alphabet que se enfoca en investigación avanzada en inteligencia artificial, con herramientas y proyectos para programadores y científicos." , "info@deepmind.com"));
        tareas.add(new Tarea("TensorFlow", R.drawable.tenssor, "https://www.tensorflow.org", "TensorFlow es una plataforma de machine learning de código abierto que facilita la creación de modelos de IA para desarrolladores en diversos lenguajes de programación.", "tensorflow-support@google.com"));
        tareas.add(new Tarea("OpenAI", R.drawable.openai, "https://www.openai.com",                 "OpenAI es una organización líder en el desarrollo de modelos de lenguaje y herramientas de IA, como GPT-4 y DALL·E, utilizadas para programación asistida y creación de contenido.", "support@openai.com"));
        tareas.add(new Tarea("GitHub Copilot", R.drawable.githubcopilott,"https://github.com/features/copilot", "GitHub Copilot, impulsado por OpenAI, es un asistente de codificación de IA que ayuda a los programadores a escribir código más rápido y con mayor eficiencia.", "copilot-support@github.com"));
        tareas.add(new Tarea("Hugging Face", R.drawable.faceeee,"https://huggingface.co/","Hugging Face ofrece herramientas avanzadas de procesamiento del lenguaje natural y modelos de machine learning, con una biblioteca activa y comunidad para desarrolladores.", "api@huggingface.co"));
        // Configurar RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SitiosWebsAdapter(tareas,
                this::mostrarDetalles,
                position -> confirmarEliminacion(position));
        binding.recyclerView.setAdapter(adapter);

        // Configurar FloatingActionButton para agregar las tareas
        binding.fabAdd.setOnClickListener(v -> mostrarDialogoAgregarTarea());
    }


      // Método para mostrar los  detalles de una tarea que seleccionemos

    private void mostrarDetalles(Tarea tarea) {
        DetalleFragment detalleFragment = new DetalleFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("tarea", tarea);
        detalleFragment.setArguments(bundle);

        // Reemplazar el fragmento actual con el fragmento de detalles
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, detalleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



         // Método para confirmar la eliminación de una tarea que seleccionemos

    private void confirmarEliminacion(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar Tarea")
                .setMessage("¿Estás seguro de que deseas eliminar esta tarea?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    tareas.remove(position);
                    adapter.notifyItemRemoved(position);
                })
                .setNegativeButton("No", null)
                .show();
    }


     //Método para  agregar una nueva tarea

    private void mostrarDialogoAgregarTarea() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Agregar Nueva Tarea");

        builder.setMessage("Ingresa una nueva tarea");

        builder.setPositiveButton("Agregar", (dialog, which) -> {
            // Agregar una tarea
           tareas.add(new Tarea("Notion AI", R.drawable.notionn,"https://www.notion.so" , " Asistente para organización y productividad que usa IA para notas, planificación y generación de texto", "support@makenotion.com"));
            adapter.notifyItemInserted(tareas.size() - 1);
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }


     //Método de la interfaz iComunicaFragments para recibir las tareas desde los fragmentos.
    @Override
    public void enviarTarea(Tarea tarea) {
        mostrarDetalles(tarea);
    }
}
