import java.util.Date
import java.text.SimpleDateFormat

buildscript {
    repositories {
        maven(url = "https://files.minecraftforge.net/maven")
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:3.+")
    }
}

apply(plugin = "net.minecraftforge.gradle")

plugins {
    kotlin("jvm") version "1.3.71"
}

version = "0.0.1"
group = "dev.toliner.mystechrious"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/toliner/Korgelin")
}

dependencies {
    "minecraft"("net.minecraftforge:forge:1.15.2-31.2.0")
    implementation("net.toliner.korgelin:korgelin-1.15:1.1.3-1.3.71")
}

configure<net.minecraftforge.gradle.common.util.MinecraftExtension> {
    mappings("snapshot", "20200727-1.15.1")
    runs {
        create("client") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            mods {
                create("Mystechrious") {
                    source(sourceSets.main.get())
                }
            }
        }
        create("server") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            mods {
                create("Mystechrious") {
                    source(sourceSets.main.get())
                }
            }
        }
        create("data") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            args("--mod", "industrial", "--all", "--output", file("src/generated/resources/"))

            mods {
                create("Mystechrious") {
                    source(sourceSets.main.get())
                }
            }
        }
    }
}

tasks {
    getByName<Wrapper>("wrapper") {
        gradleVersion = "5.6.4"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }

    jar {
        finalizedBy("reobfJar")
        manifest {
            attributes(
                mapOf(
                    "Specification-Title" to "mystechrious",
                    "Specification-Vendor" to "tolinerとゆかいな仲間たち",
                    "Specification-Version" to "1", // We are version 1 of ourselves
                    "Implementation-Title" to project.name,
                    "Implementation-Version" to archiveVersion.get(),
                    "Implementation-Vendor" to "tolinerとﾂｲｯﾀｰ友達",
                    "Implementation-Timestamp" to SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
                )
            )
        }
    }
}