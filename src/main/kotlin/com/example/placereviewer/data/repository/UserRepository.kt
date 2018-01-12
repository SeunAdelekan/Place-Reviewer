package com.example.placereviewer.data.repository


import com.example.placereviewer.data.model.User
import org.springframework.data.repository.CrudRepository

/**
 * @author Iyanu Adelekan on 08/10/2017.
 */
interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?
}