package com.matthewrussell.spaceevents.app.persistence.injection

import dagger.Component
import com.matthewrussell.spaceevents.entity.persistence.IAppDatabase
import com.matthewrussell.spaceevents.entity.persistence.IPreferences
import javax.inject.Singleton


@Component(modules = [PersistenceModule::class])
@Singleton
interface PersistenceComponent {
    fun injectPreferences(): IPreferences
    fun injectDatabase(): IAppDatabase
}
