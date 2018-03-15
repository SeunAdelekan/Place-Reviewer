package com.example.placereviewer.service

import com.example.placereviewer.data.model.User
import org.springframework.stereotype.Service

@Service
internal class TestUserServiceImpl : TestUserService {

    /**
     * Test stub mimicking user retrieval
     */
    override fun getUser(): User {
        return User(
                "user@gmaiil.com",
                "test.user",
                "password")
    }
}