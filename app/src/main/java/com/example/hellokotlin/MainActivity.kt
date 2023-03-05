package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.example.hellokotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding: ActivityMainBinding

    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tts = TextToSpeech(this, this)
        binding.tvHello.text = "Hola Kotlin!"
        binding.bRead.setOnClickListener {
            readText()
        }
    }

    private fun readText() {
        var message = binding.etWrite.text.toString()
        if (message.isEmpty()){
            Toast.makeText(this, "Introduzca un texto", Toast.LENGTH_SHORT).show()
            message="¿Como quieres que lea si no escribes nada?"
        }
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            binding.tvHello.text = "Listo!"
            tts!!.language= Locale("ES")
        } else {
            binding.tvHello.text = "No se puede :("
        }
    }

    override fun onDestroy() {
        if (tts!=null){
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}