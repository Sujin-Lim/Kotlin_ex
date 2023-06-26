package kr.co.hanbit.permission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.hanbit.permission.databinding.ActivityMainBinding
import android.Manifest

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var activityResult: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        activityResult = registerForActivityResult(ActivityResultContracts.
        RequestPermission()) {isGranted->
            if (isGranted) {
                startProcess()
            } else {
                finish()
            }
        }

        binding.btnCamera.setOnClickListener {
            activityResult.launch(Manifest.permission.CAMERA)
        }
    }

    fun startProcess(){
        Toast.makeText(this, "카메라 실행", Toast.LENGTH_LONG).show()
    }
}