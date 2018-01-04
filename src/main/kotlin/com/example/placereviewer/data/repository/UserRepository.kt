package com.example.placereviewer.data.repository

/**
 * @author Iyanu Adelekan on 02/01/2018.
 */

import com.example.placereviewer.data.model.User
import org.springframework.data.repository.CrudRepository

/**
 * @author Iyanu Adelekan on 08/10/2017.
 */
interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?

    fun findByEmail(email: String): User?
}