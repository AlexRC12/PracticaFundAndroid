package com.example.practicafundandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.practicafundandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var user = "Alex14"
    var pass = "Riquelme14"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_constraint)

        //Cargamos los usuarios y contraseña que esten almacenados en sharedPreferences
        loadFromPreferences()

    }


    //Crearemos una función para cargar el usuario y contraseña guardado en el dispositivo
    private fun loadFromPreferences() {
        //Para buscar el usuario
        getPreferences(Context.MODE_PRIVATE).apply{
            Log.w("Tag", "${getString("Usuario","")}")
        }

        //Para buscar la contraseña
        getPreferences(Context.MODE_PRIVATE).apply{
            Log.w("Tag", "${getString("Contraseña", "")}")
        }

    }


    //Creamos código para que cuando se detenga la aplicación se almacenen los valores en sharedPreferences
    override fun onStop() {
        saveFromPreferences()
        super.onStop()
    }


    //Creamos una función para guardar el usuario y contraseña
    private fun saveFromPreferences(){

        //Para guardar el usuario y contraseña
        getPreferences(Context.MODE_PRIVATE).edit().apply{
            putString("Usuario", user)
            putString("Contraseña", pass)
            apply()
        }


    }

}