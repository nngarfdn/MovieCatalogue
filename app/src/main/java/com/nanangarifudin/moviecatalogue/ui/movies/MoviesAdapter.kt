package com.nanangarifudin.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.data.MovieEntity
import com.nanangarifudin.moviecatalogue.ui.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies_tv.view.*

class MoviesAdapter :
        RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private lateinit var cardList: List<MovieEntity>

    fun setData(cardList: List<MovieEntity>){
        this.cardList = cardList
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.txtTitle
        val photo: ImageView = v.imgPoster
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_movies_tv, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = cardList[position]
        holder.name.text = currentItem.title

        Picasso.get()
                .load(currentItem.poster)
                .fit()
                .centerCrop()
                .into(holder.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_MOVIES, currentItem)
            holder.itemView.context.startActivity(intent)
        }
    }
}