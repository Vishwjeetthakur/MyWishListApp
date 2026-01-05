package com.vishwajeet.mywishlistapp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vishwajeet.mywishlistapp.data.Wish

class WishViewModel : ViewModel() {

    private val _wishlist = mutableStateOf(listOf<Wish>())
    val wishlist : State<List<Wish>> = _wishlist
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")



    fun onWishTitleChange(title : String){
        wishTitleState = title
    }
    fun onWishDescriptionChange(newString : String){
        wishDescriptionState = newString
    }

    fun updateAddItem(title: String , discription : String){
        val newWish = Wish(
            id = System.currentTimeMillis(),
            title = title,
            description = discription
        )
         _wishlist.value = _wishlist.value +newWish
        wishTitleState = ""
        wishDescriptionState = ""
    }

}