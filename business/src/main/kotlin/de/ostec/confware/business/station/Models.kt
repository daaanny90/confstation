package de.ostec.confware.business.station

import java.util.*

class Event(
    val uuid:String,
    val name:String,
    val activityTracking: Boolean,
    val cookieAgreement: Boolean,
    val theme:String
)

class Price(
    val uuid:String,
    val name:String,
    val availableTime: Date,
    val available:Boolean
)

class Station(
    val uuid:String,
    val name:String,
    val main:App,
    val lead:App
)

class App(val id:String, val name:String)