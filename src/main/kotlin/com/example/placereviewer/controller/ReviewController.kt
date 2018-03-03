package com.example.placereviewer.controller

import com.example.placereviewer.component.ReviewValidator
import com.example.placereviewer.data.model.Review
import com.example.placereviewer.service.ReviewService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal
import javax.servlet.http.HttpServletRequest

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Controller
@RequestMapping("/reviews")
class ReviewController(val reviewValidator: ReviewValidator, val reviewService: ReviewService) {

    @PostMapping
    fun create(@ModelAttribute reviewForm: Review, bindingResult: BindingResult, model: Model,
               request: HttpServletRequest): String {
        reviewValidator.validate(reviewForm, bindingResult)

        if (!bindingResult.hasErrors()) {
            val res = reviewService.createReview(request.userPrincipal.name, reviewForm)

            if (res) {
                return "redirect:/home"
            }
        }

        model.addAttribute("error", bindingResult.allErrors.first().defaultMessage)
        model.addAttribute("title", reviewForm.title)
        model.addAttribute("body", reviewForm.body)
        model.addAttribute("placeName", reviewForm.placeName)
        model.addAttribute("placeAddress", reviewForm.placeAddress)
        model.addAttribute("placeId", reviewForm.placeId)
        model.addAttribute("longitude", reviewForm.longitude)
        model.addAttribute("latitude", reviewForm.latitude)

        return "create-review"
    }
}