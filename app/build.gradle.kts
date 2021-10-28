plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}
//val keystorePropertiesFile = rootProject . file ("keystore.properties")
//val keystoreProperties = Properties()
//if (keystorePropertiesFile.exists()) {
//    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
//}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId = Config.applicatiınId
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Release.versionCode
        versionName = Release.versionName
        multiDexEnabled = true
        setProperty("archivesBaseName", "file-manager")
        vectorDrawables.useSupportLibrary = true
    }

//    signingConfigs {
//        if (keystorePropertiesFile.exists()) {
//            release {
//                keyAlias keystoreProperties ["keyAlias"]
//                keyPassword keystoreProperties ["keyPassword"]
//                storeFile file (keystoreProperties["storeFile"])
//                storePassword keystoreProperties ["storePassword"]
//            }
//        }
//    }

    buildTypes {

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

//            proguardFiles getDefaultProguardFile ("proguard-android.txt"), "proguard-rules.pro"
//            if (keystorePropertiesFile.exists()) {
//                signingConfig signingConfigs . release
//            }
        }
    }

    sourceSets.getByName("main") {
        java.srcDirs("src/main/kotlin")

    }
    lintOptions {
        isCheckReleaseBuilds = false
        isAbortOnError = false
    }
}

dependencies {
    implementation("com.github.SimpleMobileTools:Simple-Commons:5079455be9")
    implementation("com.github.Stericson:RootTools:df729dcb13")
    implementation("com.github.Stericson:RootShell:1.6")
    implementation("com.alexvasilkov:gesture-views:2.5.2")
    implementation("androidx.documentfile:documentfile:1.0.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
}
