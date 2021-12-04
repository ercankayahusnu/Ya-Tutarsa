package com.hercankaya.yaatutarsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class OyunEkrani : AppCompatActivity() {
    private var randomsayi = 0
    private var sayac = 5
    private var fark = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun_ekrani)


        randomsayi = Random.nextInt(51) // 0 ile 50 arasında random sayı oluşturduk

        Log.e("Random sayı", randomsayi.toString()) //Log .e konsola sayı bastırdık
        //to.String() int veriyi string veriye döndürdük

        var tahminkontrol = findViewById<Button>(R.id.tahminkontrol)
        var tahmin = findViewById(R.id.tahmin) as EditText

        tahminkontrol.setOnClickListener {

            val kullanıcıtahmini = tahmin.text.toString().toInt()
            /*
            edit text den alınan sayı string olduğu için onu
            int yaptık
             */

            if (kullanıcıtahmini == randomsayi) {
                val intent = Intent(this@OyunEkrani, SonucEkrani::class.java)
                intent.putExtra("veri", true) /* sonuç ekranın arayüzünü değiştirmek için
                veri gönderimi yaptık .true değer olduğu için kazandınız yazacak*/
                intent.putExtra("sayac", sayac)
                finish() // backten sayfayı sildim (arkapalandan)
                startActivity(intent)
                return@setOnClickListener
            }
            // var yardim=findViewById(R.id.yardim) as TextView
            // var kalanhak=findViewById(R.id.kalanhak) as TextView

            sayac = sayac - 1//Butona her basmada 1 can sildik
            fark = Math.abs(randomsayi - kullanıcıtahmini) // fark daima pozitif olacaktır

            if (fark <= 5) {
                var yardim = findViewById(R.id.yardim) as TextView
                yardim.text = "ÇOK SICAK"

                var kalanhak = findViewById(R.id.kalanhak) as TextView
                kalanhak.text = "Kalan Hak :$sayac "
            } else if (fark <= 10) {
                var yardim = findViewById(R.id.yardim) as TextView
                yardim.text = "SICAK"

                var kalanhak = findViewById(R.id.kalanhak) as TextView
                kalanhak.text = "Kalan Hak :$sayac "
            } else if (fark <= 15) {
                var yardim = findViewById(R.id.yardim) as TextView
                yardim.text = "SOĞUK"

                var kalanhak = findViewById(R.id.kalanhak) as TextView
                kalanhak.text = "Kalan Hak :$sayac "
            } else {
                var yardim = findViewById(R.id.yardim) as TextView
                yardim.text = "ÇOK SOĞUK"

                var kalanhak = findViewById(R.id.kalanhak) as TextView
                kalanhak.text = "Kalan Hak :$sayac "
            }

            if (sayac == 0) {
                val intent = Intent(this@OyunEkrani, SonucEkrani::class.java)

                /* sonuç ekranın arayüzünü değiştirmek için
                veri gönderimi yaptık .true değer olduğu için kazandınız yazacak*/
                intent.putExtra("veri", false)
                finish()
                startActivity(intent)
            }

            tahmin.setText("") //edit text içerisini temizler
        }
    }
}