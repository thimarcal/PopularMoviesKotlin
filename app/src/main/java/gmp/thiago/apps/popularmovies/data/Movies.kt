package gmp.thiago.apps.popularmovies.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movies(
    @PrimaryKey @ColumnInfo(name = "_id") var id:Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "original_title") var original_title:String,
    @ColumnInfo(name = "original_language") var original_language: String,
    @ColumnInfo(name = "overview") var overview: String,
    @ColumnInfo(name = "popularity") var popularity: Double,
    @ColumnInfo(name = "poster_path") var poster_path: String,
    @ColumnInfo(name = "release_date") var release_date: String,
    @ColumnInfo(name = "vote_average") var vote_average: Double,
    @ColumnInfo(name = "vote_count") var vote_count: Int,
    @ColumnInfo(name = "adult") var adult: Boolean,
    @ColumnInfo(name = "backdrop_path") var backdrop_path: String,
    //@ColumnInfo(name = "genre_ids")var genre_ids: List<Int>,
    @ColumnInfo(name = "video") var video: Boolean
)