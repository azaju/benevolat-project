plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.flywaydb.flyway") version "10.15.2"
}

group = "com.mat.benevolat"
version = "0.0.1-SNAPSHOT"

//repositories {
//    mavenCentral()
//}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":benevolat-domaine"))
    implementation("org.flywaydb:flyway-core:10.15.2")
    implementation("org.flywaydb:flyway-database-postgresql:10.15.2")
    implementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:postgresql:1.20.0")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    //runtimeOnly("org.postgresql:postgresql:42.7.1")
    implementation("org.postgresql:postgresql:42.7.1")
    implementation("org.mapstruct:mapstruct:1.6.3")
    kapt("org.mapstruct:mapstruct-processor:1.6.3")
}

tasks.bootJar {
    enabled = false
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

flyway {
    url = "jdbc:postgresql://localhost:5434/benevolat"
    user = "benevolat"
    password = "benevolat"
    locations = arrayOf("classpath:db/migration")
}
