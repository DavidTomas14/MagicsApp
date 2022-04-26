package com.company.mobile.android.appname.app.di

import com.company.mobile.android.appname.app.BuildConfig
import com.company.mobile.android.appname.app.UiThread
import com.company.mobile.android.appname.data.bufferoo.repository.CardsRepositoryImpl
import com.company.mobile.android.appname.data.bufferoo.source.CardsDataStoreFactory
import com.company.mobile.android.appname.data.bufferoo.source.CardsRemoteDataStore
import com.company.mobile.android.appname.datasources.card.remote.CardServiceFactory
import com.company.mobile.android.appname.datasources.card.remote.CardsRemoteImpl
import com.company.mobile.android.appname.datasources.card.remote.mapper.CardResponseMapper
import com.company.mobile.android.appname.domain.card.interactor.GetCardsUseCase
import com.company.mobile.android.appname.domain.card.repository.CardsRepository
import com.company.mobile.android.appname.domain.executor.JobExecutor
import com.company.mobile.android.appname.domain.executor.PostExecutionThread
import com.company.mobile.android.appname.domain.executor.ThreadExecutor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * This file is where all Koin modules are defined.
 *
 * [The original template](https://github.com/bufferapp/clean-architecture-koin-boilerplate) was a
 * port of a [Dagger template](https://github.com/bufferapp/android-clean-architecture-boilerplate),
 * and the explanation of the dependency injection porting was explained in this
 * [post](https://overflow.buffer.com/2018/09/13/a-brief-look-at-koin-on-android/).
 */
val applicationModule = module(override = true) {

    single<ThreadExecutor> { JobExecutor() }
    single<PostExecutionThread> { UiThread() }
    factory { CardServiceFactory.makeCardService(BuildConfig.DEBUG) }
}

val cardsModule = module {
    factory { CardResponseMapper() }
    factory<CardsRemoteDataStore> { CardsRemoteImpl(get(), get()) }
    factory { CardsDataStoreFactory(get()) }
    factory <CardsRepository>{ CardsRepositoryImpl(get()) }
    factory { GetCardsUseCase(get(), get(), get()) }
}
