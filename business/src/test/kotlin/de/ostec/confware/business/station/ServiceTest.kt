package de.ostec.confware.business.station

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ServiceTest {
    @Test
    fun getConfig() {
        val station = Service().getConfig("eventId", "stationId")

        assertThat(station.uuid).isEqualTo("stationId")
    }
}