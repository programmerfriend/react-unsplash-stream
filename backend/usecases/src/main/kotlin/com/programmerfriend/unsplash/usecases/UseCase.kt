package com.programmerfriend.unsplash.usecases

import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UseCase<in Request, Response> {
    fun execute(request: Request): Publisher<Response>
}

interface UseCaseExecutor {
    fun <RequestDto, ResponseDto, Request, Response> executeForMono(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Mono<Request>,
        responseConverter: (Response) -> Mono<ResponseDto>
    ): Mono<ResponseDto>

    fun <RequestDto, ResponseDto, Request, Response> executeForFlux(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Flux<Request>,
        responseConverter: (Response) -> Flux<ResponseDto>
    ): Flux<ResponseDto>
}

class UseCaseExecutorImp : UseCaseExecutor {
    override fun <RequestDto, ResponseDto, Request, Response> executeForMono(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Mono<Request>,
        responseConverter: (Response) -> Mono<ResponseDto>
    ): Mono<ResponseDto> =
        requestConverter(requestDto)
            .flatMap { useCase.execute(it) as Mono }
            .flatMap { responseConverter(it) }

    override fun <RequestDto, ResponseDto, Request, Response> executeForFlux(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Flux<Request>,
        responseConverter: (Response) -> Flux<ResponseDto>
    ): Flux<ResponseDto> =
        requestConverter(requestDto)
            .flatMap { useCase.execute(it) }
            .flatMap { responseConverter(it) }
}