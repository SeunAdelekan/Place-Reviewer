package com.example.placereviewer.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Controller
class ApplicationController {

    @GetMapping("/register")
    fun register(model: Model): String {
        return "register"
    }

    @GetMapping("/home")
    fun home(request: HttpServletRequest, model: Model): String {
        return "home"
    }

    @GetMapping("/create-review")
    fun createReview(request: HttpServletRequest, model: Model): String {
        return "create-review"
    }
}