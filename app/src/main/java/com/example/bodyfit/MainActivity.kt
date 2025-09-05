package com.example.bodyfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bodyfit.core.theme.BodyFitTheme
import com.example.bodyfit.feature.onboarding.ui.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BodyFitTheme {
                OnboardingScreen(
                    onJoinClick = {},
                    onSignUpClick = {}
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun BodyFitPreview() {
    BodyFitTheme {
        OnboardingScreen(
            onJoinClick = {},
            onSignUpClick = {}
        )
    }
}