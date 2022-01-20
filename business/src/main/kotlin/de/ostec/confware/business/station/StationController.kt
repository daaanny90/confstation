package de.ostec.confware.business.station

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StationController(private val service: Service) {
    @GetMapping("/event/{eventId}/station/{stationId}")
    fun loadConfig(
        @PathVariable eventId:String, @PathVariable stationId:String
    ) = service.getConfig(eventId, stationId)
}