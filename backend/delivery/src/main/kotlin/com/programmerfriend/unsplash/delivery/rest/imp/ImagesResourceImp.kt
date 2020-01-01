package com.programmerfriend.unsplash.delivery.rest.imp

import com.programmerfriend.unsplash.delivery.rest.api.ImageDto
import com.programmerfriend.unsplash.delivery.rest.api.ImagesResource
import com.programmerfriend.unsplash.delivery.rest.api.toDto
import com.programmerfriend.unsplash.usecases.UseCaseExecutor
import com.programmerfriend.unsplash.usecases.images.GetAllImagesUseCase
import org.springframework.web.bind.annotation.GetMapping
import reactor.blockhound.BlockHound
import reactor.core.publisher.Flux
import reactor.core.publisher.Hooks
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration

class ImagesResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getAllImagesUseCase: GetAllImagesUseCase
) : ImagesResource {
    override fun getImages(): Mono<List<ImageDto>> {
        return Mono.just(emptyList())
//        return useCaseExecutor(
//            useCase = getAllImagesUseCase,
//            requestDto = Unit,
//            requestConverter = { _ -> Mono.just(Unit) },
//            responseConverter = { images ->
//                Mono.just(images.map { it.toDto() })
//            }).onErrorStop()
    }

    override fun test(): Mono<String> {
        println("TEST")
        return Mono.just("Test")
    }

    override fun getLatestImages(): Flux<ImageDto> {
        TODO("tap")
//        return Flux.interval(Duration.ofSeconds(1))
//            .map { ImageDto("testId", "Mo", URI("http://example.com"), URI("http://example.com")) }.log()
    }
}