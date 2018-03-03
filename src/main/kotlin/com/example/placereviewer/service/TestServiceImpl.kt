package com.example.placereviewer.service

import com.example.placereviewer.data.model.User
import org.springframework.stereotype.Service

/**
 * @author Iyanu Adelekan on 19/02/2018.
 */
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