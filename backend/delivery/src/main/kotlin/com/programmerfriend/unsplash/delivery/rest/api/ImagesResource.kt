package com.programmerfriend.unsplash.delivery.rest.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/images")
interface ImagesResource {
    @GetMapping("/latest")
    fun getLatestImages(): Mono<List<ImageDto>>
}