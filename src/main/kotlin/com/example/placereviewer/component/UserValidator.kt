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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Empty.userForm.username",
                "Username cannot be empty")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Empty.userForm.password",
                "Password cannot be empty")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Empty.userForm.email",
                "Email cannot be empty")

        if (user.username.length < 6) {
            errors.rejectValue("username", "Length.userForm.username",
                    "Username must be at least 6 characters in length")
        }
        if (userRepository.findByUsername(user.username) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username", "Username unavailable")
        }

        if (user.password.length < 8) {
            errors.rejectValue("password", "Length.userForm.password",
                    "Password must be at least 8 characters in length")
        }
    }
}