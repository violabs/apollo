package com.violabs.apollo.service

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DefaultService<T> {
  fun findById(id: Long): Mono<T>
  fun findAll(): Flux<T>
  fun <S : T> save(node: S?): Mono<S>
  fun <S : T> saveAll(nodes: Set<S>): Flux<S>
  fun existsById(id: Long): Mono<Boolean>
  fun deleteById(id: Long): Mono<Boolean>
}

abstract class MainDefaultService<T>(protected val repo: ReactiveNeo4jRepository<T, Long>) {
  fun findById(id: Long): Mono<T> {
    return repo.findById(id)
  }

  fun findAll(): Flux<T> {
    return repo.findAll()
  }

  fun <S : T> save(node: S?): Mono<S> {
    return node
      ?.let(repo::save)
      ?: Mono.empty()
  }

  fun <S : T> saveAll(nodes: Set<S>): Flux<S> {
    return Flux
      .fromIterable(nodes)
      .flatMap(this::save)
  }

  fun existsById(id: Long): Mono<Boolean> {
    return repo.existsById(id)
  }

  fun deleteById(id: Long): Mono<Boolean> {
    return repo
      .existsById(id)
      .flatMap { this.deleteAndCheck(id, it) }
  }

  private fun deleteAndCheck(id: Long, check: Boolean): Mono<Boolean> {
    if (!check) return Mono.just(false)

    return repo
      .deleteById(id)
      .then(repo.existsById(id).map { !it })
  }
}