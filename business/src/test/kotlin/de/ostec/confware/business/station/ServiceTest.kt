package de.ostec.confware.business.station

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class ServiceTest {

    @Test
    fun getConfigCallRepositoryGetEvent() {
        val repository = mockk<Repository>()
        every { repository.getEvent(any()) } returns mockk()
        every { repository.getStation(any(), any()) } returns null

        Service(repository).getConfig("eventId", "stationId")

        verify { repository.getEvent("eventId") }
    }

    @Test
    fun getConfigReturnsNullIfEventNotExists() {
        val repository = mockk<Repository>()
        every { repository.getEvent(any()) } returns null

        assertThat(Service(repository).getConfig("eventId", "stationId")).isNull()
    }

    @Test
    fun getConfigCallRepositoryGetStation() {
        val repository = mockk<Repository>()
        every { repository.getEvent(any()) } returns mockk()
        every { repository.getStation(any(), any()) } returns null

        Service(repository).getConfig("eventId", "stationId")

        verify { repository.getStation("eventId", "stationId") }
    }

    @Test
    fun getConfigReturnsNullIfStationNotExists() {
        val repository = mockk<Repository>()
        every { repository.getEvent(any()) } returns mockk()
        every { repository.getStation(any(), any()) } returns null

        assertThat(Service(repository).getConfig("eventId", "stationId")).isNull()
    }

    @Test
    fun getConfigReturnsStation() {
        val repository = mockk<Repository>()
        every { repository.getEvent(any()) } returns EventEntity("eid", "event", "elogo","estyle")
        every { repository.getStation(any(), any()) } returns StationEntity("sid", "station", "slogo", "sstyle")

        val result = Service(repository).getConfig("eventId", "stationId")

        assertThat(result).isInstanceOf(Station::class.java)
        result?.let {
            assertAll(
                {assertThat(it.uuid).isEqualTo("sid")},
                {assertThat(it.name).isEqualTo("station")},

                {assertThat(it.theme).isInstanceOf(Theme::class.java)},
                {assertThat(it.theme.css).isEqualTo("sstyle")},

                {assertThat(it.logo).isInstanceOf(Logo::class.java)},
                {assertThat(it.logo.src).isEqualTo("slogo")},
                {assertThat(it.logo.title).isEqualTo("station")},

                {assertThat(it.event).isInstanceOf(Event::class.java)},
                {assertThat(it.event.uuid).isEqualTo("eid")},
                {assertThat(it.event.name).isEqualTo("event")},

                {assertThat(it.event.logo).isInstanceOf(Logo::class.java)},
                {assertThat(it.event.logo.src).isEqualTo("elogo")},
                {assertThat(it.event.logo.title).isEqualTo("event")},
            )
        }
    }
}