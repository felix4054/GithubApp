package by.kavalchuk.aliaksandr.github.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import by.kavalchuk.aliaksandr.github.R


@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Box(Modifier.fillMaxWidth()) {
                Text(
                    stringResource(id = R.string.app_name),
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.sp,
                )
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}