package com.violabs.apollo.service

import com.violabs.apollo.KSpock
import com.violabs.apollo.domain.NodeEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

abstract class StandardServiceIntegrationTest<T : NodeEntity, S : DefaultService<T>> : KSpock() {
  private var _service: S? = null
  private var _focusedItem: T? = null
  private var defaultSavedItems: Set<T> = setOf()
  private val service: S by lazy { this._service!! }
  private val focusedItem: T by lazy { this._focusedItem!! }

  protected fun initializeTest(
    service: S,
    focusedItem: T,
    defaultSavedItems: Set<T> = setOf(),
  ) {
    this._service = service
    this.defaultSavedItems = defaultSavedItems
    this._focusedItem = focusedItem
  }

  @AfterEach
  fun teardown() {
    service.deleteAll()
  }

  @Test
  fun `findById works`() = testMono<T> {
    val expected: T =
      service
        .saveAll(defaultSavedItems)
        .blockLast()!!

    whenever { service.findById(expected.id!!) }

    then { it.checkSteps(1, setOf(expected)) }
  }

  @Test
  fun `saveAll and findAll works`() = testFlux<T> {
    given {
      service
        .saveAll(defaultSavedItems)
        .blockLast()
    }

    whenever { service.findAll() }

    then { it.checkSteps(defaultSavedItems.size, defaultSavedItems) }
  }

  @Test
  fun `save works`() = testMono<T> {
    whenever { service.save(focusedItem) }

    then { it.checkSteps(1, setOf(focusedItem)) }
  }

  @Test
  fun `existsById does not find existing`() = testMono<Boolean> {
    whenever { service.existsById(1000L) }

    then { it.expectNext(false) }
  }

  @Test
  fun `existsById finds existing`() = testMono<Boolean> {
    val id = saveForTests()

    whenever { service.existsById(id) }

    then { it.expectNext(true) }
  }

  @Test
  fun `deleteById does not delete if it does not exist`() = testMono<Boolean> {
    whenever { service.deleteById(1L) }

    then { it.expectNext(false) }
  }

  @Test
  fun `deleteById works`() = testMono<Boolean> {
    val id: Long = saveForTests()

    whenever { service.deleteById(id) }

    then { it.expectNext(true) }
  }

  private fun saveForTests(): Long =
    service
      .save(focusedItem)
      .block()
      ?.id
      ?: 0

  private fun StepVerifier.Step<T>.checkSteps(
    times: Int = 1,
    expectedItems: Set<T>
  ): StepVerifier.Step<T> = also {
    (0 until times).forEach { _ ->
      this.expectNextMatches { it in expectedItems }
    }
  }
}