package com.msa.devicemanagementwithwi_fi.ui.screen.setting.component

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.msa.devicemanagementwithwi_fi.R
import com.msa.devicemanagementwithwi_fi.ui.theme.*
import com.msa.devicemanagementwithwi_fi.ui.theme.DeviceManagementWithWiFiTheme
import com.msa.devicemanagementwithwi_fi.ui.theme.Diamond

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopAppBarSettingScreen(

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
        ,
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                bottomEnd = 16.dp,
                topEnd = 0.dp,
                bottomStart = 16.dp
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                BlueDark.copy(alpha = 0.2f),
                                Bluelight.copy(alpha = 0.2f),
                            )
                        )
                    )
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .padding(top = 12.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = ""
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                        .padding(top = 12.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .padding(top = 12.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.connected))
                        LottieAnimation(
                            modifier = Modifier
                                .width(70.dp)
                                .weight(1f)
                                .height(70.dp),
                            composition = composition,
                            iterations = LottieConstants.IterateForever,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = "اتصال",
                            color = Color.White
                        )
                    }
                }

            }
        }
    }

}


@Preview
@Composable
fun TopAppBarSettingScreenPreview() {
    TopAppBarSettingScreen()


}