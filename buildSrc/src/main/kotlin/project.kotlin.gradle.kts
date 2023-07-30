import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("project.base")
    kotlin("jvm")
    id("io.gitlab.arturbosch.detekt")
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

//    detekt
    val detektVersion = detekt.toolVersion
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
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

detekt {
    buildUponDefaultConfig = true
    config = files("$rootDir/config/detekt.yml")
}
