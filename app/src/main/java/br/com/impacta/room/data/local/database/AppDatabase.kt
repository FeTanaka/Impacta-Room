package br.com.impacta.room.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.impacta.room.data.local.dao.ComidaDao
import br.com.impacta.room.data.models.Comida

@Database(entities = [Comida::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comidaDao(): ComidaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}