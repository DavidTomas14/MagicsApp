package com.company.mobile.android.appname.app.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.card.adapter.CardAdapter
import com.company.mobile.android.appname.app.common.BaseFragment
import com.company.mobile.android.appname.app.common.errorhandling.AppAction
import com.company.mobile.android.appname.app.common.errorhandling.ErrorBundle
import com.company.mobile.android.appname.app.common.model.ResourceState
import com.company.mobile.android.appname.app.common.model.ResourceState.Error
import com.company.mobile.android.appname.app.common.model.ResourceState.Loading
import com.company.mobile.android.appname.app.common.model.ResourceState.Success
import com.company.mobile.android.appname.app.common.util.gone
import com.company.mobile.android.appname.app.common.util.visible
import com.company.mobile.android.appname.app.common.widget.error.ErrorListener
import com.company.mobile.android.appname.app.databinding.FragmentCardsBinding
import com.company.mobile.android.appname.model.card.Card
import org.koin.android.ext.android.inject
import timber.log.Timber

class CardsFragment : BaseFragment(), ErrorListener {

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

            cardViewModel.fetchCards()
    }

    override fun initializeViews(savedInstanceState: Bundle?) {
        super.initializeViews(savedInstanceState)
        adapter = CardAdapter(requireContext())
        adapter.setCardAdapterListener(adapterListener)
        binding.rvListCard.adapter = adapter

        val arrowback = activity?.findViewById<ImageView>(R.id.iv_arrow_back)
        arrowback?.setOnClickListener{
            findNavController().navigateUp()
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
            is Error -> setUpSreenForError(cardsState.errorBundle)
        }
    }

    private fun setUpScreenForSuccess(cards: List<Card>) {
        binding.apply {
            nsvListCard.visible()
            lvCardsLoadingView.gone()
            evCardsEmptyView.gone()
            evCardsErrorView.gone()
        }
        adapter.submitList(cards.toMutableList())
    }

    private fun setUpScreenForLoading() {
        binding.apply {
            nsvListCard.gone()
            lvCardsLoadingView.visible()
            evCardsEmptyView.gone()
            evCardsErrorView.gone()
        }
    }

    private fun setUpSreenForError(errorBundle: ErrorBundle) {
        binding.apply {
            nsvListCard.gone()
            lvCardsLoadingView.gone()
            evCardsEmptyView.gone()
            evCardsErrorView.visible()
            evCardsErrorView.errorBundle = errorBundle
            evCardsErrorView.errorListener = this@CardsFragment
            evCardsErrorView.setErrorMessage(getString(errorBundle.stringId))
        }
    }
    override fun onErrorDialogCancelled(action: Long) {
        Timber.d("User cancelled error dialog")
    }

    override fun onRetry(errorBundle: ErrorBundle) {
        when (errorBundle.appAction) {
            AppAction.GET_CARDS -> cardViewModel.fetchCards()
            else -> Timber.d("This action is not supported")
        }
    }



}