package com.example.projecttest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projecttest.data.database.dao.EstateObjectDao
import com.example.projecttest.data.database.entity.EstateObjectEntity

@Database(
    entities = [EstateObjectEntity::class],
    version = 1
)
abstract class EstateDataBase : RoomDatabase() {

    abstract fun getEstateDao(): EstateObjectDao


    companion object {
        private var instance: EstateDataBase? = null
        private val lock = Any()

        fun getInstance(context: Context): EstateDataBase = instance ?: buildDatabase(context)

        private fun buildDatabase(context: Context): EstateDataBase {
            synchronized(lock) {
                instance?.let { return it }

                val db = Room.databaseBuilder(context, EstateDataBase::class.java, "dataBase")
                    .build()
                instance = db

                return db
            }
        }
    }
}
