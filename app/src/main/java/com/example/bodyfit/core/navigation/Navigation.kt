package com.example.bodyfit.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bodyfit.feature.Join.ui.JoinScreen
import com.example.bodyfit.feature.activity.ui.ActivityScreen
import com.example.bodyfit.feature.home.ui.HomeScreen
import com.example.bodyfit.feature.onboarding.ui.OnboardingScreen
import com.example.bodyfit.feature.profile.ui.ProfileScreen
import com.example.bodyfit.feature.signup.ui.SignUpScreen

sealed class Screen(val route: String) {
    object Onboarding: Screen("onboarding")
    object SignUp: Screen("signup")
    object Join: Screen("join")
    object Home: Screen("home")
    object Activity: Screen("activity")
    object Profile: Screen("profile")
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BodyFitNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ){
        composable(Screen.Onboarding.route){
            OnboardingScreen(
                onJoinClick = {navController.navigate(Screen.Join.route)},
                onSignUpClick = {navController.navigate(Screen.SignUp.route)}
            )
        }
        composable(Screen.Join.route){ JoinScreen(navController) }
        composable(Screen.SignUp.route){ SignUpScreen(navController) }
        composable(Screen.Home.route){ HomeScreen() }
        composable(Screen.Profile.route){ ProfileScreen() }
        composable(Screen.Activity.route){ ActivityScreen() }
    }
}