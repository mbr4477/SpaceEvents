package com.matthewrussell.spaceevents.app.persistence.injection

import com.matthewrussell.spaceevents.usecases.app.persistence.Preferences
import com.matthewrussell.spaceevents.usecases.app.persistence.database.AppDatabase
import dagger.Module
import dagger.Provides
import com.matthewrussell.spaceevents.entity.persistence.IAppDatabase
import com.matthewrussell.spaceevents.entity.persistence.IPreferences

@Module
class PersistenceModule {
    @Provides
    fun providesPreferences(): IPreferences = Preferences
    @Provides
    fun providesDatabase(): IAppDatabase = AppDatabase
}