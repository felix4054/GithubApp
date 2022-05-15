package by.kavalchuk.aliaksandr.github.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import by.kavalchuk.aliaksandr.github.data.network.model.Item
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GitIListItem(item: Item, navController: NavController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
//                navController.navigate(Screens.Details.route + "/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .padding(horizontal = 10.dp)
        ) {
            GlideImage(
                imageModel = item.owner?.avatar_url,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp),
                loading = {
                    Box(
                        modifier = Modifier.size(20.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
            )
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)
            ){
                item.name?.let { name ->
                    Text(
                        text = name,
                        maxLines = 1,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                item.description?.let { description ->
                    Text(
                        text = description,
//                        maxLines = 2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
//                        style = MaterialTheme.typography.body1,
//                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
