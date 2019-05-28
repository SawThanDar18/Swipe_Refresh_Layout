package com.example.swipe_refresh_layout

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_movie.view.*

class MovieAdapter(val movie: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(val view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_movie, parent, false))
    }

    override fun getItemCount() = movie.size

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movie = movie[position]
        holder.view.textViewTitle.text = movie.title
        holder.view.textViewLanguage.text = movie.language
        holder.view.textViewType.text = movie.type
        holder.view.textViewRating.text = movie.rating
        holder.view.textViewLikePercent.text = movie.likePercent.toString()
        holder.view.textViewVotesCount.text = movie.voteCount.toString()
        holder.view.textViewIsNew.visibility = if(movie.isNew == 1) View.VISIBLE else View.INVISIBLE

        Glide.with(holder.view.context)
            .load(movie.image)
            .into(holder.view.imageView)
    }
}