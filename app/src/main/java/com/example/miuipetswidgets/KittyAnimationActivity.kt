package com.example.miuipetswidgets

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.miuipetswidgets.databinding.ActivityAnimationBinding

class KittyAnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Теперь можно использовать представления через привязку
        val animationImageView: ImageView = binding.animationImageView
        animationImageView.setImageResource(R.drawable.animation_list)
        val animationDrawable = animationImageView.background as? AnimationDrawable
        animationDrawable?.start()
    }

    companion object {
        // Дополнительные статические члены класса могут быть объявлены здесь, если это необходимо
    }
}