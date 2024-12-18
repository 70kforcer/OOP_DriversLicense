plugins {
    id("java")
    id("application")
}

application {
    mainClass.set("com.frames.LandingFrame")
}

group = "org.touchmenots"
version = "0.1alpha"

tasks.withType<JavaExec> {
    systemProperty("databaseURL", project.findProperty("databaseURL") ?: "URL not read")
    systemProperty("databaseUSERNAME", project.findProperty("databaseUSERNAME") ?: "Username not read")
    systemProperty("databasePASSWORD", project.findProperty("databasePASSWORD") ?: "Password not read")
}

repositories {
    mavenCentral()
    flatDir {
        dirs("lib")
    }
}

dependencies {
    implementation("org.jdesktop:beansbinding:1.2.1")
    implementation(files("lib/swing-datetime-picker-1.4.1.jar")) // >> Date & Time Picker
    implementation("com.miglayout:miglayout:3.7.4")
    implementation("com.formdev:flatlaf-intellij-themes:3.5.4")         // >> Additional UI theme
    implementation("com.formdev:flatlaf:3.5.4")                         // >> UI theme
    implementation("com.formdev:flatlaf-extras:3.5.4")                  // << Add FlatLaf Extras to resolve missing FlatSVGIcon
    implementation("com.intellij:forms_rt:7.0.3")                       // >> Imports form data to Gradle
    implementation("mysql:mysql-connector-java:8.0.30")                 // >> Database linkage
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "com.frames.LandingFrame"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}

/*tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest.attributes["Main-Class"] = application.mainClass.get()
    from(sourceSets["main"].output)
    dependsOn(configurations["runtimeClasspath"])
    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map(::zipTree))
}*/