package kr.co.hanbit.test2

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 04까지
        var button1 = findViewById<Button>(R.id.button1)
//
//        button1.setOnClickListener{
////            var dlg = AlertDialog.Builder(this@MainActivity)
////            dlg.setTitle("제목입니다")
////            dlg.setMessage("이곳이 내용입니다")
////            dlg.setIcon(R.mipmap.ic_launcher)
////            dlg.setPositiveButton("확인", null)
////            dlg.setPositiveButton("확인") { dialog, which ->
////                Toast.makeText(this@MainActivity, "확인을 눌렀네요", Toast.LENGTH_SHORT).show()
////            }
////            dlg.show()
//
//            AlertDialog.Builder(this@MainActivity)
//                .setTitle("제목입니다")
//                .setMessage("이곳이 내용입니다")
//                .setIcon(R.mipmap.ic_launcher)
//                .show()


//        05

//        button1.setOnClickListener{
//            var versionArray = arrayOf("오레오", "파이", "큐(10)")
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("좋아하는 버전은?")
//            dlg.setIcon(R.mipmap.ic_launcher)
//            dlg.setItems(versionArray) { dialog, which ->
//                button1.text = versionArray[which]
//            }
//            dlg.setPositiveButton("닫기", null)
//            dlg.show()

//        05
//        button1.setOnClickListener{
//            var versionArray = arrayOf("오레오", "파이", "큐(10)")
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("좋아하는 버전은?")
//            dlg.setIcon(R.mipmap.ic_launcher)
//            dlg.setSingleChoiceItems(versionArray, 0) { dialog, which ->
//                button1.text = versionArray[which]
//            }
//            dlg.setPositiveButton("닫기", null)
//            dlg.show()


//        06
        button1.setOnClickListener{
            var versionArray = arrayOf("오레오", "파이", "큐(10)")
            var checkArray = booleanArrayOf(true, false, false)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("좋아하는 버전은?")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setMultiChoiceItems(versionArray, checkArray) { dialog, which, isChecked ->
                button1.text = versionArray[which]
            }
            dlg.setPositiveButton("닫기", null)
            dlg.show()




        }
    }
}