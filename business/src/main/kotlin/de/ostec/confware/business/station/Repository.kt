package de.ostec.confware.business.station

import com.google.cloud.firestore.Firestore
import org.springframework.stereotype.Repository

@Repository
class Repository(private val firestore: Firestore) {
    fun getEvent(eventId:String): EventEntity? {
        val event = firestore.collection("events").document(eventId).get().get()
        if (event.exists()) {
            return EventEntity(
                event.id,
                event.getString("name") ?: "",
                event.getString("logo") ?: "",
                event.getString("style") ?: ""
            )
        }
        return null
    }

    fun getStation(eventId:String, stationId:String): StationEntity? {
        val station = firestore
            .collection("events")
            .document(eventId)
            .collection("stations")
            .document(stationId)
            .get().get()

        if (station.exists()) {
            return StationEntity(
                station.id,
                station.getString("name") ?: "",
                station.getString("logo") ?: "",
                station.getString("style") ?: "",
            )
        }
        return null
    }
}


class EventEntity (
    val id:String,
    val name:String,
    val logo:String,
    val style: String
)

class StationEntity (
    val id:String,
    val name:String,
    val logo:String,
    val style: String
)