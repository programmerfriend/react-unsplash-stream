package com.programmerfriend.unsplash.delivery.config

import com.programmerfriend.unsplash.dataproviders.rest.UnsplashImageRestRepository
import com.programmerfriend.unsplash.delivery.rest.imp.ImagesResourceImp
import com.programmerfriend.unsplash.usecases.UseCaseExecutor
import com.programmerfriend.unsplash.usecases.UseCaseExecutorImp
import com.programmerfriend.unsplash.usecases.gateways.UnsplashRepository
import com.programmerfriend.unsplash.usecases.images.GetAllImagesUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Module {

    @Bean
    fun imagesResourceImp(useCaseExecutor: UseCaseExecutor, getAllImagesUseCase: GetAllImagesUseCase) =
        ImagesResourceImp(useCaseExecutor, getAllImagesUseCase)

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun getAllImagesUseCase(unsplashRepository: UnsplashRepository) = GetAllImagesUseCase(unsplashRepository)

    @Bean
    fun unsplashRepository() = UnsplashImageRestRepository()
}