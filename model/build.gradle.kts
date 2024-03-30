plugins {
	java
	id("io.franzbecker.gradle-lombok") version "5.0.0"
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
	implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
}


tasks.withType<Test> {
	useJUnitPlatform()
}
