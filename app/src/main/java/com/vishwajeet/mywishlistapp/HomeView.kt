package com.vishwajeet.mywishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vishwajeet.mywishlistapp.data.DummyWish
import com.vishwajeet.mywishlistapp.data.Wish
import java.nio.file.WatchEvent

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
){

    Scaffold(
        topBar ={ AppBar(title = "WishList",{

        })},

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                contentColor = Color.White,
                onClick = {
                     navController.navigate(Screen.AddScreen.route)
                }) {
                Icon(imageVector = Icons.Default.Add,contentDescription = null)
            }
        }

    ) {

        val wishList = viewModel.getAllWish.collectAsState(initial = listOf())
        LazyColumn (
            modifier = Modifier.fillMaxSize().padding(it)
        ){
            items(wishList.value){
                WishItem(it,{

                })
            }
        }
    }

}

@Composable
fun WishItem(wish: Wish , onClick:() -> Unit){

    Card(
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp , top = 8.dp, end = 8.dp)
            .clickable{
                onClick
            },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(
          modifier =Modifier.padding(16.dp)
        ) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }

}
