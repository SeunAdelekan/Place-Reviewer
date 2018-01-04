package com.example.placereviewer.service

import com.example.placereviewer.data.model.Review
import com.example.placereviewer.data.repository.ReviewRepository
import org.springframework.stereotype.Service

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Service
class ReviewServiceImpl(val reviewRepository: ReviewRepository) : ReviewService {
    override fun listReviews(): List<Review> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createReview(title: String, body: String, placeName: String, placeAddress: String, placeId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}