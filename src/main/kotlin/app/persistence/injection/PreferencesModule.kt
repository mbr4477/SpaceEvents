package app.persistence.injection

import dagger.Module
import dagger.Provides
import entity.persistence.IPreferences
import app.persistence.PreferencesImpl

@Module
class PreferencesModule {
    @Provides
    fun providesPreferences() : IPreferences = PreferencesImpl
}