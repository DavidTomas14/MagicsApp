package com.company.mobile.android.appname.app.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.company.mobile.android.appname.app.common.errorhandling.AppAction
import com.company.mobile.android.appname.app.common.errorhandling.ErrorBundleBuilder
import com.company.mobile.android.appname.app.common.model.ResourceState
import com.company.mobile.android.appname.app.common.model.ResourceState.*
import com.company.mobile.android.appname.app.common.viewmodel.CommonEventsViewModel
import com.company.mobile.android.appname.domain.card.interactor.GetCardsUseCase
import com.company.mobile.android.appname.domain.card.interactor.SaveCardsUseCase
import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber

typealias CardListState = ResourceState<List<Card>>


class CardsViewModel(
    private val getCardsUseCase: GetCardsUseCase,
    private val saveCardsUseCase: SaveCardsUseCase,
    private val errorBundleBuilder: ErrorBundleBuilder
) : CommonEventsViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val cardsListMutableLiveData: MutableLiveData<CardListState> = MutableLiveData()

    fun getCards(): LiveData<CardListState> {
        return cardsListMutableLiveData
    }

    fun fetchCards() {
        cardsListMutableLiveData.value = Loading()
        getCardsUseCase.execute().flatMap {
            if (it.isEmpty()) {
                saveCardsUseCase.execute()
                    .andThen(getCardsUseCase.execute())
            }else{
                getCardsUseCase.execute()
            }
        }.subscribe(
            {
                cardsListMutableLiveData.value = Success(it)
            },
            {
                cardsListMutableLiveData.value = Error(errorBundleBuilder.build(it, AppAction.GET_CARDS))
                Timber.e(it)
            }
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}