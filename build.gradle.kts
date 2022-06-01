plugins {
    listOf(
        Triple("com.android.application", ProjectDepVersions.androidApplication, false),
        Triple("com.android.library", ProjectDepVersions.androidLibrary, false),
        Triple("org.jetbrains.kotlin.android", ProjectDepVersions.jetbrainsKotlinAndroid, false),
    ).forEach { dep ->
        id(dep.first) version dep.second apply dep.third
    }
}
