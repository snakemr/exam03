import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.ktor)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.icons.core)
            implementation(libs.sqldelight.sqliteDriver)
            implementation(libs.sqldelight.coroutinesExtensions)
            implementation(libs.ktor.serverCore)
            implementation(libs.ktor.serverNetty)
            implementation(libs.ktor.serverLogging)
            implementation(libs.ktor.serverContentNegotiation)
            implementation(libs.ktor.serializationGson)
            implementation(libs.ktor.clientCio)
            implementation(libs.ktor.clientContentNegotiation)
            implementation(libs.slf4j.simple)
            implementation(files("lib/tests.jar"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}


compose.desktop {
    application {
        mainClass = "ru.lrmk.exam03.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ru.lrmk.exam03"
            packageVersion = "1.0.0"
        }
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName = "ru.lrmk.exam03.database"
            srcDirs.setFrom("src/jvmMain/sqldelight")
        }
    }
}
