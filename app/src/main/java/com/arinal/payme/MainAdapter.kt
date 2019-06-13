package com.arinal.payme

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.arinal.payme.detail.DetailActivity
import org.jetbrains.anko.startActivity

class MainAdapter (private val data: List<Data>, private val context: Context) :RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(view: ViewHolder, pos: Int) {
        view.tx.text = data[pos].serviceName
        view.img.setImageResource(data[pos].serviceImage)
        view.button.setOnClickListener { (context as Activity).startActivity<DetailActivity>("data" to data[pos]) }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img: ImageView = itemView.findViewById(R.id.imgService)
        val tx: TextView = itemView.findViewById(R.id.txService)
        val button: View = itemView.findViewById(R.id.button)
    }
}