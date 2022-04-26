package com.company.mobile.android.appname.app.card.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.databinding.RowCardBinding
import com.company.mobile.android.appname.model.card.Card
import java.lang.ref.WeakReference

class CardAdapter(
   val context: Context
) :ListAdapter<Card, CardAdapter.CardViewHolder>(DifferCallback()){


        private class DifferCallback : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem == newItem
            }
        }

    interface CardAdapterListener{
        fun onDetalleClicked(card: Card)
    }

    private var cardAdapterListener: CardAdapterListener? = null
    class CardViewHolder(val binding: RowCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = RowCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = currentList[position]
        var url = card.imageUrl
        if (url.isEmpty()){
            url = "https://us.123rf.com/450wm/urfandadashov/urfandadashov1805/urfandadashov180500070/100957966-photo-not-available-icon-isolated-on-white-background-vector-illustration.jpg?ver=6"
        }
        holder.binding.apply {
            Glide
                .with(ivCardRowAvatarImage.context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.splash_background)
                .into(ivCardRowAvatarImage);
            tvCardRowName.text = card.name
        }

        holder.binding.cardItem.setOnClickListener {
            this.cardAdapterListener?.onDetalleClicked(card)
        }
    }

    fun setCardAdapterListener(@NonNull cardAdapterListener: CardAdapterListener) {
        this.cardAdapterListener = cardAdapterListener
    }


}