package com.example.placereviewer.service

import com.example.placereviewer.data.model.Review
import com.example.placereviewer.data.model.User
import com.example.placereviewer.data.repository.ReviewRepository
import com.example.placereviewer.data.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
@Service
class ReviewServiceImpl(val reviewRepository: ReviewRepository, val userRepository: UserRepository) : ReviewService {

    private val logger: Logger = LoggerFactory.getLogger(ReviewServiceImpl::class.java)

    override fun listReviews(): Iterable<Review> {
        return reviewRepository.findAll()
    }

    override fun createReview(reviewerUsername: String, reviewData: Review): Boolean {
        val reviewer: User? = userRepository.findByUsername(reviewerUsername)

        if (reviewer != null) {
            reviewData.reviewer = reviewer
            reviewRepository.save(reviewData)
            return true
        }

        return false
    }
}