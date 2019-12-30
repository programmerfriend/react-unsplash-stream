package com.programmerfriend.unsplashmock

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PhotosController(private val objectMapper: ObjectMapper) {

    var mockedJson = objectMapper.readTree(ClassPathResource("data/getPhotos.json").file)


    @GetMapping("/photos")
    fun getAllPhotos(): JsonNode = mockedJson
}