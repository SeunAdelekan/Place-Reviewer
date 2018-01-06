package com.example.placereviewer.controller

import com.example.placereviewer.service.ReviewService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal
import javax.servlet.http.HttpServletRequest

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Controller
class ApplicationController(val reviewService: ReviewService) {

    @GetMapping("/register")
    fun register(model: Model): String {
        return "register"
    }

    @GetMapping("/home")
    fun home(request: HttpServletRequest, model: Model, principal: Principal): String {
        val reviews = reviewService.listReviews()

        model.addAttribute("reviews", reviews)
        model.addAttribute("principal", principal)

        return "home"
    }

    @GetMapping("/create-review")
    fun createReview(request: HttpServletRequest, model: Model): String {
        return "create-review"
    }
}