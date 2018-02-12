package com.example.placereviewer.component

import com.example.placereviewer.data.model.User
import com.example.placereviewer.data.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Component
class UserValidator(private val userRepository: UserRepository) : Validator {

    override fun supports(aClass: Class<*>?): Boolean {
        return User::class == aClass
    }

    override fun validate(obj: Any?, errors: Errors) {
        val user: User = obj as User

        /*
         * Validating that submitted user parameters are not empty
         * An empty parameter is rejected with an error code and error message
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Empty.userForm.username",
                "Username cannot be empty")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Empty.userForm.password",
                "Password cannot be empty")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Empty.userForm.email",
                "Email cannot be empty")

        /*
         * Validating the length of a submitted username
         * A username whose length is less than 6 is rejected
         */
        if (user.username.length < 6) {
            errors.rejectValue("username", "Length.userForm.username",
                    "Username must be at least 6 characters in length")
        }

        /*
         * Validating the submitted username does not already exist
         * A username already taken by a user is rejected
         */
        if (userRepository.findByUsername(user.username) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username", "Username unavailable")
        }

        /*
         * Validating the length of a submitted password
         * Passwords less than 8 characters in length are rejected
         */
        if (user.password.length < 8) {
            errors.rejectValue("password", "Length.userForm.password",
                    "Password must be at least 8 characters in length")
        }
    }
}