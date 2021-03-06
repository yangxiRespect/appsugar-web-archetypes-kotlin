package org.appsugar.archetypes

import org.appsugar.archetypes.repository.CustomSimpleJpaRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomSimpleJpaRepository::class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableHazelcastHttpSession
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}