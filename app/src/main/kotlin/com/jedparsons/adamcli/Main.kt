package com.jedparsons.adamcli

import com.jedparsons.adamcli.services.RealAdbService
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import picocli.CommandLine
import kotlin.system.exitProcess

val CliModule = module {
  single { RealAdbService().client }
  single<Logger> { LoggerFactory.getLogger("ADB CLI") }
}

class Main {

  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      startKoin {
        modules(CliModule)
      }

      exitProcess(
        CommandLine(CLI())
          .setAbbreviatedOptionsAllowed(true)
          .execute(*args)
      )
    }
  }
}
