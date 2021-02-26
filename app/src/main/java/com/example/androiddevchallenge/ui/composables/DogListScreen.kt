/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Dog
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.viewmodels.DogListViewModel

object DogListScreen {

    @Composable
    fun DogList(navController: NavController) {

        val dogListViewModel: DogListViewModel = viewModel()

        val dogs: Map<Int, Dog> by dogListViewModel.dogs.observeAsState(emptyMap())
        val scrollState = rememberLazyListState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(R.string.app_name))
                    }
                )
            }
        ) {
            LazyColumn(state = scrollState) {
                items(dogs.size) { id ->
                    dogs[id]?.let { dog ->
                        DogListItem(
                            dog = dog,
                            onClicked = {
                                navController.navigate("dogDetails/${dog.id}")
                            }
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun DogListItem(dog: Dog, onClicked: () -> Unit) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .padding(16.dp)
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable(onClick = onClicked)
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = dog.name)
                Text(text = "age: ${dog.age}")
            }
        }
    }
}
