package com.example.sample.ui.main.profile.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sample.R
import com.example.sample.core.theme.AppColor
import com.example.sample.core.theme.AppShape

@Preview
@Composable
fun ProfileItem(
    text: String, onClick: () -> Unit,
    iconId: Int,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = AppShape.none,
        content = {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp),
                    contentAlignment = Alignment.Center,
                    content = {
                        Icon(
                            painter = painterResource(id = iconId),
                            tint = AppColor.blue,
                            contentDescription = text,
                            modifier = Modifier
                                .size(20.dp),
                        )
                    }
                )
                BoxWithConstraints(
                    modifier = Modifier.weight(1f), content = {
                        Text(text = text)
                    }
                )
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .width(56.dp),
                    painter = painterResource(R.drawable.ic_severicons),
                    contentDescription = "move",
                )
            }
        },
    )
}