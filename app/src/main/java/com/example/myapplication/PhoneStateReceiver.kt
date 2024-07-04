package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class PhoneStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val state = intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
        when (state) {
            TelephonyManager.EXTRA_STATE_RINGING -> {
                val incomingNumber = intent?.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
                Log.d("PhoneStateReceiver", "Incoming call from: $incomingNumber")
            }
            TelephonyManager.EXTRA_STATE_OFFHOOK -> {
                Log.d("PhoneStateReceiver", "Call answered")
            }
            TelephonyManager.EXTRA_STATE_IDLE -> {
                Log.d("PhoneStateReceiver", "Call ended or no call")
            }
        }
    }
}
