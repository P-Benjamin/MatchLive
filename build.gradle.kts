plugins {
	war
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.24"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	//Doc
	developmentOnly("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.+")

//validator
	implementation("org.springframework.boot:spring-boot-starter-validation")

	//JPA
	//Permet à JAVA de se connecter à une base SQL
	runtimeOnly("com.mysql:mysql-connector-j")

//JPA Framework Java qui génère du SQL
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

//Pour utiliser avec Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//Spring security
	//implementation("org.springframework.boot:spring-boot-starter-security")


	//implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

	//WebSocket
	implementation("org.springframework.boot:spring-boot-starter-websocket")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
