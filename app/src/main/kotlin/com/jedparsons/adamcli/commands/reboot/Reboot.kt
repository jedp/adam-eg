package com.jedparsons.adamcli.commands.reboot

import picocli.CommandLine.Command

@Command(
  name = "reboot",
  description = ["Reboot an attached device."]
)
class Reboot : Runnable {
  override fun run() = TODO()
}
