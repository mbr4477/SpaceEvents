package app.persistence.injection

import dagger.Component
import entity.persistence.IPreferences
import javax.inject.Singleton


@Component(modules = [PreferencesModule::class])
@Singleton
interface PreferencesComponent {
    fun inject(): IPreferences
}
