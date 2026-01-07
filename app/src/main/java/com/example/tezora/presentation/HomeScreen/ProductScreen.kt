package com.example.tezora.presentation.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.tezora.Uistate
import com.example.tezora.domain.model.ProductX
import com.example.tezora.presentation.HomeScreen.viewModel.AppViewModels
import com.example.tezora.presentation.HomeScreen.viewModel.ProductViewModel
import kotlin.compareTo
import kotlin.div
import kotlin.times

@Composable
fun ProductScreen() {

    val viewModel: ProductViewModel = AppViewModels.productViewModel
    val productsState by viewModel.productsState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),  // <-- important
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        when (productsState) {
            is Uistate.Idle -> Text("Nothing")
            is Uistate.Failure -> Text("Error")
            is  Uistate.Loading -> CircularProgressIndicator()
            is Uistate.Success -> {
                val products = (productsState as Uistate.Success).data

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    items(products) { product ->
                        ProductItem(product)
                    }
                }
            }
        }
    }
}



@Composable
fun ProductItem(product: ProductX) {

   val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // Product Image
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(context)
                    .data(product.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF5F5F5)),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 2.dp
                        )
                    }
                },
                error = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFF5F5F5)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No Image",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Product Title
            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Product Description
            Text(
                text = product.description,
                fontSize = 12.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Price and Rating Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    // Discounted Price
                    Text(
                        text = "₹${String.format("%.0f", product.price * 83)}", // Convert to INR approximately
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    // Original Price (if there's a discount)
                    if (product.discountPercentage > 0) {
                        val originalPrice = product.price / (1 - product.discountPercentage / 100)
                        Text(
                            text = "₹${String.format("%.0f", originalPrice * 83)}",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }

               // Rating and Share
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StarRating(
                        rating = product.rating,
                        starSize = 14.dp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = String.format("%.1f", product.rating),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Default.Share,
                            contentDescription = "Share",
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun StarRating(
    rating: Double,
    starSize: Dp = 16.dp,
    maxStars: Int = 5
) {
    Row {
        repeat(maxStars) { index ->
            val starRating = when {
                rating >= index + 1 -> 1.0 // Full star
                rating > index -> rating - index // Partial star
                else -> 0.0 // Empty star
            }

            Box {
                // Background (empty) star
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFE0E0E0), // Light gray for empty
                    modifier = Modifier.size(starSize)
                )

                // Foreground (filled) star with clipping for partial fill
                if (starRating > 0) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFA726), // Orange for filled
                        modifier = Modifier
                            .size(starSize)
                            .clipToBounds()
                            .drawWithContent {
                                clipRect(
                                    right = size.width * starRating.toFloat()
                                ) {
                                    this@drawWithContent.drawContent()
                                }
                            }
                    )
                }
            }
        }
    }
}
