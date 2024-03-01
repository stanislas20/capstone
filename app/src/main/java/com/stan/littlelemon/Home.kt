package com.stan.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavController) {

    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.little_lemon_logo),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(150.dp)
                .height(10.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = stringResource(R.string.navigate_to_profile),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .height(10.dp)
                .padding(0.dp,50.dp,0.dp)
                .clickable (onClick = {navController.navigate(Profile.route)})
        )
    }
}






