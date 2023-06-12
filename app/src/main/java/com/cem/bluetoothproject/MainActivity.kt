package com.cem.bluetoothproject

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var ac: Button? = null
    private var kapat: Button? = null
    private var gorunurYap: Button? = null

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ac = findViewById<View>(R.id.ac) as Button
        gorunurYap = findViewById<View>(R.id.gorunurYap) as Button
        kapat = findViewById<View>(R.id.kapat) as Button
        val adaptor = BluetoothAdapter.getDefaultAdapter()
        ac!!.setOnClickListener(View.OnClickListener { // TODO Auto-generated method stub
            if (adaptor == null) {
                Toast.makeText(this@MainActivity, "Blueetoth Aygıtı Bulunamadı", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (!adaptor.isEnabled) {
                    val bluetoothBaslat = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    startActivityForResult(bluetoothBaslat, 1)
                    Toast.makeText(this@MainActivity, "Bluetooth Ayıgıtı Açık", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    adaptor.disable()
                }
            }
        })
        gorunurYap!!.setOnClickListener(View.OnClickListener { // TODO Auto-generated method stub
            val gorunurYap = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
            startActivityForResult(gorunurYap, 1)
            Toast.makeText(this@MainActivity, "Görünür Hale geldi", Toast.LENGTH_SHORT).show()
        })
        kapat!!.setOnClickListener(View.OnClickListener { // TODO Auto-generated method stub
            if (!adaptor!!.isEnabled) {
            } else {
                adaptor.disable()
                Toast.makeText(this@MainActivity, "Kapatıldı", Toast.LENGTH_SHORT).show()
            }
        })
    }
}