package com.hercankaya.yaatutarsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var OyunaBasla =findViewById<Button>(R.id.OyunaBasla)

        OyunaBasla.setOnClickListener {

            startActivity(Intent(this@MainActivity,OyunEkrani::class.java))
            /* Kullanıcı Yeni Oyun butonuna basınca oyun ekranına gidecek.*/
        }

        var Aciklama =findViewById<Button>(R.id.Aciklama)

        Aciklama.setOnClickListener {

            startActivity(Intent(this@MainActivity,AciklamaEkrani::class.java))
            /* Kullanıcı Açıklama butonuna basınca açıklama ekranına gidecek.*/
        }

    }
}