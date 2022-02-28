package com.violabs.apollo

import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import reactor.core.CorePublisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

abstract class KSpock {
  var mocks = listOf<Any>()
  private val mockCalls = mutableListOf<() -> Unit>()
  private val verifiable = mutableListOf<() -> Unit>()

  fun <U> assertEquals(expected: U, actual: U, message: String? = null) {
    assert(expected == actual) {
      println("FAILED $message")
      println("Expected: $expected")
      println("Actual:   $actual")
    }
  }

  fun <MOCK, R> verifyMock(mock: MOCK, returnItem: R, times: Int = 1, mockCall: (MOCK) -> R) {
    whenever(mockCall(mock)).thenReturn(returnItem)
    verifiable.add { mockCall(verify(mock, times(times))) }
  }

  fun <T> test(runnable: KSpec<T>.() -> Unit) {
    runnable(KSpec())
    verifiable.forEach { it.invoke() }

    if (mocks.isEmpty()) return

    verifyNoMoreInteractions(*mocks.toTypedArray())
    cleanup()
  }

  fun <T> testMono(runnable: KSpecMono<T>.() -> Unit) = testPublisher(KSpecMono(), runnable)

  fun <T> testFlux(runnable: KSpecFlux<T>.() -> Unit) = testPublisher(KSpecFlux(), runnable)

  private fun <T, P : CorePublisher<T>, K : KSpecPublisher<T, P>> testPublisher(
    spec: K,
    runnable: K.() -> Unit
  ) {
    runnable(spec)

    if (mocks.isEmpty()) return

    verifiable.forEach { it.invoke() }

    verifyNoMoreInteractions(*mocks.toTypedArray())
    cleanup()
  }


  private fun cleanup() {
    verifiable.clear()
    mockCalls.clear()
  }

  class KSpec<T> {
    var expected: T? = null
    var actual: T? = null

    fun given(givenFn: () -> T?) {
      expected = givenFn()
    }

    fun whenever(whenFn: () -> T?) {
      actual = whenFn()
    }

    fun then(thenFn: (T?, T?) -> Unit) {
      thenFn(expected, actual)
    }

    fun thenEquals(message: String, runnable: (() -> Unit)? = null) {
      runnable?.invoke()

      assert(expected == actual) {
        println("FAILED $message")
        println("Expected: $expected")
        println("Actual:   $actual")
      }
    }
  }

  class KSpecMono<T> : KSpecPublisher<T, Mono<T>>(Mono.empty())

  class KSpecFlux<T> : KSpecPublisher<T, Flux<T>>(Flux.empty())

  abstract class KSpecPublisher<T, P : CorePublisher<T>>(private var actual: P) {
    fun given(givenFn: () -> Unit) {
      givenFn()
    }

    fun whenever(whenFn: () -> P) {
      actual = whenFn()
    }

    fun then(thenFn: (StepVerifier.Step<T>) -> Unit) {
      actual
        .let(StepVerifier::create)
        .also(thenFn)
        .let(StepVerifier.Step<T?>::verifyComplete)
    }
  }
}