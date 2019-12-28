package com.programmerfriend.unsplash.core

import java.net.URI
import java.util.*

data class UnsplashImage(
    val id: String,
    val createdBy: String,
    val description: String,
    val createdAt: Date,
    val updatedAt: Date,
    val dimensions: Dimensions,
    val imageUrls: ImageUrls
)

data class ImageUrls(
    val preview: URI,
    val full: URI
)

data class Dimensions(
    val width: Int,
    val height: Int
)