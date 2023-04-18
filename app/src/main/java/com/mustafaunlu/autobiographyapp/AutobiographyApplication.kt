package com.mustafaunlu.autobiographyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The [Application] class for Hilt dependency injection library to work.
 * Provides the application context to the Hilt library.
 */
@HiltAndroidApp
class AutobiographyApplication : Application()
