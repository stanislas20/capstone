package com.stan.littlelemon

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Profile(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    var firstName = sharedPreferences.getString("firstName", "")
    var lastName = sharedPreferences.getString("lastName", "")
    var email = sharedPreferences.getString("email", "")

    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Text(
            text = "Personal Information",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 0.dp, 0.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Text(
                text = "First name",
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 40.dp, 0.dp)
            )


            OutlinedTextField(

                value = firstName!!,
                onValueChange = { firstName = it },
                placeholder = { Text("First Name") },
                singleLine = true,
                modifier = Modifier
                    .padding(40.dp, 0.dp, 0.dp)
            )

            Text(
                text = "Last name",
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 20.dp, 0.dp)
            )


            OutlinedTextField(

                value = lastName!!,
                onValueChange = { lastName = it },
                placeholder = { Text("Last Name") },
                singleLine = true,
                modifier = Modifier
                    .padding(40.dp, 0.dp, 0.dp)
            )

            Text(
                text = "Email",
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 20.dp, 0.dp)
            )


            OutlinedTextField(

                value = email!!,
                onValueChange = { email = it },
                placeholder = { Text("Email") },
                singleLine = true,
                modifier = Modifier
                    .padding(40.dp, 0.dp, 0.dp)
            )

            Button(
                onClick = {
                    firstName = ""
                    lastName = ""
                    email = ""
                    navController.navigate(Onboarding.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.amber)),
                modifier = Modifier
                    .padding(70.dp)
                    .clip(CircleShape)
                    .fillMaxWidth(1f)
            )
            {
                Text(text = "Log out")
            }

        }

    }
}

