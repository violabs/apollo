package com.violabs.apollo.controller

import com.violabs.apollo.domain.nodes.GovernmentRole
import com.violabs.apollo.service.GovernmentRoleService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/government-roles")
class GovernmentRoleController(governmentRoleService: GovernmentRoleService) :
  DefaultController<GovernmentRole>(governmentRoleService)