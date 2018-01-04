package com.example.placereviewer.controller

import com.example.placereviewer.component.UserValidator
import com.example.placereviewer.data.model.User
import com.example.placereviewer.service.SecurityService
import com.example.placereviewer.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author Iyanu Adelekan on 02/01/2018.
 */
@Controller
@RequestMapping("/users")
class UserController(val userValidator: UserValidator, val userService: UserService,
                     val securityService: SecurityService) {

    @PostMapping("/registrations")
    fun create(@ModelAttribute form: User, bindingResult: BindingResult): String {
        userValidator.validate(form, bindingResult)

        if (bindingResult.hasErrors()) {
            return "register"
        }

        userService.register(form.username, form.email, form.password)
        securityService.autoLogin(form.username, form.password)

        return "redirect:/home"
    }
}