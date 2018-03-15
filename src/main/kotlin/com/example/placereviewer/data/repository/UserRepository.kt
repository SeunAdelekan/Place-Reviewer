package com.example.placereviewer.data.repository


import com.example.placereviewer.data.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?
}