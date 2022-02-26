package com.violabs.apollo.controller

import com.violabs.apollo.service.DefaultService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

abstract class DefaultController<T>(protected val service: DefaultService<T>) {
  @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE])
  fun fetchAll(): Flux<T> = service.findAll()

  @GetMapping("/{id}", produces = [MediaType.TEXT_EVENT_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE])
  fun fetchById(@PathVariable id: Long): Mono<T> = service.findById(id)

  @PostMapping("/single", produces = [MediaType.TEXT_EVENT_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE])
  fun <S : T> create(@RequestBody node: S): Mono<S> = service.save(node)

  @PostMapping("/multiple", produces = [MediaType.TEXT_EVENT_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE])
  fun <S : T> create(@RequestBody nodes: Set<S>): Flux<S> = service.saveAll(nodes)

  @GetMapping("/{id}/exists")
  fun existsById(@PathVariable id: Long): Mono<Boolean> = service.existsById(id)

  @DeleteMapping("/{id}")
  fun deleteById(@PathVariable id: Long): Mono<Boolean> = service.deleteById(id)
}