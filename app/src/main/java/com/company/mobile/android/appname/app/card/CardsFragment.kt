package com.company.mobile.android.appname.app.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.company.mobile.android.appname.app.common.BaseFragment
import com.company.mobile.android.appname.app.databinding.FragmentCardsBinding

class CardsFragment: BaseFragment() {

    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCardsBinding.inflate(layoutInflater)
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

        //Inicializar lo asociado a las vistas.
    }
}