package com.stu74522.ca2_stu74522

class Movie (

    val title: String,
    val image: Int,

    val description: String,
    val starring: List<String>,
    val runningTimeMins: Int,
    public var seatsRemaining: Int,
    public var seatsSelected: Int = 0
    )