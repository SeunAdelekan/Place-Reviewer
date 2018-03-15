package com.example.placereviewer.service

import com.example.placereviewer.data.model.Review
import com.example.placereviewer.data.model.User
import com.example.placereviewer.data.repository.ReviewRepository
import com.example.placereviewer.data.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ReviewServiceImpl(private val reviewRepository: ReviewRepository, private val userRepository: UserRepository) : ReviewService {

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