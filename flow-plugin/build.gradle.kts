plugins {
    id("education.cccp.build.gradle-plugin") version "0.0.2"
    id("education.cccp.build.publishing") version "0.0.2"
    id("education.cccp.build.functional-test") version "0.0.2"
    id("education.cccp.build.cucumber") version "0.0.2"
}

group = "education.cccp"
version = "0.0.1"

dependencies {
    implementation(platform("education.cccp:workspace-bom:0.0.4"))

    implementation(kotlin("stdlib-jdk8"))

    // N4 — orchestration merge/close/CI (compileOnly, evite coupling)
    // TODO FLW-2 : compileOnly("education.cccp:ticket-plugin:0.0.1")
    // TODO FLW-2 : compileOnly("education.cccp:review-plugin:0.0.1")
    // (ticket-gradle et review-gradle non encore publiés — bootstrap N4)

    // Tests unitaires
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.slf4j:slf4j-api:2.0.13")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.5.6")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.12.0")

    // Cucumber BDD
    testImplementation(platform("io.cucumber:cucumber-bom:7.18.1"))
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("io.cucumber:cucumber-kotlin")
}

gradlePlugin {
    website.set("https://github.com/cccp-education/flow-gradle/")
    vcsUrl.set("https://github.com/cccp-education/flow-gradle.git")

    plugins {
        create("flow") {
            id = "education.cccp.flow"
            implementationClass = "flow.FlowPlugin"
            displayName = "Flow Plugin"
            description = "Gradle plugin for merge/close/CI orchestration (N4)."
            tags.set(listOf("merge", "ci", "orchestration", "ticket", "review"))
        }
    }
}

publishingConventions {
    publicationType = "PLUGIN"
}

publishing {
    repositories {
        mavenCentral()
    }
}