package com.example.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class MainActivity : AppCompatActivity() {

    var btnGenerateSpeech: Button? = null
    var textToSpeech: EditText? = null
    var txtSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtSpeech = TextToSpeech(this, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR){
                val locSpanish = Locale("spa", "MEX")
                txtSpeech!!.language = locSpanish
            }
        })

        btnGenerateSpeech = findViewById(R.id.btnGenerateSpeech)
        textToSpeech = findViewById(R.id.textToSpeech)

        btnGenerateSpeech!!.setOnClickListener {
            var textTo = textToSpeech!!.text.toString()
            txtSpeech!!.speak(textTo, TextToSpeech.QUEUE_ADD, null)
        }

    }
}