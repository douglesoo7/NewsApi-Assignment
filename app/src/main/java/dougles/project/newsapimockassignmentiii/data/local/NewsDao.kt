package dougles.project.newsapimockassignmentiii.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import dougles.project.newsapimockassignmentiii.data.local.entities.NewsEntity

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data: List<NewsEntity>)

    @Query("SELECT * FROM news_table")
    fun getDataFromDb(): LiveData<List<NewsEntity>>

    @Query("DELETE FROM news_table")
    fun deleteAllDataFromDb()
}