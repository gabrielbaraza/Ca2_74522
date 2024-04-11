package com.stu74522.ca2_stu74522

sealed class Routes(val route: String) {
    object FirstScreen : Routes("first_screen")
    object SecondScreen : Routes("second_screen")
    object ThirdScreen : Routes("third_screen")
    object FourthScreen : Routes("fourth_screen")
    object FifthScreen : Routes("fifth_screen")
}