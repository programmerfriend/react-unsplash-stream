package com.programmerfriend.unsplash.usecases

import reactor.core.publisher.Mono

interface UseCase<in Request, Response> {
    fun execute(request: Request): Mono<Response>
}

interface UseCaseExecutor {
    operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Mono<Request>,
        responseConverter: (Response) -> Mono<ResponseDto>
    ): Mono<ResponseDto>
}

class UseCaseExecutorImp : UseCaseExecutor {
    override operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Mono<Request>,
        responseConverter: (Response) -> Mono<ResponseDto>
    ): Mono<ResponseDto> =
        requestConverter(requestDto)
            .flatMap { useCase.execute(it) }
            .flatMap { responseConverter(it) }
}