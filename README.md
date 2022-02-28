# Getting Started

# Overview

This is a public application for connection to Neo4J. Also comes with some publicly available seed data.

# Requirements

In order to run this application you need to install Neo4j (Neo4j Desktop recommended) and either
setup the password the same as the `application-local.yml` & `application-test.yml` or change the property files for
each to match your password. Same with the database names - current are:

* LOCAL: `thewell`
* TEST: `theabyss`

Nonprod and Prod is not included as a `yml` for security reasons - if you see either profiles know that you will
have to provide your own to access the code.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0-M2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0-M2/gradle-plugin/reference/html/#build-image)
* [Spring Data Neo4j](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-neo4j)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with Neo4j](https://spring.io/guides/gs/accessing-data-neo4j/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Spring Neo4J](https://neo4j.com/developer/spring-data-neo4j/)

