plugins {
	java
	id("io.franzbecker.gradle-lombok") version "5.0.0"
	id("org.springframework.boot") version "3.2.2"
}

group = "ru.sber.demo"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

lombok {
	version = "1.18.30"
}

dependencies {
	implementation(project(":model"))

	implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
