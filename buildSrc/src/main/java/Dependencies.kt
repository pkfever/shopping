object ApplicationId {
    const val id = "com.shopping"
}

object Versions {
    const val kotlin = "1.4.21"
    const val appCompat = "1.2.0"
    const val coreKtx = "1.2.0"
    const val constraintLayout = "2.1.1"
    const val material = "1.4.0"
    const val nav = "2.3.5"
    const val koin = "3.1.3"
    const val coroutines = "1.3.5"
    const val retrofitCoroutines = "0.9.2"
    const val retrofitGson = "2.8.1"
    const val gson = "2.8.6"
    const val okHttp = "4.4.0"
    const val retrofit = "2.8.1"
    const val lifecycle = "2.2.0"
    const val coil = "1.4.0"
}

object AndroidLibraries {

    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"

    //    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
//    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}

object Modules {
    const val app = ":app"

    const val navigation = ":navigation"
    const val featureHome = ":features:home"
    const val common = ":common"
}

object Libraries {
    // KOIN
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    // RETROFIT
    const val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    //COIL
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}