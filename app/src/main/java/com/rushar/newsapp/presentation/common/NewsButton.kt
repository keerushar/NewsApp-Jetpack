package com.rushar.newsapp.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rushar.newsapp.ui.theme.NewsAppTheme

@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.h5)
    }
}


@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(text = text, style = MaterialTheme.typography.h5, color = Color.Blue)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsButtonPreview(){
    NewsAppTheme {
        NewsButton("Hello There") { }
    }
}