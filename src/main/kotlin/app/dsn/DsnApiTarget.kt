package app.dsn

import org.simpleframework.xml.*

@Root(name = "target", strict = false)
class DsnApiTarget constructor(
        @field:Attribute
        var name : String = "",
        @field:Attribute
        var id : String = "",
        @field:Attribute
        var uplegRange : String = "",
        @field:Attribute
        var downlegRange : String = "",
        // Round trip light time
        @field:Attribute
        var rtlt : String = ""
)