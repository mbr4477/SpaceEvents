package app.dsn

import org.simpleframework.xml.*

@Root(name = "signal", strict = false)
class DsnApiSignal constructor(
        @field:Attribute
        var signalType : String = "",
        @field:Attribute
        var signalTypeDebug : String = "",
        @field:Attribute
        var dataRate : String = "",
        @field:Attribute
        var frequency : String = "",
        @field:Attribute
        var power : String = "",
        @field:Attribute
        var spacecraft : String = "",
        @field:Attribute
        var spacecraftId : String = ""
)