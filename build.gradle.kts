plugins {
    id("java")
}

group = "cn.gionrose.displayEditor"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}
repositories {
    maven("https://repo.purpurmc.org/snapshots")
}
tasks.withType <JavaCompile>
{
    options.encoding = "UTF-8"
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    compileOnly(fileTree(baseDir = "src/libs"))
    implementation(fileTree(baseDir = "src/testlibs"))
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.19.2-R0.1-SNAPSHOT")


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}