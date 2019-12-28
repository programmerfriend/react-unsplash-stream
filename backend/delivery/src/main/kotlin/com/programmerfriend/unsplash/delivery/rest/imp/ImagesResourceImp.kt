package com.programmerfriend.unsplash.delivery.rest.imp

import com.programmerfriend.unsplash.delivery.rest.api.ImageDto
import com.programmerfriend.unsplash.delivery.rest.api.ImagesResource
import com.programmerfriend.unsplash.delivery.rest.api.toDto
import com.programmerfriend.unsplash.usecases.UseCaseExecutor
import com.programmerfriend.unsplash.usecases.images.GetAllImagesUseCase
import java.util.concurrent.CompletionStage

class ImagesResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getAllImagesUseCase: GetAllImagesUseCase
) : ImagesResource {

    override fun getLatestImages(): CompletionStage<List<ImageDto>> =
        useCaseExecutor(useCase = getAllImagesUseCase,
            requestDto = Unit,
            requestConverter = {},
            responseConverter = { it.map { image -> image.toDto() } })

}