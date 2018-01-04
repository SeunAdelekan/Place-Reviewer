package com.example.placereviewer.service

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
interface UserService {

    fun register(username: String, email: String, password: String): Boolean
}