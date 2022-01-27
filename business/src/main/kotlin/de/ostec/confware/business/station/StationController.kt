package de.ostec.confware.business.station

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class StationController(private val service: Service) {
    @GetMapping("/event/{eventId}/station/{stationId}")
    fun loadConfig(
        @PathVariable eventId:String, @PathVariable stationId:String
    ) = service.getConfig(eventId, stationId)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found")
}