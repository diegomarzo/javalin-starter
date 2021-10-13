plugins {
    kotlin("jvm") version "1.5.21"
    application
}

group = "io.github.diegomarzo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.javalin:javalin:4.1.1")
    implementation("org.slf4j:slf4j-simple:1.7.31")
}

application {
    mainClass.set("io.github.diegomarzo.MainKt")
}

tasks {
    withType<Jar> {
        manifest {
            attributes["Main-Class"] = application.mainClass
        }
        from(configurations.runtimeClasspath.get().map {if (it.isDirectory) it else zipTree(it)})
    }
}
