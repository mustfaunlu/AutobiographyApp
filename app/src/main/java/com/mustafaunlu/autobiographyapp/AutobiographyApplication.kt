package com.mustafaunlu.autobiographyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Hilt Kutuphanesi'nin dependencyleri yonetebilmesi için gerekli olan Application sınıfı.
 */
@HiltAndroidApp
class AutobiographyApplication : Application()
