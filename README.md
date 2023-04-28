
## App videos Portrait (PIXEL XL API 33)

<img width="100" height="100" src="" />

## Tech stack & Open-source libraries
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) and [Flow](https://developer.android.com/kotlin/flow) & [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - A single-activity architecture, using the [Jetpack Navigation](https://developer.android.com/guide/navigation) to manage transactions.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in data layer that contains application data and business logic.
    - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) & [DataBinding](https://developer.android.com/topic/libraries/data-binding) - allows you to more easily write code that interacts with views.



- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency Injection Library
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [Gson](https://github.com/google/gson) - A JSON library for Android and Java.
- [Glide](https://bumptech.github.io/glide/doc/download-setup.html) Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
- [Room](https://developer.android.com/training/data-storage/room) The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture
![](https://raw.githubusercontent.com/skydoves/pokedex/main/figure/figure0.png)
