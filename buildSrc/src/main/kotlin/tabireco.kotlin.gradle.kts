import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("tabireco.base")
    kotlin("jvm")
    kotlin("kapt")
//    id("io.gitlab.arturbosch.detekt")
}

val jvmVersion = "17"

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(jvmVersion))
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

//    detekt
//    val detektVersion = detekt.toolVersion
//    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = jvmVersion
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// detekt {
//    buildUponDefaultConfig = true
//    parallel = true
//    config = files("$rootDir/config/detekt.yml")
// }
