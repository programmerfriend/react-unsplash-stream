package com.programmerfriend.unsplash.delivery.rest.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/images")
interface ImagesResource {
    @GetMapping()
    fun getImages(): Mono<List<ImageDto>>

    @GetMapping("/latest", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getLatestImages(): Flux<ImageDto>

    @GetMapping("/test1")
    fun test(): Mono<String>
}