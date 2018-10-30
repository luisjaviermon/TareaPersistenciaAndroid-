package com.example.proteco.clase6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


/*

persistencia de datos: hacer que un dato exista y pueda ser consutado por un tiempo definido por el usuario o la app

Formas de almacenamiento en Android
->Shared Preference: informacion a la que se puede acceder de manera publica
->Internal storage: almacenar la info dentro de la mem del disp
->External storage:
->databases

 */