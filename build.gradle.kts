// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
//    id("androidx.navigation.safeargs")
//    id("androidx.navigation.safeargs.kotlin")
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.8.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

