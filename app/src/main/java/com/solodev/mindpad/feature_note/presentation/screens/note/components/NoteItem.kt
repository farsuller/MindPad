package com.solodev.mindpad.feature_note.presentation.screens.note.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.solodev.mindpad.feature_note.domain.model.Note
import com.solodev.mindpad.ui.theme.MindPadTheme
import com.solodev.mindpad.utils.Constants.TestTags.NOTE_ITEM
import com.solodev.mindpad.utils.clickableWithoutRipple

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = modifier.testTag(NOTE_ITEM),
    ) {
        Canvas(
            modifier = Modifier.matchParentSize(),
        ) {
            val clipPath = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }

            clipPath(clipPath) {
                drawRoundRect(
                    color = Color(note.color),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
                drawRoundRect(
                    color = Color(ColorUtils.blendARGB(note.color, 0x000000, 0.2f)),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                    size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = note.content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.End)
                    .clickableWithoutRipple(onClick = { onDeleteClick() }),
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete note",
                tint = MaterialTheme.colorScheme.tertiary
            )


        }

    }
}

@Preview
@Composable
fun NoteItemPreview() {
    MindPadTheme {
        Surface {
            NoteItem(
                note = Note(
                    title = "Test",
                    content = "Test Content Description, " +
                            "Test Content Description, " +
                            "Test Content Description, " +
                            "Test Content Description, " +
                            "Test Content Description " +
                            "Test Content Description " +
                            "Test Content Description " +
                            "Test Content Description " +
                            "Test Content Description " +
                            "Test Content Description " +
                            "Test Content Description",
                    timestamp = 0,
                    color = 0
                ),
                onDeleteClick = {}
            )
        }
    }
}