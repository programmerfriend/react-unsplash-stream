package com.programmerfriend.unsplash.usecases.images

import com.programmerfriend.unsplash.core.UnsplashImage
import com.programmerfriend.unsplash.usecases.UseCase

class GetAllImagesUseCase(private val unsplashImageRepository: UnsplashImageRepository) : UseCase<Unit, List<UnsplashImage>> {
    override fun execute(request: Unit): List<UnsplashImage> = unsplashImageRepository.getLatestUnsplashImages()

    interface UnsplashImageRepository {
        fun getLatestUnsplashImages(): List<UnsplashImage>
    }
}