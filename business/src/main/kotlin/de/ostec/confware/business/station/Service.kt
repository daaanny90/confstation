package de.ostec.confware.business.station

import org.springframework.stereotype.Service

@Service
class Service(private val repository: Repository) {
    fun getConfig(eventId: String, stationId:String) : Station? {

        repository.getEvent(eventId)?.let { event ->
            repository.getStation(eventId, stationId)?.let { station ->
                return Station(
                    station.id,
                    station.name,
                    Event(
                        event.id,
                        event.name,
                        Logo(event.logo, event.name)
                    ),
                    Logo(station.logo, station.name),
                    Theme(station.style)
                )
            }
        }
        return null
    }
}
