@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.msa.devicemanagementwithwi_fi.ui.screen.setting


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msa.devicemanagementwithwi_fi.ui.activity.MainViewModel
import com.msa.devicemanagementwithwi_fi.ui.screen.setting.component.ItemContentScreen
import com.msa.devicemanagementwithwi_fi.ui.screen.setting.component.ItemsContentList
import com.msa.devicemanagementwithwi_fi.ui.screen.setting.component.TopAppBarSettingScreen
import com.msa.devicemanagementwithwi_fi.ui.theme.DeviceManagementWithWiFiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    mainViewModel: MainViewModel
) {


    Scaffold(
        topBar = {
            TopAppBarSettingScreen()
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        val list = ItemsContentList.myItems

        LazyColumn(

            modifier = Modifier
                .padding(it),
        ) {
            items(list) {
                ItemContentScreen(
                    it.textValue,
                    it.lottieIcon
                )
            }

        }
    }
}


@Composable
@Preview
fun SettingScreenPreview() {
    DeviceManagementWithWiFiTheme {
        SettingScreen(MainViewModel())
    }


}