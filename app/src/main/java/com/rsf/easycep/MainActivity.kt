package com.rsf.easycep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rsf.kteasycep.EasyCep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        EasyCep()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}