package com.example.placereviewer.service

interface UserService {

    fun register(username: String, email: String, password: String): Boolean
}