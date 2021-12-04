package com.hercankaya.yaatutarsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AciklamaEkrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aciklama_ekrani)

        var geri =findViewById<Button>(R.id.geri)

        geri.setOnClickListener {
            startActivity(Intent(this@AciklamaEkrani,MainActivity::class.java))
            /* Kullanıcı geri butonuna basınca başlama ekranına gidecek.*/
        }
    }
}