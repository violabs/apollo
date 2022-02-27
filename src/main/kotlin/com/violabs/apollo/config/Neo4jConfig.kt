package com.violabs.apollo.config

import org.neo4j.driver.Driver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension
import org.springframework.transaction.ReactiveTransactionManager

@Configuration
class Neo4jConfig {
  /**
   * Intellij red error - not sure how to fix but this works
   */
  @Bean(ReactiveNeo4jRepositoryConfigurationExtension.DEFAULT_TRANSACTION_MANAGER_BEAN_NAME)
  fun reactiveTransactionManager(
    driver: Driver,
    databaseNameProvider: ReactiveDatabaseSelectionProvider
  ): ReactiveTransactionManager {
    return ReactiveNeo4jTransactionManager(driver, databaseNameProvider)
  }
}