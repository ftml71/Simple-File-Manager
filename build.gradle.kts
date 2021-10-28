// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath (ClassPaths.gradleClasspath)
        classpath (ClassPaths.kotlinGradlePluginClasspath)

    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io" )}
    }
}


tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
