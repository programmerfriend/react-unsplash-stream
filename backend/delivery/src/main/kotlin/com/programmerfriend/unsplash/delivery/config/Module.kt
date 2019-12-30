package com.programmerfriend.unsplash.delivery.config

import com.programmerfriend.unsplash.dataproviders.rest.UnsplashImageRestRepository
import com.programmerfriend.unsplash.delivery.rest.imp.ImagesResourceImp
import com.programmerfriend.unsplash.usecases.UseCaseExecutor
import com.programmerfriend.unsplash.usecases.UseCaseExecutorImp
import com.programmerfriend.unsplash.usecases.gateways.UnsplashRepository
import com.programmerfriend.unsplash.usecases.images.GetNewImagesUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Module {

    @Bean
    fun imagesResourceImp(useCaseExecutor: UseCaseExecutor, getNewImagesUseCase: GetNewImagesUseCase) =
        ImagesResourceImp(useCaseExecutor, getNewImagesUseCase)

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun getNewImagesUseCase(unsplashRepository: UnsplashRepository) = GetNewImagesUseCase(unsplashRepository)

    @Bean
    fun unsplashRepository() = UnsplashImageRestRepository()

}