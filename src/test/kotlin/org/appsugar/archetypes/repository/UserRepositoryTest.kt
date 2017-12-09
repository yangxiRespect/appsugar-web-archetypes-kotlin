package org.appsugar.archetypes.repository

import org.appsugar.archetypes.BaseTestCase
import org.appsugar.archetypes.condition.UserCondition
import org.springframework.beans.factory.annotation.Autowired
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class UserRepositoryTest : BaseTestCase() {
    @Autowired
    lateinit var repository: UserRepository

    @Test
    fun testFindByLoginName() {
        val loginName = "admin"
        val user = repository.findByLoginName(loginName)
        logger.debug("find user by loginName $loginName  result is $user")
        Assertions.assertNotNull(user)
    }

    @Test
    fun testFindByCondition() {
        val condition = UserCondition(name = "NewYoung", loginName = "123")
        val users = repository.findAll(UserSpecification(condition))
        logger.debug("testFindByCondition {} result is {} ", condition, users)
    }
} 