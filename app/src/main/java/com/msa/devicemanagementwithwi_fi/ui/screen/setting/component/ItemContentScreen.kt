package com.msa.devicemanagementwithwi_fi.ui.screen.setting.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.msa.devicemanagementwithwi_fi.R
import com.msa.devicemanagementwithwi_fi.ui.theme.Bluelight
import com.msa.devicemanagementwithwi_fi.ui.theme.Yellow

@Composable
fun ItemContentScreen(
    textValue: String,
    lottieIcon: Int
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(lottieIcon)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(
                topStart = 16.dp,
                bottomEnd = 16.dp,
                topEnd = 5.dp,
                bottomStart = 5.dp

            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Yellow.copy(alpha = 0.2f),
                                Bluelight.copy(alpha = 0.2f),
                            )
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LottieAnimation(
                    modifier = Modifier
                        .weight(1f),
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                )
                Text(
                    text = textValue,
                    modifier = Modifier
                        .weight(1f),
                )
            }
        }

    }
}


@Preview
@Composable
fun ItemContentPreview() {

    Column {


        ItemContentScreen(
            "شارژ باطری:",
            R.raw.battrey
        )
        ItemContentScreen(
            "دما:",
            R.raw.temperature
        )
        ItemContentScreen(
            "آمونیاک",
            R.raw.chemistry
        )

        ItemContentScreen(
            "رطوبت",
            R.raw.humidity
        )
    }
}