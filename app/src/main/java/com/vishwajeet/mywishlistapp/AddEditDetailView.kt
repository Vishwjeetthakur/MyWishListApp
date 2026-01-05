package com.vishwajeet.mywishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppBar(title = if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)){
                navController.navigateUp()
            }
        }

    ) {

        val context = LocalContext.current

        Column(
            modifier = Modifier.padding(it).wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            WishTextFeild(viewModel.wishTitleState,"Title") {
                viewModel.onWishTitleChange(it)
            }

            Spacer(modifier = Modifier.height(10.dp))

            WishTextFeild(viewModel.wishDescriptionState,"Description") {
                viewModel.onWishDescriptionChange(it)
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if (viewModel.wishTitleState.isNotEmpty() &&
                    viewModel.wishDescriptionState.isNotEmpty()){
               viewModel.updateAddItem(viewModel.wishTitleState,viewModel.wishDescriptionState)

                }else{
                    Toast.makeText(context,"Please Fill the Title and Discription", Toast.LENGTH_LONG).show()
                }
            }) {
                Text( text = if (id != 0L) stringResource(R.string.update_wish)
                else stringResource(R.string.add_wish),
                    style = TextStyle(fontSize = 18.sp))
            }

        }
    }
}

@Composable
fun WishTextFeild(
    value : String,
    label : String,
    onValueChange : (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text )
    )
}