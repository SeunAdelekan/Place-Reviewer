package com.example.placereviewer

import com.example.placereviewer.config.TestConfig
import com.example.placereviewer.data.model.User
import com.example.placereviewer.service.TestUserService
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ContextConfiguration(classes = [TestConfig::class])
class PlaceReviewerApplicationTests {

	@Autowired
	lateinit var userService: TestUserService

	@Test
	fun testUserRetrieval() {
		val user = userService.getUser()

		assertThat(user, instanceOf(User::class.java))
	}
}