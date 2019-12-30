package com.programmerfriend.unsplash.delivery.rest.imp

import com.programmerfriend.unsplash.delivery.rest.api.ImageDto
import com.programmerfriend.unsplash.delivery.rest.api.ImagesResource
import com.programmerfriend.unsplash.delivery.rest.api.toDto
import com.programmerfriend.unsplash.usecases.UseCaseExecutor
import com.programmerfriend.unsplash.usecases.images.GetAllImagesUseCase
import reactor.core.publisher.Mono

class ImagesResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getAllImagesUseCase: GetAllImagesUseCase
) : ImagesResource {

    override fun getLatestImages(): Mono<List<ImageDto>> =
        useCaseExecutor(
            useCase = getAllImagesUseCase,
            requestDto = Unit,
            requestConverter = { _ -> Mono.just(Unit)},
            responseConverter = { images ->
                Mono.just(images.map { it.toDto() })
            })

}