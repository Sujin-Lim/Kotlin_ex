package kr.co.hanbit.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Log.d("StartedService", "action = $action")
        return super.onStartCommand(intent, flags, startId)
    }

    companion object {
        val ACTION_START = "kr.co.hanbit.servicetest.START"
        val ACTION_RUN = "kr.co.hanbit.servicetest.RUN"
        val ACTION_STOP = "kr.co.hanbit.servicetest.STOP"
    }

    override fun onDestroy() {
        Log.d("Service", "서비스 종료")
        super.onDestroy()
    }

    inner class MyBinder : Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }
    val binder = MyBinder()

    fun serviceMessage(): String {
        return "Hello Activity! I am Service!"
    }

}