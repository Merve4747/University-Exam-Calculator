package com.qrread.ortalama_hesapla

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate

import com.qrread.ortalama_hesapla.databinding.ActivityMainBinding;

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonHesapla.setOnClickListener {
            if (binding.editTextNumber1.text.isNotEmpty() && binding.editTextNumber2.text.isNotEmpty()) {
                var Vize = binding.editTextNumber1.text.toString().toInt()
                var Final = binding.editTextNumber2.text.toString().toInt()
                var ortalama: Double = ((Vize*0.40)+(Final*0.60)).toDouble()

                if(Final<50){
                    binding.sonucText.text= ortalama.toString()+" "+"Final Notu 50 Altında Kaldınız"
                    binding.sonucText.setTextColor(getColor(R.color.red))
                }else if(ortalama>=50){
                    binding.sonucText.text= ortalama.toString()+" "+"Geçtiniz"
                    binding.sonucText.setTextColor(getColor(R.color.green))
                }
                else{
                    binding.sonucText.text= ortalama.toString()+" "+"Kaldınız"
                    binding.sonucText.setTextColor(getColor(R.color.red))
                }

            } else {
                binding.sonucText.text = "Sınav Notunuzu Giriniz!"
                binding.sonucText.setTextColor(getColor(R.color.red))
            }
        }
    }

}



