package com.matthewrussell.spaceevents.app.persistence.database

import io.requery.Entity
import io.requery.Generated
import io.requery.Key
import io.requery.Persistable

@Entity
interface IDishEntity : Persistable {
    @get:Key
    @get:Generated
    var id: Int
    var name: String
    var location: String
    var elevationAngle: Double
    val azimuthAngle: Double
}