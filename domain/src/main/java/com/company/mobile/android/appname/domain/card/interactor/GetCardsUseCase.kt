package com.company.mobile.android.appname.domain.card.interactor

import com.company.mobile.android.appname.domain.card.repository.CardsRepository
import com.company.mobile.android.appname.domain.executor.JobExecutor
import com.company.mobile.android.appname.domain.executor.PostExecutionThread
import com.company.mobile.android.appname.domain.executor.ThreadExecutor
import com.company.mobile.android.appname.domain.interactor.SingleUseCase
import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.core.Single

class GetCardsUseCase(
    private val cardsRepository: CardsRepository,
    postExecutionThread: PostExecutionThread,
    threadExecutor: ThreadExecutor,
    ): SingleUseCase<List<Card>, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Single<List<Card>> {
        return cardsRepository.getCards()
    }
}