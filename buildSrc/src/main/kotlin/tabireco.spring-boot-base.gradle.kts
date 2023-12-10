import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("tabireco.kotlin")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

//configurations.matching { it.name != "detekt" }.all {
//    resolutionStrategy.eachDependency {
//        if (requested.group == "org.jetbrains.kotlin") {
//            useVersion("1.8.21")
//        }
//    }
//}

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
