package com.programmerfriend.unsplash.usecases.images

import com.programmerfriend.unsplash.core.UnsplashImage
import com.programmerfriend.unsplash.usecases.UseCase
import com.programmerfriend.unsplash.usecases.gateways.UnsplashRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

class GetNewImagesUseCase(private val unsplashImageRepository: UnsplashRepository) : UseCase<Unit, List<UnsplashImage>> {

    private val alreadySeenIds = HashSet<String>()

    private val flux = Flux
        .interval(Duration.ofSeconds(30))
        .flatMap {
            unsplashImageRepository.getLatestUnsplashImages().flatMap { Mono.just(it.filter { alreadySeenIds.add(it.id) }) }
        }
        .share()

    override fun execute(request: Unit): Flux<List<UnsplashImage>> {
        return flux
    }

    interface UnsplashImageRepository {
        fun getLatestUnsplashImages(): Mono<List<UnsplashImage>>
    }
}