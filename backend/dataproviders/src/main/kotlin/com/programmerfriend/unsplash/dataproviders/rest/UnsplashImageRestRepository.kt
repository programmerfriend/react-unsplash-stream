package com.programmerfriend.unsplash.dataproviders.rest

import com.programmerfriend.unsplash.core.Dimensions
import com.programmerfriend.unsplash.core.ImageUrls
import com.programmerfriend.unsplash.core.UnsplashImage
import com.programmerfriend.unsplash.usecases.gateways.UnsplashRepository
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Instant
import java.util.*


class UnsplashImageRestRepository : UnsplashRepository {

    private var client = WebClient
        .builder()
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build()

    override fun getLatestUnsplashImages(): Mono<List<UnsplashImage>> {
        return client
            .get()
            .uri("http://localhost:9999/photos")
            .exchange()
            .flatMap { resp -> resp.bodyToMono(typeReference<List<UnsplashDto>>()) }
            .map { dto -> dto.map { it.toUnsplashImage() } }
    }

    data class UnsplashDto(
        val id: String,
        val user: UserDto,
        val urls: UrlsDto,
        val width: Int,
        val height: Int
    )

    data class UserDto(
        val id: String,
        val username: String
    )

    data class UrlsDto(
        val full: URI,
        val thumb: URI,
        val small: URI
    )

    private fun UnsplashDto.toUnsplashImage() = UnsplashImage(
        id = this.id,
        createdBy = this.user.username,
        createdAt = Date.from(Instant.now()),
        updatedAt = Date.from(Instant.now()),
        description = this.id,
        dimensions = Dimensions(height = this.height, width = this.width),
        imageUrls = this.urls.toImageUrls()
    )

    private fun UrlsDto.toImageUrls() = ImageUrls(preview = this.thumb, full = this.full)


    private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}


}