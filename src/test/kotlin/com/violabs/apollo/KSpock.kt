package com.violabs.apollo

import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

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

  fun <T>  test(runnable: KSpec<T>.() -> Unit) {
    runnable(KSpec())
    verifiable.forEach { it.invoke() }

    if (mocks.isEmpty()) return

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
}