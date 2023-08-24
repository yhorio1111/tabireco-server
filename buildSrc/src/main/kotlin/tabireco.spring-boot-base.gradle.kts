import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("tabireco.kotlin")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
    dependencies {
        // ULID
        dependency("de.huxhorn.sulky:de.huxhorn.sulky.ulid:8.3.0")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("de.huxhorn.sulky:de.huxhorn.sulky.ulid")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
