package com.uts_botnavrecview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import fragments.CharacterFrag

class DetailCharacterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Characters = intent.getParcelableExtra<Characters>(CharacterFrag.INTENT_PARCELABLE)

        val imgCharacter = findViewById<ImageView>(R.id.img_item_photo)
        val nameCharacter = findViewById<TextView>(R.id.tv_item_name)
        val descCharacter = findViewById<TextView>(R.id.tv_item_description)

        imgCharacter.setImageResource(Characters?.imgCharacter!!)
        nameCharacter.text = Characters.nameCharacter
        descCharacter.text = Characters.descChar
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
