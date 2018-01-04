package com.example.placereviewer.service

import com.example.placereviewer.data.model.Review

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
interface ReviewService {

    fun createReview(
            title: String,
            body: String,
            placeName: String,
            placeAddress: String,
            placeId: String
    )

    fun listReviews(): List<Review>
}