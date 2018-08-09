package app.dsn

import org.simpleframework.xml.*

@Root(name = "dish", strict = false)
class DsnApiDish constructor(
        @field:Attribute
    var name: String = "",

        @field:Attribute
    var azimuthAngle: String = "",

        @field:Attribute
    var elevationAngle: String = "",

        @field:Attribute
    var windSpeed: String = "",

        @field:Attribute
    var isMSPA: Boolean = false,

        @field:Attribute
    var isArray: Boolean = false,

        @field:Attribute
    var isDDOR: Boolean = false,

        @field:Attribute
    var created: String = "",

        @field:Attribute
    var updated: String = "",

        @field:ElementList(entry = "downSignal", inline = true, required = false)
    var downSignals : MutableList<DsnApiSignal> = emptyList<DsnApiSignal>().toMutableList(),

        @field:ElementList(entry = "upSignal", inline = true, required = false)
    var upSignals : MutableList<DsnApiSignal> = emptyList<DsnApiSignal>().toMutableList(),

        @field:ElementList(entry = "target", inline = true, required = false)
    var targets : MutableList<DsnApiTarget> = emptyList<DsnApiTarget>().toMutableList()

)