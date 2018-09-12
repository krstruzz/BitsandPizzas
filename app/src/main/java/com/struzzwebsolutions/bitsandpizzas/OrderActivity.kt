package com.struzzwebsolutions.bitsandpizzas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.support.v7.app.ActionBar
import android.view.View
import android.support.design.widget.Snackbar
import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onClickDone(view: View) {
        val text: CharSequence = "Your order has been updated"
        val duration: Int = Snackbar.LENGTH_SHORT
        val snackbar: Snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration)
                .setAction("Undo", View.OnClickListener {
                    val toast = Toast.makeText(
                            this,
                            "Undone!",
                            Toast.LENGTH_LONG)
                            .show()
                })
        snackbar.show()

    }
}
