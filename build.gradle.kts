plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

tasks.withType<JavaExec> {
    systemProperty("databaseURL", project.findProperty("databaseURL") ?: "URL not read")
    systemProperty("databaseUSERNAME", project.findProperty("databaseUSERNAME") ?: "Username not read")
    systemProperty("databasePASSWORD", project.findProperty("databasePASSWORD") ?: "Password not read")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.33")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}