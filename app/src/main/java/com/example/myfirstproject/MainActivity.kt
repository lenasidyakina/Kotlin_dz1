package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var frag: GridFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frag = supportFragmentManager.findFragmentById(R.id.fragment_container_view)
                as GridFragment

        findViewById<Button>(R.id.btnAdd).setOnClickListener (
            {
            frag.appendItem()
            }
        )

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT_KEY", frag.getCount())
    }
    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        frag.setCount(savedInstanceState.getInt("COUNT_KEY"))
    }
}