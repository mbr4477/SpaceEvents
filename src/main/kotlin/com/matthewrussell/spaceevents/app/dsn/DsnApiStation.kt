package com.matthewrussell.spaceevents.app.dsn

import org.simpleframework.xml.*

@Root(strict = false, name = "station")
class DsnApiStation constructor(
        @field:Attribute(name = "name")
        var name: String = "",

        @field:Attribute
        var friendlyName: String = "",

        @field:Attribute
        var timeUTC: String = "",

        @field:Attribute
        var timeZoneOffset: String = ""

)