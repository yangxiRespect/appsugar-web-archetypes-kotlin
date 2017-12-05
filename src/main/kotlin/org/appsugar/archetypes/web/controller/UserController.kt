package org.appsugar.archetypes.web.controller

import org.appsugar.archetypes.condition.UserCondition
import org.appsugar.archetypes.entity.User
import org.appsugar.archetypes.extension.attr
import org.appsugar.archetypes.repository.RoleRepository
import org.appsugar.archetypes.repository.UserRepository
import org.appsugar.archetypes.repository.UserSpecification
import org.appsugar.archetypes.web.security.Permission
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/system/user")
class UserController(val repository:UserRepository,val roleRepository: RoleRepository) {

	@ModelAttribute("user")
	fun modelAttribute(id:Long?)=when(id){
		null -> User.EMPTY
		else -> repository.findById(id).orElse(User.EMPTY)
	}


	@RequestMapping("list")
	fun list(condition:UserCondition,pageable:Pageable,model:Model)=model.attr("page",repository.findAll(UserSpecification(condition),pageable)).let { "system/user/list" }

	@RequestMapping("/form")
	fun form(model:Model):String{
		model.attr("roles",roleRepository.findAll())
		model.attr("permissionGroups", Permission.GROUP_BY_PREFIX)
		return "system/user/form"
	}
}