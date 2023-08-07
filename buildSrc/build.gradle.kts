plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

val kotlinVersion: String by project
val detektPluginVersion: String by project
val springBootGradlePluginVersion: String by project
val dependencyManagementPluginVersion: String by project

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
	implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")

	implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektPluginVersion")

//	spring
	implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootGradlePluginVersion")
	implementation("io.spring.gradle:dependency-management-plugin:$dependencyManagementPluginVersion")
}
