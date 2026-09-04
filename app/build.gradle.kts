plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.ankidroidbridge"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ankidroidbridge2"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}

repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("com.github.ankidroid:Anki-Android:api-v1.1.0")
}
