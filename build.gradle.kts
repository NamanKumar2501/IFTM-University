buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")

    }
}
// Top-level build file where you can add configuration options common to all sub-projects/module
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
}