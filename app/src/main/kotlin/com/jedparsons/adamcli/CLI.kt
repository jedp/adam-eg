package com.jedparsons.adamcli

import com.jedparsons.adamcli.commands.devices.Devices
import com.jedparsons.adamcli.commands.packages.Packages
import com.jedparsons.adamcli.commands.reboot.Reboot
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.slf4j.Logger
import picocli.CommandLine.Command
import picocli.CommandLine.HelpCommand

@Command(
  name = "adam-cli",
  mixinStandardHelpOptions = true,
  subcommands = [
    HelpCommand::class,
    Devices::class,
    Packages::class,
    Reboot::class
  ],
  version = ["adam-cli script 0.0.0"],
  description = ["Working example of adam adb client."]
)
class CLI : KoinComponent {

  private val logger: Logger = get()

  init {
    logger.info("Running.")
  }
}
