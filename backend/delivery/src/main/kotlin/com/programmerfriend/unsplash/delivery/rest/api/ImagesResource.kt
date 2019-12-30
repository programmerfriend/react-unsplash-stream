package com.programmerfriend.unsplash.delivery.rest.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/images")
interface ImagesResource {
    @GetMapping("/latest", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getLatestImages(): Flux<List<ImageDto>>
}