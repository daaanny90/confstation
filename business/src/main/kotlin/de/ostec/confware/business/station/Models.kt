package de.ostec.confware.business.station

class Event(
    val uuid:String,
    val name:String,
    val logo:Logo
)

class Station(
    val uuid:String,
    val name:String,
    val event:Event,
    val logo:Logo,
    val theme: Theme
)

class Logo (val src:String, val title:String)

class Theme (val css:String)