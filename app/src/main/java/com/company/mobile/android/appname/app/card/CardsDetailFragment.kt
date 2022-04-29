package com.company.mobile.android.appname.app.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.card.adapter.CardAdapter
import com.company.mobile.android.appname.app.common.BaseFragment
import com.company.mobile.android.appname.app.common.model.ResourceState
import com.company.mobile.android.appname.app.common.model.ResourceState.Loading
import com.company.mobile.android.appname.app.common.model.ResourceState.Success
import com.company.mobile.android.appname.app.databinding.FragmentCardsBinding
import com.company.mobile.android.appname.app.databinding.FragmentCardsDetailBinding
import com.company.mobile.android.appname.model.card.Card
import org.koin.android.ext.android.inject

class CardsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentCardsDetailBinding
    private lateinit var adapter: CardAdapter
    private  val args: CardsDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCardsDetailBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun initializeContents(savedInstanceState: Bundle?) {
        super.initializeContents(savedInstanceState)


    }

    override fun initializeState(savedInstanceState: Bundle?) {
        super.initializeState(savedInstanceState)

        //Inicializar observadores

    }


    override fun initializeViews(savedInstanceState: Bundle?) {
        super.initializeViews(savedInstanceState)

        args.card.apply {
            with(binding){
                tvCardName.text = name
                tvCardCmc.text = "Cmc: $cmc"
                if (power.isEmpty()){
                    tvCardPower.text ="Power: 0"
                }else{
                    tvCardPower.text ="Power: $power"
                }
                tvCardText.text = text

                Glide
                    .with(ivCardBanner.context)
                    .load(imageUrl)
                    .fitCenter()
                    .placeholder(R.drawable.splash_background)
                    .into(ivCardBanner);
            }

        }

    }
}