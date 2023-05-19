package com.uts_botnavrecview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragments.CharacterFrag
import fragments.ProfileFrag

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setCustomView(R.layout.action_bar_custom);

        val charFrag = CharacterFrag()
        val profileFrag = ProfileFrag()

        makeCurrentFragment(charFrag)
//        val recyclerView = findViewById<RecyclerView>(R.id.rvChar)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = CharactersAdapter(this,charList) {
//            val intent = Intent(this, DetailCharacterActivity::class.java)
//            startActivity(intent)
//        }
//
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.botNAv)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuChar -> makeCurrentFragment(charFrag)
                R.id.menuProfile -> makeCurrentFragment(profileFrag)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameNav, fragment)
            commit()
        }
    }
}
