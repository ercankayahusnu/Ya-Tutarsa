package com.hercankaya.yaatutarsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SonucEkrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_ekrani)

        val sonuc = intent.getBooleanExtra("veri", false)//gelen veriyi aldık
        val sayac = intent.getIntExtra("sayac", 0)
        Log.e("sayac", sayac.toString())
        var textSonuc = findViewById(R.id.textSonuc) as TextView
        var textPuan = findViewById(R.id.puan) as TextView
        val imageView = findViewById<ImageView>(R.id.imageView)

        val toplamPuan = sayac * 20
        var txtSonuc = ""

        if (sonuc) {
            txtSonuc = "KAZANDINIZ"
            imageView.setImageResource(R.drawable.kazandin)
        } else {
            txtSonuc = "KAYBETTİNİZ"
            imageView.setImageResource(R.drawable.kaybettin)
        }

        textSonuc.text = txtSonuc
        textPuan.text = "PUANINIZ: " + toplamPuan.toString()

        var buttontekrar = findViewById<Button>(R.id.buttontekrar)
        buttontekrar.setOnClickListener {
            val intent = Intent(this@SonucEkrani, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}