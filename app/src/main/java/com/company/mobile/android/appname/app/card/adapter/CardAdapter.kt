package com.company.mobile.android.appname.app.card.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.company.mobile.android.appname.app.databinding.RowCardBinding
import com.company.mobile.android.appname.model.card.Card

class CardAdapter():
    ListAdapter<Card, CardAdapter.CardViewHolder>(DifferCallback){

    companion object {
        object DifferCallback : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var cardList: List<Card> = ArrayList()

    class CardViewHolder(val binding: RowCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = cardList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = RowCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.binding.apply {
            tvCardRowName.text = card.name
        }
    }

    override fun submitList(list: MutableList<Card>?) {
        if (cardList.isEmpty()){
            cardList = list!!
        }
    }


}