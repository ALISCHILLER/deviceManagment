package com.msa.devicemanagementwithwi_fi.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msa.devicemanagementwithwi_fi.ui.activity.MainViewModel
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.DeiceNavigator
import com.msa.devicemanagementwithwi_fi.ui.theme.DeviceManagementWithWiFiTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val sharedViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeviceManagementWithWiFiTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DeiceNavigator(sharedViewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeviceManagementWithWiFiTheme {
        DeiceNavigator(MainViewModel())
    }
}