package kr.co.hanbit.foxtale

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class sub1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub1)

        val img1 = findViewById<ImageView>(R.id.imageView)
        img1.setImageResource(android.R.drawable.btn_star_big_on)
    }
}