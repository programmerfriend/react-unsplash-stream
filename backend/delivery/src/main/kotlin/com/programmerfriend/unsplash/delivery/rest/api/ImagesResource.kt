package com.programmerfriend.unsplash.delivery.rest.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/images")
interface ImagesResource {
    @GetMapping("/latest")
    fun getLatestImages(): CompletionStage<List<ImageDto>>
}