plugins {
  val kotlinVersion = "1.6.0"

  kotlin("jvm") version kotlinVersion
  kotlin("kapt") version kotlinVersion

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

  // Fix SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder". etc.
  implementation("org.slf4j:slf4j-simple:1.7.26")
  // Fix WARNING: Can not find io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider
  implementation("io.netty:netty-all:4.1.70.Final")
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
  mainClass.set("com.jedparsons.problems.App")
}
