package com.example.to02_pmdm_navia_juanmanuel.primeraApp
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.to02_pmdm_navia_juanmanuel.R
import com.example.to02_pmdm_navia_juanmanuel.databinding.ActivityFirstAppBinding


class primeraApp : AppCompatActivity() {

    private lateinit var binding: ActivityFirstAppBinding
    private val cambioDeEurosaDolares = 1.1 // 1 euro = 1.1 dólares
    private val cambioDeDolaresaEuros = 0.91 // 1 dólar = 0.91 euros

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFirstAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

      //titulo de la app
        supportActionBar?.title = "Conversor de Moneda"
    }

    // funcion Listener para el campo de entrada
    private fun setupListeners() {
        binding.etEurosyDolares.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateResult()
            }
            override fun afterTextChanged(s: Editable?) {}
        }) // Listener para los radio buttons
        binding.radioGroup.setOnCheckedChangeListener { _, _ ->
            calculateResult()
        }
    }
//funcion para calcular el resultado
    private fun calculateResult() {
        // Leer el valor ingresado
        val input = binding.etEurosyDolares.text.toString()
    // Limpiar el setTextresultado si no hay ninguna entrada
        if (input.isEmpty()) {
            binding.etResultado.setText("")
            return
        }

        // Convertir el valor a número Double
        val amount = input.toDoubleOrNull()
        if (amount == null) {
            binding.etResultado.setText("Error") // Mostrar error si el valor no es válido
            return
        }

        // Realizar la conversión según el radiobotón seleccionado
        val result = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioEurosaDolares -> amount * cambioDeEurosaDolares
            R.id.radioDolaresaEuros -> amount * cambioDeDolaresaEuros
            else -> 0.0
        }

        // Mostrar el resultado con formato dos decimales
        binding.etResultado.setText(String.format("%.2f", result))
    }
}