package de.ostec.confware.business.station

import FireStoreHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest
@Testcontainers
internal class RepositoryTest {

    companion object {
        @Container
        private val firestoreEmulator = FireStoreHelper.getEmulatorContainer()

        @JvmStatic
        @DynamicPropertySource
        fun emulatorProperties(registry: DynamicPropertyRegistry) = FireStoreHelper.setProperties(registry)
    }

    @Autowired
    lateinit var repository: Repository

    private val firestore = FireStoreHelper.client()

    @BeforeEach
    fun initDatabase() {
        val events = firestore.collection("events")
        val eventRef = events.document("1-1-1-1")
        val stationRef = eventRef.collection("stations").document("2-2-2-2")

        eventRef.set(mapOf(
            "name" to "Event One",
            "logo" to "Event Logo",
            "style" to "{\"color\":\"red\"}"
        )).get()

        stationRef.set(mapOf(
            "name" to "Station One",
            "logo" to "Station Logo",
            "style" to "{\"color\":\"blue\"}"
        )).get()
    }

    @Test
    fun getEventIfNotExists() {
        assertThat(repository.getEvent("1-1-1-2")).isNull()
    }

    @Test
    fun getEventIfExists() {
        val result = repository.getEvent("1-1-1-1")

        assertThat(result).isInstanceOf(EventEntity::class.java)
        result?.let {
            assertAll(
                {assertThat(it.id).isEqualTo("1-1-1-1")},
                {assertThat(it.name).isEqualTo("Event One")},
                {assertThat(it.logo).isEqualTo("Event Logo")},
                {assertThat(it.style).isEqualTo("{\"color\":\"red\"}")},
            )
        }
    }

    @Test
    fun getStationIfNotExists() {
        assertThat(repository.getStation("1-1-1-2", "2-2-2-3")).isNull()
    }

    @Test
    fun getStationIfExists() {
        val result = repository.getStation("1-1-1-1", "2-2-2-2")

        assertThat(result).isInstanceOf(StationEntity::class.java)
        result?.let {
            assertAll(
                {assertThat(it.id).isEqualTo("2-2-2-2")},
                {assertThat(it.name).isEqualTo("Station One")},
                {assertThat(it.logo).isEqualTo("Station Logo")},
                {assertThat(it.style).isEqualTo("{\"color\":\"blue\"}")}
            )
        }
    }
}