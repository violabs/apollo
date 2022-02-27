import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.0-M2"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.10"
  kotlin("plugin.spring") version "1.6.10"
}

group = "com.violabs"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
  mavenCentral()
  maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
  // Spring
  implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.boot:spring-boot-starter-web")

  // Kotlin
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

  // Testing
  testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework:spring-webflux")
  testImplementation("io.projectreactor:reactor-test")

  // Future use
//  implementation("org.springframework.boot:spring-boot-starter-graphql")
//  testImplementation("org.testcontainers:junit-jupiter:1.16.3")
//  testImplementation("org.testcontainers:neo4j:1.16.3")
//  testImplementation("org.neo4j.test:neo4j-harness:4.4.4")
//  testImplementation("org.springframework.graphql:spring-graphql-test")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
