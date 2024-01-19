package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    Scaffold(
        topBar = { ProfileTopAppBar() },
        containerColor = MaterialTheme.colorScheme.onPrimary,
    ) { paddingValues ->
        ProfileContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "John Doe")
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_qualify_3_back),
                    contentDescription = null,
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_qualify_3_copy),
                    contentDescription = null,
                )
            }
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_qualify_3_calendar),
                    contentDescription = null,
                )
            }
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_qualify_3_menu),
                    contentDescription = null,
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
    )
}

@Composable
private fun ProfileContent(
    modifier: Modifier = Modifier,
) {
    val profileCardDetails = remember {
        listOf(
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
            "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
            "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget.",
        )
    }
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            PhotosRow()
        }
        item {
            TagsRow()
        }
        items(profileCardDetails.size) { index ->
            ProfileCard(
                detail = profileCardDetails[index],
            )
        }
    }
}

@Composable
private fun PhotosRow() {
    val photoResIds = remember {
        listOf(
            R.drawable.img_qualify_3_photo_1,
            R.drawable.img_qualify_3_photo_2,
            R.drawable.img_qualify_3_photo_3,
        )
    }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(photoResIds) { index, photoResId ->
            Image(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = if (index == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .width(160.dp)
                    .height(320.dp)
                    .clip(RoundedCornerShape(size = 16.dp)),
                painter = painterResource(photoResId), contentDescription = null
            )
        }
    }
}

@Composable
private fun TagsRow() {
    LazyRow(
        modifier = Modifier.height(32.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        repeat(4) {
            item(key = it) {
                AssistChip(
                    modifier = Modifier
                        .width(68.dp)
                        .height(32.dp),
                    onClick = { /*TODO*/ },
                    label = {
                        Text(text = "Tag ${it + 1}")
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        labelColor = if (it == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    ),
                    border = AssistChipDefaults.assistChipBorder(
                        borderColor = if (it == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    ),
                )
            }
        }
    }
}

@Composable
private fun ProfileCard(
    modifier: Modifier = Modifier,
    detail: String = "\n",
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
//                shape = RoundedCornerShape(size = 16.dp)
            )
            .fillMaxWidth()
            .height(96.dp)
            .padding(16.dp),
    ) {
        Image(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.img_qualify_3_sender),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                text = "Lorem Ipsum",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = detail,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion