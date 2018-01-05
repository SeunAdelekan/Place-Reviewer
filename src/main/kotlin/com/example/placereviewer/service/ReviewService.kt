package com.example.placereviewer.service

import com.example.placereviewer.data.model.Review

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
interface ReviewService {

    fun createReview(reviewerUsername: String, reviewData: Review): Boolean

    fun listReviews(): Iterable<Review>
}