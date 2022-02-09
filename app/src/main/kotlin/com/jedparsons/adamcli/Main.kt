package com.jedparsons.adamcli

import picocli.CommandLine
import kotlin.system.exitProcess

class Main {

  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      exitProcess(
        CommandLine(CLI())
          .setAbbreviatedOptionsAllowed(true)
          .execute(*args)
      )
    }
  }
}
