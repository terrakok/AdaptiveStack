package org.company.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.terrakok.adaptivestack.HorizontalAdaptiveStack
import com.github.terrakok.adaptivestack.VerticalAdaptiveStack
import org.company.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    HorizontalAdaptiveStack(
        modifier = Modifier.fillMaxSize().padding(8.dp),
    ) {
        VerticalAdaptiveStack {
            repeat(5) {
                Box(
                    Modifier
                        .size(40.dp)
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )
            }
        }
        HorizontalAdaptiveStack {
            repeat(3) {
                Box(
                    Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary)
                )
            }
        }
    }
}
