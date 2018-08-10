package com.matthewrussell.spaceevents.app.persistence.database

import com.matthewrussell.spaceevents.app.persistence.database.dao.DishDao
import com.matthewrussell.spaceevents.app.persistence.database.dao.Models
import com.matthewrussell.spaceevents.app.persistence.database.dao.SignalDao
import com.matthewrussell.spaceevents.app.persistence.database.mapper.DishMapper
import com.matthewrussell.spaceevents.app.persistence.database.mapper.SignalMapper
import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.model.Signal
import com.matthewrussell.spaceevents.entity.persistence.Dao
import com.matthewrussell.spaceevents.entity.persistence.IAppDatabase
import io.requery.Persistable
import io.requery.sql.KotlinConfiguration
import io.requery.sql.KotlinEntityDataStore
import io.requery.sql.SchemaModifier
import io.requery.sql.TableCreationMode
import org.sqlite.SQLiteDataSource

object AppDatabase : IAppDatabase {
    private val dataStore: KotlinEntityDataStore<Persistable>
    override val dishDao: Dao<Dish>
    override val signalDao: Dao<Signal>

    init {
        Class.forName("org.sqlite.JDBC")
        val dataSource = SQLiteDataSource()
        dataSource.url = "jdbc:sqlite:content.sqlite"

        SchemaModifier(dataSource, Models.DEFAULT).createTables(TableCreationMode.CREATE_NOT_EXISTS)

        val config = KotlinConfiguration(dataSource = dataSource, model = Models.DEFAULT)

        dataStore = KotlinEntityDataStore<Persistable>(config)

        dishDao = DishDao(dataStore, DishMapper())
        signalDao = SignalDao(dataStore, SignalMapper(dishDao))
    }
}