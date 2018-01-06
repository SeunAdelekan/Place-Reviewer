package com.example.placereviewer.component

import com.example.placereviewer.data.model.Review
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Component
class ReviewValidator: Validator {

    override fun supports(aClass: Class<*>?): Boolean {
        return Review::class == aClass
    }

    override fun validate(obj: Any?, errors: Errors?) {
        val review = obj as Review

        ValidationUtils.rejectIfEmpty(errors, "title", "Empty.reviewForm.title")
        ValidationUtils.rejectIfEmpty(errors, "body", "Empty.reviewForm.body")
        ValidationUtils.rejectIfEmpty(errors, "placeName", "Empty.reviewForm.placeName")
        ValidationUtils.rejectIfEmpty(errors, "placeAddress", "Empty.reviewForm.placeAddress")
        ValidationUtils.rejectIfEmpty(errors, "placeId", "Empty.reviewForm.placeId")
        ValidationUtils.rejectIfEmpty(errors, "latitude", "Empty.reviewForm.latitude")
        ValidationUtils.rejectIfEmpty(errors, "longitude", "Empty.reviewForm.longitude")

//        if (review.title.length < 5) {
//            errors?.rejectValue("title", "Size.reviewForm.title")
//        }
//
//        if (review.body.length < 5) {
//            errors?.rejectValue("body", "Size.reviewForm.body")
//        }
//
//        if (review.placeAddress.length < 10) {
//            errors?.rejectValue("placeAddress", "Size.reviewForm.place_address")
//        }
//
//        if (review.placeName.length < 2) {
//            errors?.rejectValue("placeName", "Size.reviewForm.place_name")
//        }
    }
}