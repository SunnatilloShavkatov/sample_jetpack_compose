package com.example.sample.ui.main.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sample.R
import com.example.sample.core.theme.AppColor
import com.example.sample.core.theme.AppShape
import com.example.sample.routes.Routes
import com.example.sample.ui.main.profile.widget.ProfileItem

@Preview
@Composable
fun ProfileScreen(routes: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Sunnatillo Shavkatov") },
                elevation = 1.dp
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.TopStart)
                    .padding(all = 16.dp)
            ) {
                Card(
                    shape = AppShape.cornerShape16,
                    elevation = 0.dp,
                    backgroundColor = AppColor.white,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        ProfileItem(
                            text = "Изменить профиль",
                            onClick = {},
                            iconId = R.drawable.ic_user,
                        )
                        Divider(
                            color = AppColor.black.copy(alpha = 0.1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                                .padding(start = 72.dp)
                        )
                        ProfileItem(
                            text = "История заказов",
                            onClick = {},
                            iconId = R.drawable.ic_notebook,
                        )
                        Divider(
                            color = AppColor.black.copy(alpha = 0.1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                                .padding(start = 72.dp)
                        )
                        ProfileItem(
                            text = "История рассрочки",
                            onClick = {},
                            iconId = R.drawable.ic_time_past,
                        )
                        Divider(
                            color = AppColor.black.copy(alpha = 0.1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                                .padding(start = 72.dp)
                        )
                        ProfileItem(
                            text = "Калькулятор рассрочки",
                            onClick = {},
                            iconId = R.drawable.ic_calculator,
                        )
                        Divider(
                            color = AppColor.black.copy(alpha = 0.1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                                .padding(start = 72.dp)
                        )
                        ProfileItem(
                            text = "Магазины", onClick = {}, iconId = R.drawable.ic_shopping_cart,
                        )
                        Divider(
                            color = AppColor.black.copy(alpha = 0.1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                                .padding(start = 72.dp)
                        )
                        ProfileItem(
                            text = "Настройки",
                            onClick = {
                                routes.navigate(Routes.setting)
                            },
                            iconId = R.drawable.ic_settings,
                        )
                        Divider(
                            color = AppColor.black.copy(alpha = 0.1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                                .padding(start = 72.dp)
                        )
                        ProfileItem(
                            text = "Контакты", onClick = {}, iconId = R.drawable.ic_phone,
                        )
                    }
                }
            }
        }

    )
}
