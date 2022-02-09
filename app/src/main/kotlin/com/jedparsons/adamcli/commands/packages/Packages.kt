package com.jedparsons.adamcli.commands.packages

import picocli.CommandLine.Command

@Command(
  name = "packages",
  description = ["Information about installed packages"]
)
class Packages : Runnable {
  override fun run() = TODO()
}