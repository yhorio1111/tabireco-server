plugins {
    id("tabireco.kotlin")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.withType<Test> {
    useJUnitPlatform()
}