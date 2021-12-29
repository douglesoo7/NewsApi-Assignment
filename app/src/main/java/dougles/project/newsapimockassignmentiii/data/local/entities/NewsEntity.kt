package dougles.project.newsapimockassignmentiii.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsEntity(
    @ColumnInfo(name = "Headline") var headLine: String,
    @ColumnInfo(name = "Description") var description: String,
    @ColumnInfo(name = "ImageUrl") var imageUrl: String,
    @ColumnInfo(name = "Date") var date: String,
    @ColumnInfo(name = "Source") var source: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int? = null
}