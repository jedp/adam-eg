package com.jedparsons.adamcli

import com.jedparsons.adamcli.services.RealAdbService
import org.koin.core.context.startKoin
import org.koin.dsl.module
import picocli.CommandLine
import kotlin.system.exitProcess

val CliModule = module {
  single { RealAdbService().client }
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
