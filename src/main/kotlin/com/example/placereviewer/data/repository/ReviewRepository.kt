package com.example.placereviewer.data.repository

import com.example.placereviewer.data.model.Review
import org.springframework.data.repository.CrudRepository

/**
 * @author Iyanu Adelekan on 04/01/2018.
 */
interface ReviewRepository : CrudRepository<Review, Long> {

    fun findByPlaceId(placeId: String)
}