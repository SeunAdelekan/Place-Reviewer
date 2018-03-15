package com.example.placereviewer.service

import com.example.placereviewer.data.model.Review

interface ReviewService {

    fun createReview(reviewerUsername: String, reviewData: Review): Boolean

    fun listReviews(): Iterable<Review>
}