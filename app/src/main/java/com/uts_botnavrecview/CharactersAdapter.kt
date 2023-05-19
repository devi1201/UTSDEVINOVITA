package com.uts_botnavrecview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fragments.CharacterFrag

class CharactersAdapter(private val charList : ArrayList<Characters>,val listener: (Characters) -> Unit)
: RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>(){

    class CharactersViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val imgChar = itemview.findViewById<ImageView>(R.id.img_item_photo)
        val nameChar = itemview.findViewById<TextView>(R.id.tv_item_name)
        val descChar = itemview.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(Characters: Characters, listener: (Characters) -> Unit) {
            imgChar.setImageResource(Characters.imgCharacter)
            nameChar.text = Characters.nameCharacter
            descChar.text = Characters.descChar
            itemView.setOnClickListener{
                listener(Characters)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {

        val itemview = LayoutInflater.from(parent.context).
        inflate(R.layout.item_char, parent, false)
        return CharactersViewHolder(itemview)
    }


    override fun getItemCount(): Int{
        return charList.size
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindView(charList[position],listener)
        val currentItem = charList[position]
        holder.imgChar.setImageResource(currentItem.imgCharacter)
        holder.nameChar.text = currentItem.nameCharacter
        holder.descChar.text = currentItem.descChar
        itemCount

    }

}