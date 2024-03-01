package com.stan.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Onboarding(navController: NavHostController) {

    val context = LocalContext.current;
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(0.dp)

    ) {
       Header()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.military))
                .height(120.dp)
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Let's get to know you",
                color = Color.White
            )

        }

        Column(

        ) {
            Text(
                text = "Personal Information",
                fontWeight = FontWeight.Bold,

                modifier = Modifier
                    .padding(1.dp, 10.dp)
            )
        }

        OutlinedTextField(

            value = firstName,
            onValueChange = { firstName = it },
            placeholder = { Text("First Name") },
            singleLine = true,
            modifier = Modifier
                .padding(0.dp, 30.dp, 0.dp)
        )

        OutlinedTextField(

            value = lastName,
            onValueChange = { lastName = it },
            placeholder = { Text("Last Name") },
            singleLine = true,
            modifier = Modifier
                .padding(0.dp, 10.dp)
        )

        OutlinedTextField(

            value = emailAddress,
            onValueChange = { emailAddress = it },
            placeholder = { Text("Email") },
            singleLine = true,
            modifier = Modifier
                .padding(10.dp)

        )

        Button(
            onClick = {
                if (firstName.isBlank()
                    || lastName.isBlank()
                    || emailAddress.isBlank()
                ) {
                    Toast.makeText(
                        context,
                        "Registration unsuccessful. Please enter all data",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val sharedPreferences =
                        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
                    // Edit the SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putString("firstName", firstName) // Save first name
                    editor.putString("lastName", lastName) // Save last name
                    editor.putString("email", emailAddress) // Save email
                    editor.apply() // Apply the changes asynchronously
                    navController.navigate(Home.route)
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.amber)),
            modifier =
            Modifier

                .padding(70.dp)
                .clip(CircleShape)
                .fillMaxWidth(1f)

        )


        {
            Text(text = "Register")
        }

    }


}










