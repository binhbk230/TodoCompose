package com.mitch.appname.ui.screens.bottombar

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mitch.appname.R
import com.mitch.appname.navigation.NavGraphs
import com.mitch.appname.navigation.appCurrentDestinationAsState
import com.mitch.appname.navigation.destinations.Destination
import com.mitch.appname.navigation.destinations.HomeRouteDestination
import com.mitch.appname.navigation.destinations.SecondScreenDestination
import com.mitch.appname.navigation.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

@Composable
fun CustomBottomBar(
    navController: NavController
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    NavigationBar {
        BottomBarDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = stringResource(id = destination.label))},
                label = { Text(stringResource(id = destination.label)) },
            )
        }
    }
}

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Home(HomeRouteDestination, Icons.Default.Home, R.string.bottom_home),
    Second(SecondScreenDestination, Icons.Default.Email, R.string.home_second),
}