package com.example.placereviewer.service

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
interface SecurityService {

    fun findLoggedInUser(): String?

    fun autoLogin(username: String, password: String)
}