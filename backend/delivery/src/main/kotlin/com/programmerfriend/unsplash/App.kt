package com.programmerfriend.unsplash

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import reactor.blockhound.BlockHound
import reactor.core.publisher.Hooks

@SpringBootApplication
class App

fun main(args: Array<String>) {
    BlockHound.install()
    Hooks.onOperatorDebug()
    SpringApplication.run(App::class.java, *args)
}