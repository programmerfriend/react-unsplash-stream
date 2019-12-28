package com.programmerfriend.unsplash.delivery.rest.api

import com.programmerfriend.unsplash.core.UnsplashImage
import java.net.URI

data class ImageDto(
    val id: String,
    val creator: String,
    val previewUrl: URI,
    val fullUrl: URI
)

fun UnsplashImage.toDto() = ImageDto(
    id = this.id,
    creator = this.createdBy,
    previewUrl = this.imageUrls.preview,
    fullUrl = this.imageUrls.full
)