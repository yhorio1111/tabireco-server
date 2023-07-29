import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("project.base")
    kotlin("jvm")
}

val jvmVersion = "17"

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec)
                .languageVersion.set(JavaLanguageVersion.of(jvmVersion))
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = jvmVersion
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
