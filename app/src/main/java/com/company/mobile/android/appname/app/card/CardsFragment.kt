package com.company.mobile.android.appname.app.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.card.adapter.CardAdapter
import com.company.mobile.android.appname.app.common.BaseFragment
import com.company.mobile.android.appname.app.common.model.ResourceState
import com.company.mobile.android.appname.app.common.model.ResourceState.Loading
import com.company.mobile.android.appname.app.common.model.ResourceState.Success
import com.company.mobile.android.appname.app.databinding.FragmentCardsBinding
import com.company.mobile.android.appname.model.card.Card
import org.koin.android.ext.android.inject

class CardsFragment : BaseFragment() {

    private lateinit var binding: FragmentCardsBinding
    private lateinit var adapter: CardAdapter
    private val cardViewModel: CardsViewModel by inject()

    private val adapterListener = object : CardAdapter.CardAdapterListener{
        override fun onDetalleClicked(card: Card) {
            findNavController().navigate(CardsFragmentDirections.actionCardsFragmentToCardsDetailFragment(card))
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCardsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initializeContents(savedInstanceState: Bundle?) {
        super.initializeContents(savedInstanceState)

        if (cardViewModel.getCards().value == null) {
            cardViewModel.fetchCards()
        }
    }

    override fun initializeState(savedInstanceState: Bundle?) {
        super.initializeState(savedInstanceState)

        //Inicializar observadores
        cardViewModel.getCards().observe(viewLifecycleOwner) {
            handleState(it)
        }
    }

    private fun handleState(cardsState: ResourceState<List<Card>>?) {
        when (cardsState) {
            is Loading -> setUpScreenForLoading()
            is Success -> setUpScreenForSuccess(cardsState.data)
            is Error -> {}
        }
    }

    private fun setUpScreenForSuccess(cards: List<Card>) {
        adapter.submitList(cards.toMutableList())
    }

    private fun setUpScreenForLoading() {

    }

    override fun initializeViews(savedInstanceState: Bundle?) {
        super.initializeViews(savedInstanceState)
        adapter = CardAdapter(requireContext())
        adapter.setCardAdapterListener(adapterListener)
        binding.rvListCard.adapter = adapter


        /*//Inicializar lo asociado a las vistas.
         binding.rvListCard.adapter = adapter
         adapter.submitList(listOf(
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),
             Card("nombre", 10, "Esto es una tarjeta de prueba", "200",""),

         ).toMutableList())*/
    }
}