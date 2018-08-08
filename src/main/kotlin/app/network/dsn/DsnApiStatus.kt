package app.network.dsn

import org.simpleframework.xml.*

// root class of DSN Api Response
@Root(strict = false, name = "dsn")
class DsnApiStatus constructor(
        @field:Element(name = "timestamp", required = false)
        var timestamp: String = "",

        @field:ElementList(entry = "station", inline = true)
        var stations : MutableList<DsnApiStation> = emptyList<DsnApiStation>().toMutableList(),

        @field:ElementList(entry = "dish", inline = true)
        var dishes : MutableList<DsnApiDish> = emptyList<DsnApiDish>().toMutableList()

)




