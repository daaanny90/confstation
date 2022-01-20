package de.ostec.confware.business.station

import org.springframework.stereotype.Service

@Service
class Service {
    fun getConfig(eventId: String, stationId:String) : Station {
        return Station(
            stationId,
            "Erster TestEvent",
            App("Memory", "ConfMemory"),
            App("Newsletter", "ConfNewsletter"))
    }
}