package de.ostec.confware.business.station

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

internal class StationControllerTest {

    @Test
    fun loadConfigCallsService() {
        val service = mockk<Service>()
        every { service.getConfig(any(), any()) } returns mockk()

        StationController(service).loadConfig("a", "b")

        verify { service.getConfig("a", "b") }
        confirmVerified(service)
    }

    @Test
    fun loadConfigReturnsStation() {
        val station = mockk<Station>()
        val service = mockk<Service>()
        every { service.getConfig(any(), any()) } returns station

        assertThat(StationController(service).loadConfig("a", "b")).isSameAs(station)
    }

    @Test
    fun loadConfigThrow404IfStationNotExists() {
        val service = mockk<Service>()
        every { service.getConfig(any(), any()) } returns null

        val exception = assertThrows<ResponseStatusException> {
            StationController(service).loadConfig("a", "b")
        }

        assertAll(
            { assertThat(exception.status).isEqualTo(HttpStatus.NOT_FOUND) },
            { assertThat(exception.reason).isEqualTo("Not Found") },
        )
    }
}