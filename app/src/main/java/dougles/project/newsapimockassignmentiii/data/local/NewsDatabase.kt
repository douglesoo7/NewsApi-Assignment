package dougles.project.newsapimockassignmentiii.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

    companion object {
        private var instance: NewsDatabase? = null

        fun getInstanceOfNewsDatabase(context: Context): NewsDatabase {
            return if (instance != null) {
                instance!!
            } else {
                val builder = Room.databaseBuilder(
                    context.applicationContext, NewsDatabase::class.java,
                    "db_news"
                ).fallbackToDestructiveMigration()
                instance = builder.build()
                instance as NewsDatabase
            }
        }
    }

}