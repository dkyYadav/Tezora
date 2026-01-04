package com.example.tezora.presentation.HomeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomBottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    onCartClick: () -> Unit
) {
    Box {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            tonalElevation = 6.dp
        ) {
            BottomBarItem(
                icon = Icons.Outlined.Home,
                label = "Home",
                isSelected = selectedIndex == 0,
                onClick = { onItemSelected(0) }
            )

            BottomBarItem(
                icon = Icons.Outlined.FavoriteBorder,
                label = "Wishlist",
                isSelected = selectedIndex == 1,
                onClick = { onItemSelected(1) }
            )

            Spacer(modifier = Modifier.weight(1f))

            BottomBarItem(
                icon = Icons.Outlined.Search,
                label = "Search",
                isSelected = selectedIndex == 3,
                onClick = { onItemSelected(3) }
            )

            BottomBarItem(
                icon = Icons.Outlined.Settings,
                label = "Setting",
                isSelected = selectedIndex == 4,
                onClick = { onItemSelected(4) }
            )
        }

        FloatingActionButton(
            onClick = onCartClick,
            containerColor = Color.Red,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-28).dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.White
            )
        }
    }
}


@Composable
fun RowScope.BottomBarItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        icon = {
            Icon(icon, contentDescription = label)
        },
        label = {
            Text(text = label, fontSize = 12.sp)
        },
        alwaysShowLabel = true
    )
}



@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableStateOf(0) }
/*
    Scaffold(
        bottomBar = {
            CustomBottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it },
                onCartClick = {
                    // Navigate to Cart Screen
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            // Your screen content
        }
    }*/
}
