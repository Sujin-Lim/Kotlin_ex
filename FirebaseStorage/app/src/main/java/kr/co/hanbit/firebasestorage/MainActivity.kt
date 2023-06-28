package kr.co.hanbit.firebasestorage

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kr.co.hanbit.firebasestorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val storage = Firebase.storage("gs://sujinl.appspot.com")

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnUpload.setOnClickListener{
            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent())
    { uri ->
        uploadImage(uri)
    }

    val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {isGranted ->
        if (isGranted) {
            galleryLauncher.launch("image/*")
        } else {
            Toast.makeText(baseContext,"외부 저장소 읽기 권한을 승인해야 사용할 수 있습니다",Toast.LENGTH_LONG).show()
        }
    }

    fun uploadImage(uri: Uri) {
        val fullPath = makeFilePath("images", "temp", uri)
        val imageRef = storage.getReference(fullPath)
        val uploadTask = imageRef.putFile(uri)

        uploadTask.addOnFailureListener {
            Log.d("스토리지","실패=>${it.message}")
        }.addOnSuccessListener { taskSnapshot ->
            Log.d("스토리지","성공 주소=>${fullPath}")
        }
    }

    fun makeFilePath(path: String, userId: String, uri: Uri): String {
        val mimeType = contentResolver.getType(uri) ?: "/none"
        val ext = mimeType.split("/")[1]
        val timeSuffix = System.currentTimeMillis()
        val filename = "${path}/${userId}_${timeSuffix}.${ext}"
        return filename
    }
}