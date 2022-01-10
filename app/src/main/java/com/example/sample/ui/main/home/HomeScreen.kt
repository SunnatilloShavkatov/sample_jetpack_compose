package com.example.sample.ui.main.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sample.R
import com.example.sample.core.theme.AppColor
import com.example.sample.core.theme.AppShape
import com.example.sample.di.SharedPreferencesModule
import javax.inject.Inject


@Preview
@Composable
fun HomeScreen() {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = AppColor.white,
                title = {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        value = textState,
                        onValueChange = { textState = it },
                        placeholder = { Text(text = "Поиск") },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_search),
                                contentDescription = "bell",
                                modifier = Modifier.size(16.dp),
                                tint = AppColor.grey,
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = AppColor.textBackground,
                            cursorColor = AppColor.black,
                            disabledLabelColor = AppColor.textBackground,
                            focusedIndicatorColor = AppColor.transparent,
                            unfocusedIndicatorColor = AppColor.transparent
                        ),
                        shape = AppShape.cornerShape8,
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_bell),
                            contentDescription = "bell",
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }, elevation = 1.dp
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.TopCenter)
            ) {
                LazyColumn {
                    items(listOf("Hello,", "world!")) { item ->
                        Text(text = item, color = AppColor.black)
                    }
                }
            }
        }
    )
}