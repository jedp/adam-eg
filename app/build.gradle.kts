import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
  val kotlinVersion = "1.6.0"
  val shadowVersion = "7.1.2"

  kotlin("jvm") version kotlinVersion
  kotlin("kapt") version kotlinVersion
  id("com.github.johnrengelman.shadow") version shadowVersion

  // Apply the application plugin to add support for building a CLI application in Java.
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
  implementation("com.google.guava:guava:30.1.1-jre")

  implementation("com.malinskiy.adam:adam:0.4.3")
  implementation("info.picocli:picocli:4.6.2")
  implementation("io.insert-koin:koin-core:3.1.5")
  implementation("io.insert-koin:koin-test:3.1.5")

  // Fix SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder". etc.
  // Whether or not you use it, adding this to the classpath stops the warnings.
  implementation("org.slf4j:slf4j-simple:1.7.26")

  // Fix WARNING: Can not find io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider
  runtimeOnly("io.netty:netty-all:4.1.70.Final")
}

testing {
  suites {
    // Configure the built-in test suite
    val test by getting(JvmTestSuite::class) {
      // Use Kotlin Test test framework
      useKotlinTest()
    }
  }
}

application {
  mainClass.set("com.jedparsons.adamcli.Main")
}

// Configure Shadow to output with normal jar file name:
tasks.named<ShadowJar>("shadowJar").configure {
  // Note: ConfigureShadowRelocation results in an UnsatisfiedLinkError for netty's dns resolver.
  // This can happen if JNI bindings expect certain names or namespaces which relocation clobbers.

  from(
    sourceSets.main.get().output,
    project.configurations.runtimeClasspath
  )

  exclude(
    "**/*.kotlin_metadata",
    "**/*.kotlin_module",
    "META-INF/maven/**"
  )

}
