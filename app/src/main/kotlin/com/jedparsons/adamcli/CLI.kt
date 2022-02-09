package com.jedparsons.adamcli

import com.jedparsons.adamcli.commands.devices.Devices
import com.jedparsons.adamcli.commands.packages.Packages
import com.jedparsons.adamcli.commands.reboot.Reboot
import picocli.CommandLine.Command

@Command(
  name = "adam-cli",
  mixinStandardHelpOptions = true,
  subcommands = [
    Devices::class,
    Packages::class,
    Reboot::class
  ],
  version = ["adam-cli script 0.0.0"],
  description = ["Working example of adam adb client."]
)
class CLI
