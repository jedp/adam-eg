package com.jedparsons.adamcli.commands.devices

import com.malinskiy.adam.AndroidDebugBridgeClient
import com.malinskiy.adam.request.device.Device
import com.malinskiy.adam.request.device.ListDevicesRequest
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.slf4j.Logger
import picocli.CommandLine.Command

@Command(
  name = "devices",
  description = ["Summarize attached devices"]
)
class Devices : Runnable, KoinComponent {

  private val adb: AndroidDebugBridgeClient = get()
  private val logger: Logger = get()

  override fun run() {
    logger.info("Retrieving device info.")
    runBlocking {
      val devices: List<Device> = adb.execute(ListDevicesRequest())
      println("Got devices: $devices")
    }
  }
}
