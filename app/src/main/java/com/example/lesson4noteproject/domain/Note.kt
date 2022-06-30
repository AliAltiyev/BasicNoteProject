package com.example.lesson4noteproject.domain

data class Note(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID

    ) {

    companion object {

        const val UNDEFINED_ID = -1
    }


}

