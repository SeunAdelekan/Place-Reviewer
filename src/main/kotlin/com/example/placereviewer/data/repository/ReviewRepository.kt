package com.example.placereviewer.data.repository

import com.example.placereviewer.data.model.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review, Long> {

    fun findByPlaceId(placeId: String)
}