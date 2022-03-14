package com.mobiledeveloper.vktube.ui.screens.comments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mobiledeveloper.vktube.ui.theme.Fronton
import com.vk.sdk.api.wall.dto.WallWallComment

data class CommentCellModel(
    val messageId: Int,
    val userId: Long,
    val userName: String,
    val dateAdded: String,
    val avatar: String,
    val text: String
)

fun WallWallComment.mapToCommentCellModel(): CommentCellModel {
    return CommentCellModel(
        messageId = id,
        userId = fromId.value,
        text = text,
        userName = "Unowned user",
        dateAdded = "Unowned date",
        avatar = ""
    )
}

@Composable
fun CommentCell(model: CommentCellModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape),
                model = model.avatar,
                contentDescription = "video preview",
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "${model.userName} • ${model.dateAdded}",
                    style = Fronton.typography.minor.caption,
                    color = Fronton.color.textSecondary
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = model.text,
                    style = Fronton.typography.body.medium.short,
                    color = Fronton.color.textPrimary
                )
            }
        }

        Divider(thickness = 1.dp, color = Fronton.color.controlMinor)
    }
}