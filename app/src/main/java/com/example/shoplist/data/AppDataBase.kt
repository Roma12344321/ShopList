package com.example.shoplist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    
    abstract fun shopListDao(): ShopListDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db =
                Room.databaseBuilder(application, AppDataBase::class.java, "shop_item.db")
                    .build()
            INSTANCE = db
            return db
        }
    }
}