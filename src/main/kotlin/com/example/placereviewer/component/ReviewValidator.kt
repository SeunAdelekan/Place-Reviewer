package com.example.placereviewer.component

import com.example.placereviewer.data.model.Review
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Component
class ReviewValidator: Validator {

//    val logger: Logger = LoggerFactory.getLogger(ReviewValidator::class.java)

    override fun supports(aClass: Class<*>?): Boolean {
        return Review::class == aClass
    }

    override fun validate(obj: Any?, errors: Errors) {
        val review = obj as Review

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Empty.reviewForm.title",
                "Title cannot be empty")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "Empty.reviewForm.body",
                "Body cannot be empty")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeName", "Empty.reviewForm.placeName")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeAddress", "Empty.reviewForm.placeAddress")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeId", "Empty.reviewForm.placeId")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "latitude", "Empty.reviewForm.latitude")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "longitude", "Empty.reviewForm.longitude")

        if (review.title.length < 5) {
            errors.rejectValue("title", "Length.reviewForm.title",
                    "Title must be at least 5 characters long")
        }

        if (review.body.length < 5) {
            errors.rejectValue("body", "Length.reviewForm.body")
        }

        if (review.placeAddress.length < 10) {
            errors.rejectValue("placeAddress", "Length.reviewForm.placeAddress")
        }

        if (review.placeName.length < 2) {
            errors.rejectValue("placeName", "Length.reviewForm.placeName")
        }
    }
}