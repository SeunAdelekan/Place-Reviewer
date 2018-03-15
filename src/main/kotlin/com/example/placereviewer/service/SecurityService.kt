package com.example.placereviewer.service

interface SecurityService {

    fun findLoggedInUser(): String?

    fun autoLogin(username: String, password: String)
}