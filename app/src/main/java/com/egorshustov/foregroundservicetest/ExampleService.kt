package com.egorshustov.foregroundservicetest

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.egorshustov.foregroundservicetest.App.Companion.CHANNEL_ID
import com.egorshustov.foregroundservicetest.MainActivity.Companion.INPUT_EXTRA

class ExampleService : Service() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // In the real app we will use Extras data to do necessary background work on it.
        // This code runs in the main thread by default,
        // so if we do some heavy operations in here, we should create a thread/coroutine.
        val input = intent?.getStringExtra(INPUT_EXTRA)

        val activityIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, activityIntent, 0)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_face_black_24dp)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        //stopSelf()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}