package com.company.mobile.android.appname.datasources.card.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.company.mobile.android.appname.datasources.card.cache.dao.CardDbModelDao
import com.company.mobile.android.appname.datasources.card.cache.model.CardDbModel

@Database(
    entities = [
        CardDbModel::class
    ],
    version = 1,
    exportSchema = true
)
abstract class CardsDatabase: RoomDatabase() {

    private var INSTANCE: CardsDatabase? = null
    private val sLock = Any()

    abstract fun cardDbModelDao(): CardDbModelDao

    fun getInstance(context: Context): CardsDatabase {
        if (INSTANCE == null) {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CardsDatabase::class.java, "magics.sqlite"
                    )
                        .build()
                }
                return INSTANCE!!
            }
        }
        return INSTANCE!!
    }
}