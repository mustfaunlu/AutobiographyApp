## Autobiography App
I have developed an Android application called Autobiography App and I would like to briefly describe its features.

This application includes an "About Me" section where I provide personal information about myself, my interests, skills, and goals. The "Blogs" page displays the titles and descriptions of my blog posts on Medium, which users can read by clicking on them. The "Projects" page showcases my projects' images, descriptions, technologies used, and GitHub links.

Finally, the last page of the application provides links to my social media accounts, enabling users to connect with me on social media.

Autobiography App was developed using the Kotlin programming language and built using Android Studio. My biographical app  uses offline-first structure, MVVM and repository pattern, along with popular libraries like Retrofit, Glide, and Room. I also leverage technologies such as LiveData, Flow, ViewBinding, and Databinding. The source code for the project is available on GitHub, allowing any developer to run and modify the project on their own computer. 

## Screeshots
<p align="center">
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/8fb99841-6176-4009-b0f9-1506c4f769fe" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/592da785-7292-4e31-a00c-b42c8408c611" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/7df45920-cb29-4677-bb35-8dc7e031b811" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/fe4a69c9-23e8-41c7-b35f-0223dbccaf82" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/c0223811-76f4-44ed-b236-64d0758774a8" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/e0a2af32-80b0-4cab-a406-2e8f7f757741" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/7df45920-cb29-4677-bb35-8dc7e031b811" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/32ba174f-016e-4fde-ba61-f9083c660617" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/2a0c8a29-57a2-4ad6-a6c1-b4c4a8a0317c" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/6499673f-2cd5-405d-84ff-45d3b3bb5f72" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/7df45920-cb29-4677-bb35-8dc7e031b811" width="15%"/>
<img src="https://github.com/mustfaunlu/AutobiographyApp/assets/38860392/eb142f6b-493d-4495-bbec-d9d864bf2920" width="15%"/>
</p>

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


## App video Portrait (Samsung Galaxy Mega 6.3 API 30)
<img width="100" height="100" src="https://user-images.githubusercontent.com/38860392/235319884-fd842419-9614-4caf-b8ae-8daca1d9f29a.mp4" />
