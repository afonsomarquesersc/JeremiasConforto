package com.pm.jeremiasconforto.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pm.jeremiasconforto.data.dao.ProductDao
import com.pm.jeremiasconforto.data.entities.Product

@Database(entities = [Product :: class], version = 1, exportSchema = false)
abstract class JeremiasConfortoDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao
    companion object {
        @Volatile
        private var INSTANCE: JeremiasConfortoDatabase? = null

        fun getDatabase(context: Context): JeremiasConfortoDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JeremiasConfortoDatabase::class.java,
                    "jeremiasconforto_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}