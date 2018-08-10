package com.matthewrussell.spaceevents.app.persistence.database

import io.requery.*

@Entity
interface ISignalEntity : Persistable {
    @get:Key
    @get:Generated
    var id: Int
    var spacecraft: String
    var signalType: String
    var frequency: Double
    var power: Double
    var dataRate: Double
    var rtlt: Double
    var isDownlink: Boolean
    @get:ForeignKey
    var dishFk: Int
}