package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    Scaffold(
        bottomBar = { TutorialBottomBar() },
        containerColor = MaterialTheme.colorScheme.onPrimary,
    ) { paddingValues ->
        TutorialContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}

@Composable
private fun TutorialBottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(102.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            modifier = Modifier
                .height(40.dp)
                .width(251.dp)
                .fillMaxWidth(),
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
private fun TutorialContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        TextButton(
            modifier = Modifier
                .padding(top = 8.dp, end = 8.dp)
                .height(40.dp)
                .align(Alignment.End),
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Skip")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Lorem ipsum dolor sit amet",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(modifier = Modifier.height(35.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(446.dp),
                painter = painterResource(R.drawable.img_qualify_2_onboard),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.height(34.dp))
            PagerIndicator(pageCount = 5, currentPage = 3)
        }
    }
}

@Composable
private fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
) {
    val normalColor = MaterialTheme.colorScheme.primaryContainer
    val selectedColor = MaterialTheme.colorScheme.primary
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
    ) {
        repeat(pageCount) { index ->
            if (index == currentPage) {
                Box(
                    Modifier
                        .width(32.dp)
                        .height(16.dp)
                        .background(color = selectedColor, shape = RoundedCornerShape(size = 16.dp))
                )
            } else {
                Canvas(Modifier.size(16.dp)) {
                    drawCircle(color = normalColor)
                }
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion