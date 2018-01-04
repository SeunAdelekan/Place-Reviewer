package com.example.placereviewer.component

import com.example.placereviewer.data.model.User
import com.example.placereviewer.data.repository.UserRepository
import com.example.placereviewer.service.UserService
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

    override fun validate(obj: Any?, errors: Errors?) {
        val user: User = obj as User

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "USR_001")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "USR_001")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "USR_001")

        if (user.username.length < 6 || user.username.length > 32) {
            errors?.rejectValue("username", "Size.userForm.username")
        }
        if (userRepository.findByUsername(user.username) != null) {
            errors?.rejectValue("username", "Duplicate.userForm.username")
        }

        if (user.password.length < 8) {
            errors?.rejectValue("password", "Size.userForm.password");
        }
    }
}