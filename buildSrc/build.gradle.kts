plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

val kotlinVersion: String by project
val detektPluginVersion: String by project
val dependencyManagementPluginVersion: String by project

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
	implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektPluginVersion")

//	spring
	implementation("io.spring.gradle:dependency-management-plugin:$dependencyManagementPluginVersion")
}
