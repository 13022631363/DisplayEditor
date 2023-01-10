


plugins {
    id("java")
}

group = "rose.loki_face2wall"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()


}
repositories {
    maven("https://repo.purpurmc.org/snapshots")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    compileOnly(fileTree(baseDir = "src/libs"))
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.19.2-R0.1-SNAPSHOT")


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}