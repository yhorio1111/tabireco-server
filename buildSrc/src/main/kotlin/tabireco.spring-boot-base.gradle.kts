import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("tabireco.kotlin")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
