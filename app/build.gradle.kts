plugins {
    id("com.android.application") version "8.3.0" // Актуальная версия
    id("org.jetbrains.kotlin.android") version "1.9.0" // Актуальная версия
}

android {
    namespace = "com.example.factfrenzy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.factfrenzy"
        minSdk = 24 // Проверьте, что ваш проект совместим с API Level 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Обновлено до Java 17
        targetCompatibility = JavaVersion.VERSION_17 // Обновлено до Java 17
    }
    kotlinOptions {
        jvmTarget = "17" // Обновлено до Java 17
    }
}

dependencies {
    // AndroidX Core
    implementation("androidx.core:core-ktx:1.12.0")

    // ViewModel и LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // ViewModel для управления состоянием
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // LiveData для обновления UI

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Coroutines для асинхронных операций

    // Retrofit (для работы с API)
    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0") // Преобразование JSON в объекты Kotlin

    // Gson (если вы используете его отдельно)
    implementation("com.google.code.gson:gson:2.10.1")

    // Material Design (для UI)
    implementation("com.google.android.material:material:1.12.0")

    // Картинки (если планируете загружать изображения)
    implementation("io.coil-kt:coil-compose:2.4.0") // Coil для загрузки картинок

    // Для работы с сетевыми запросами (необходимо для Retrofit)
    implementation("androidx.appcompat:appcompat:1.7.0")

    // Unit Testing (если нужно)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Kotlinx serialization (если требуется)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}
