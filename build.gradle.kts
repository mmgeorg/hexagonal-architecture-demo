plugins {
    java
    idea
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.demo"
version = "0.0.1-SNAPSHOT"

subprojects {
    apply(plugin = "java")
    apply(plugin = "idea")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")


    tasks.withType<JavaCompile> {}
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    idea {
        module {
            isDownloadSources = true
            outputDir = file("${getLayout().buildDirectory}/classes/java/main")
            testOutputDir = file("${getLayout().buildDirectory}/classes/java/test")
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    repositories {
        mavenCentral()
    }


    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
        testCompileOnly {
            extendsFrom(configurations.testAnnotationProcessor.get())
        }
    }


    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        compileOnly("org.projectlombok:lombok")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        implementation ("io.vavr:vavr:0.10.4")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testCompileOnly("org.projectlombok:lombok")
        testAnnotationProcessor("org.projectlombok:lombok")
        testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")


    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL // enables IntelliJ IDEA Gradle API/DSL documentation
}
