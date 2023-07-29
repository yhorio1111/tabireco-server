plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

val kotlinVersion: String by project

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

}
