package gmp.thiago.apps.popularmovies.data

import androidx.appcompat.widget.DialogTitle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "movies")
data class MoviesData (
    @PrimaryKey @ColumnInfo(name = "_id") var id:Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "original_title") var original_title:String,
    @ColumnInfo(name = "original_language") var original_language: String,
    @ColumnInfo(name = "overview") var overview: String,
    @ColumnInfo(name = "popularity") var popularity: Double,
    @ColumnInfo(name = "poster_path") var poster_path: String,
    @ColumnInfo(name = "release_date") var release_date: String,
    @ColumnInfo(name = "vote_average") var vote_average: Double,
    @ColumnInfo(name = "vote_count") var vote_count: Int
)