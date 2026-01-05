package com.vishwajeet.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish(

    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,

    @ColumnInfo(name = "wish-title")
    val title : String = "",

    @ColumnInfo(name = "wish-desc")
    val description : String = ""
)

object DummyWish{

    val wishlist = listOf(
        Wish(
            title = "Android Tv",
            description = "its a smart tv of size 46 inc with oled screen."
        ),
        Wish(
            title = "Bottel",
            description = "Bottel can hold a liqued substanse."
        ),
        Wish(
            title = "Car",
            description = "Car have 4 wheel with capacity to carry 4 to 5 person."
        ),
        Wish(
            title = "Love",
            description = "Love is a word wich not explain, love is about to feel"
        )
    )
}