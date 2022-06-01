plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.shubham.composektstemplate"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.shubham.composektstemplate"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        kotlin {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppDepVersions.compose
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    listOf(
        "androidx.core:core-ktx:${AppDepVersions.coreKtx}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${AppDepVersions.lifecycleRuntimeKtx}",
        "androidx.activity:activity-compose:${AppDepVersions.composeActivity}",
        "androidx.compose.ui:ui:${AppDepVersions.compose}",
        "androidx.compose.ui:ui-tooling-preview:${AppDepVersions.compose}",
        "androidx.compose.material3:material3:${AppDepVersions.material3}",
    ).forEach(::implementation)

    listOf(
        "junit:junit:${AppDepVersions.jUnit}",
    ).forEach(::testImplementation)

    listOf(
        "androidx.test.ext:junit:${AppDepVersions.androidXJUnit}",
        "androidx.test.espresso:espresso-core:${AppDepVersions.espressoCore}",
        "androidx.compose.ui:ui-test-junit4:${AppDepVersions.compose}",
    ).forEach(::androidTestImplementation)

    listOf(
        "androidx.compose.ui:ui-tooling:${AppDepVersions.compose}",
        "androidx.compose.ui:ui-test-manifest:${AppDepVersions.compose}",
    ).forEach(::debugImplementation)
}
