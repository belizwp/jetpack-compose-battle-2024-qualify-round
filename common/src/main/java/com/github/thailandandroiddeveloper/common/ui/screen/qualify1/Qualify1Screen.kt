package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify1Screen() {
    Scaffold(
        topBar = { MainTopAppBar() },
        containerColor = Color.White,
    ) { paddingValues ->
        MainContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar() {
    TopAppBar(
        title = { /*TODO*/ },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_qualify_1_menu),
                contentDescription = "Navigation menu",
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_qualify_1_profile),
                contentDescription = "Profile menu",
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
    )
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .padding(bottom = 8.dp)
    ) {
        ProfileCard(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .offset(y = (-24).dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ThumbDownButton()
            ThumbUpButton()
        }
    }
}

@Composable
private fun ProfileCard(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.clip(MaterialTheme.shapes.large)
    ) {
        Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(R.drawable.img_qualify_1_profile),
            contentDescription = "Profile image",
        )
        ProfileDescription(Modifier.align(Alignment.BottomStart))
    }
}

@Composable
private fun ProfileDescription(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(192.dp)
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.75f))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_qualify_1_gender_male),
                contentDescription = "Gender male",
                tint = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "Male",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
private fun ThumbDownButton() {
    Button(
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.errorContainer,
            contentColor = MaterialTheme.colorScheme.onErrorContainer,
        ),
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_qualify_1_thumb_down),
            contentDescription = "Thumb down"
        )
    }
}

@Composable
private fun ThumbUpButton() {
    Button(
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_qualify_1_thumb_up),
            contentDescription = "Thumb up"
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion