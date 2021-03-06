
package com.example.sample.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sample.model.Poster

@Database(entities = [Poster::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

  abstract fun posterDao(): PosterDao
}
