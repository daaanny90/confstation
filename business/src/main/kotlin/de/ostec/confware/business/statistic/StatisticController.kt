package de.ostec.confware.business.statistic

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class StatisticController {
    @GetMapping("/event/{eventId}/station/{stationId}/statistic")
    fun info(@PathVariable eventId:String, @PathVariable stationId:String): Statistik {
        return Statistik(
            Random.nextInt(0, 100),
            Random.nextInt(0, 100),
            Random.nextInt(0, 100),
            Random.nextInt(0, 100),
            Random.nextInt(0, 100)
        )
    }
}