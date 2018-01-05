package com.example.placereviewer.controller

import com.example.placereviewer.component.ReviewValidator
import com.example.placereviewer.data.model.Review
import com.example.placereviewer.service.ReviewService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Controller
@RequestMapping("/reviews")
class ReviewController(val reviewValidator: ReviewValidator, val reviewService: ReviewService) {

    private val logger: Logger = LoggerFactory.getLogger(ReviewController::class.java)

    @PostMapping
    fun create(@ModelAttribute reviewForm: Review, bindingResult: BindingResult, model: Model,
               request: HttpServletRequest): String {
        reviewValidator.validate(reviewForm, bindingResult)

        bindingResult.allErrors.forEach { error -> logger.error("ERROR:::",error.defaultMessage) }

        if (!bindingResult.hasErrors()) {
            logger.info("Principal name::", request.userPrincipal.name)

            val res = reviewService.createReview(request.userPrincipal.name, reviewForm)
            logger.error("Result::", res.toString())

            if (res) {
                return "redirect:/home"
            }
        }

        return "create-review"
    }

    @GetMapping("/new")
    fun writeReview(request: HttpServletRequest, model: Model): String {
        return "create-review"
    }
}