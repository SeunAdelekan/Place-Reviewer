package com.example.placereviewer.service

import com.example.placereviewer.data.model.User
import com.example.placereviewer.data.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun register(username: String, email: String, password: String): Boolean {
        val user = User(email, username, password)
        userRepository.save(user)

        return true
    }
}