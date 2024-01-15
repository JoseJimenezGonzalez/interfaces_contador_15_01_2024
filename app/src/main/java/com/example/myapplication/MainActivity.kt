package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Codigo
        setCount()

        binding.btnContador.setOnClickListener {
            contador++
            setCount()
        }
        binding.btnContador.setOnLongClickListener {
            contador--
            setCount()
            true
        }
    }

    private fun setCount(){
        binding.tvContador.text = contador.toString()
    }

    //Guardar los cambios
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.run {
            putInt("contador", contador)
        }
    }
    //Los restauramos
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        contador = savedInstanceState.getInt("contador")
        setCount()
    }
}