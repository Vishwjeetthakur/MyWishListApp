package com.vishwajeet.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.vishwajeet.mywishlistapp.data.WishDataBase
import com.vishwajeet.mywishlistapp.data.WishRepository

object Graph {

    lateinit var dataBase: WishDataBase

    val wishRepository by lazy {
        WishRepository(wishDao = dataBase.wishDao())
    }

    fun provider(context: Context){
        dataBase = Room.databaseBuilder(context, WishDataBase::class.java,"wishlist.dp")
            .build()
    }
}