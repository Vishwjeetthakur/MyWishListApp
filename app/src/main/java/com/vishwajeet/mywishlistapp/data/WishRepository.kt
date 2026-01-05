package com.vishwajeet.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository (private val wishDao: WishDao) {

    suspend fun addWish(wish: Wish) {
        wishDao.addAWish(wish)
    }

     fun getWishes() : Flow<List<Wish>> {
        return wishDao.getAllWish()
    }

    suspend fun updateAWish(wish: Wish){
        wishDao.updateWish(wish)
    }

     fun gatAWishById(id:Long): Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }

}