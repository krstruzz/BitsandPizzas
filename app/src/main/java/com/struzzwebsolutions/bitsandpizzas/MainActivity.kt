package com.struzzwebsolutions.bitsandpizzas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import android.support.v7.widget.ShareActionProvider
import android.support.v4.view.MenuItemCompat
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {

    private var shareActionProvider: ShareActionProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Attach the SectionsPagerAdapter to the ViewPager
        val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager: ViewPager = findViewById(R.id.pager)
        pager.adapter = pagerAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the app bar.
        menuInflater.inflate(R.menu.menu_main, menu)

        val menuItem = menu!!.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionIntent("Want to join me for pizza?")
        return super.onCreateOptionsMenu(menu)
    }

    private fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        shareActionProvider?.setShareIntent(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_create_order -> {
                val intent = Intent(this, OrderActivity::class.java)
                        startActivity(intent)
                return true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }

        }
        return true
    }

    private class SectionsPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

        override fun getCount(): Int {
            return 4
        }

        override fun getItem(position: Int): Fragment? {
            return when (position) {
                0 -> TopFragment()
                1 -> PizzaFragment()
                2 -> PastaFragment()
                3 -> StoresFragment()
                else -> null
            }

        }

    }
}
