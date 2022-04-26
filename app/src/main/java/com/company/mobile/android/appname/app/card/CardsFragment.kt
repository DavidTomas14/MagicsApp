package com.company.mobile.android.appname.app.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.mobile.android.appname.app.card.adapter.CardAdapter
import com.company.mobile.android.appname.app.common.BaseFragment
import com.company.mobile.android.appname.app.databinding.FragmentCardsBinding
import com.company.mobile.android.appname.model.card.Card
import org.koin.android.ext.android.inject

class CardsFragment: BaseFragment() {

    private lateinit var binding: FragmentCardsBinding
    private val adapter: CardAdapter by inject()

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
        binding.rvListCard.adapter = adapter
        adapter.submitList(listOf(
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200),
            Card("nombre", 10, "Esto es una tarjeta de prueba", 200)
        ).toMutableList())
    }
}