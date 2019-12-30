package com.programmerfriend.unsplash.delivery.rest.imp

import com.programmerfriend.unsplash.delivery.rest.api.ImageDto
import com.programmerfriend.unsplash.delivery.rest.api.ImagesResource
import com.programmerfriend.unsplash.delivery.rest.api.toDto
import com.programmerfriend.unsplash.usecases.UseCaseExecutor
import com.programmerfriend.unsplash.usecases.images.GetNewImagesUseCase
import reactor.core.publisher.Flux

class ImagesResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getNewImagesUseCase: GetNewImagesUseCase
) : ImagesResource {

    override fun getLatestImages(): Flux<List<ImageDto>> {
        return useCaseExecutor.executeForFlux(
            useCase = getNewImagesUseCase,
            requestDto = Unit,
            requestConverter = { _ -> Flux.just(Unit) },
            responseConverter = { imageList ->
                Flux.just(imageList.map { it.toDto() })
            })

    }
}