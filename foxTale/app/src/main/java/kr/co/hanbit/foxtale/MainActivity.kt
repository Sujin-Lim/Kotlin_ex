package kr.co.hanbit.foxtale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kr.co.hanbit.foxtale.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
            val intent = Intent(this,sub1Activity::class.java )
            startActivity(intent)
        }
    }
}