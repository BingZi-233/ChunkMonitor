import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.izzel.taboolib.gradle.*
import io.izzel.taboolib.gradle.Basic
import io.izzel.taboolib.gradle.Bukkit
import io.izzel.taboolib.gradle.BukkitFakeOp
import io.izzel.taboolib.gradle.BukkitHook
import io.izzel.taboolib.gradle.BukkitNavigation
import io.izzel.taboolib.gradle.BukkitUI
import io.izzel.taboolib.gradle.BukkitUtil
import io.izzel.taboolib.gradle.BukkitNMS
import io.izzel.taboolib.gradle.BukkitNMSUtil
import io.izzel.taboolib.gradle.BukkitNMSItemTag
import io.izzel.taboolib.gradle.BukkitNMSDataSerializer
import io.izzel.taboolib.gradle.BukkitNMSEntityAI
import io.izzel.taboolib.gradle.I18n
import io.izzel.taboolib.gradle.MinecraftEffect
import io.izzel.taboolib.gradle.MinecraftChat
import io.izzel.taboolib.gradle.CommandHelper
import io.izzel.taboolib.gradle.Metrics


plugins {
    java
    id("io.izzel.taboolib") version "2.0.22"
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
}

taboolib {
    env {
        install(Basic)
        install(Bukkit)
        install(BukkitFakeOp)
        install(BukkitHook)
        install(BukkitNavigation)
        install(BukkitUI)
        install(BukkitUtil)
        install(BukkitNMS)
        install(BukkitNMSUtil)
        install(BukkitNMSItemTag)
        install(BukkitNMSDataSerializer)
        install(BukkitNMSEntityAI)
        install(I18n)
        install(MinecraftEffect)
        install(MinecraftChat)
        install(CommandHelper)
        install(Metrics)
    }
    description {
        name = "ChunkMonitor"
        contributors {
            name("冰子（BingZi-233）")
        }
    }
    version { taboolib = "6.2.3" }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("ink.ptms.core:v12004:12004:mapped")
    compileOnly("ink.ptms.core:v12004:12004:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
