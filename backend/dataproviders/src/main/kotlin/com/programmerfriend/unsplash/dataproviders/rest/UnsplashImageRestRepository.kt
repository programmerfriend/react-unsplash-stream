package com.programmerfriend.unsplash.dataproviders.rest

import com.programmerfriend.unsplash.core.Dimensions
import com.programmerfriend.unsplash.core.ImageUrls
import com.programmerfriend.unsplash.core.UnsplashImage
import com.programmerfriend.unsplash.usecases.gateways.UnsplashRepository
import java.net.URI
import java.time.Instant
import java.util.*

class UnsplashImageRestRepository : UnsplashRepository {
    override fun getLatestUnsplashImages(): List<UnsplashImage> {
        //TODO: inject rest client and do real stuff
        val now = Date.from(Instant.now())
        return listOf(
            UnsplashImage(
                id = "1",
                createdBy = "Mo",
                description = "Mo's first image",
                updatedAt = now,
                createdAt = now,
                dimensions = Dimensions(100, 100),
                imageUrls = ImageUrls(
                    URI("http://preview"), URI("http://full")
                )
            )
        )
    }
}