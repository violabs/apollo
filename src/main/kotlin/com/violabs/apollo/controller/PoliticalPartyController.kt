package com.violabs.apollo.controller

import com.violabs.apollo.domain.nodes.PoliticalParty
import com.violabs.apollo.service.PoliticalPartyService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/political-parties")
class PoliticalPartyController(politicalPartyService: PoliticalPartyService) :
  DefaultController<PoliticalParty>(politicalPartyService)