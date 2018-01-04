package com.example.placereviewer.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Controller
@RequestMapping("/reviews")
class ReviewController {

    @PostMapping("/")
    fun create(request: HttpServletRequest, model: Model) {

    }

    @GetMapping("/new")
    fun writeReview(request: HttpServletRequest, model: Model): String {
        return "create-review"
    }
}