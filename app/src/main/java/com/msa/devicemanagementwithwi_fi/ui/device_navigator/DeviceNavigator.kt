@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.devicemanagementwithwi_fi.ui.device_navigator

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.msa.devicemanagementwithwi_fi.ui.activity.MainViewModel
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.AnimatedNavigationBar
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.animation.balltrajectory.Parabolic
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.animation.indendshape.Height
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.animation.indendshape.shapeCornerRadius
import com.msa.devicemanagementwithwi_fi.ui.device_navigator.bottomNav.utils.noRippleClickable
import com.msa.devicemanagementwithwi_fi.ui.screen.report.ReportScreen
import com.msa.devicemanagementwithwi_fi.ui.screen.setting.SettingScreen
import com.msa.devicemanagementwithwi_fi.ui.theme.Pink40


@Composable
fun DeiceNavigator(
    mainViewModel: MainViewModel
) {

    val navigationBarItem = remember {
        NavigationBarItems.values()
    }

    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value


    Scaffold(
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 40.dp)
                    .height(85.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = Pink40,
                ballColor = Pink40
            ) {
                navigationBarItem.forEachIndexed() { index, it ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable {
                                selectedIndex = index
                                when (index) {
                                    0 -> navigateToTab(
                                        navController = navController,
                                        route = Route.SettingScreen.route
                                    )

                                    1 -> navigateToTab(
                                        navController = navController,
                                        route = Route.ReportScreen.route
                                    )

                                    else -> {}
                                }

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(26.dp),
                            imageVector = it.icon,
                            contentDescription = "Bottom Bar",
                            tint = Color.White
                        )
                    }
                }

            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.SettingScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.SettingScreen.route) {
                SettingScreen(mainViewModel)
            }

            composable(route = Route.ReportScreen.route) {
                ReportScreen(mainViewModel)
            }

        }
    }
}


@Preview
@Composable
fun DeiceNavigatorPreview() {
    MainViewModel()
    DeiceNavigator(MainViewModel())
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.SettingScreen.route
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}


enum class NavigationBarItems(val icon: ImageVector) {
    Setting(icon = Icons.Default.Settings),
    Report(icon = Icons.Default.Analytics),

}