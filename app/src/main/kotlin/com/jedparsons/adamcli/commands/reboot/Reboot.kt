package com.jedparsons.adamcli.commands.reboot

import com.malinskiy.adam.AndroidDebugBridgeClient
import com.malinskiy.adam.exception.RequestRejectedException
import com.malinskiy.adam.request.device.Device
import com.malinskiy.adam.request.device.ListDevicesRequest
import com.malinskiy.adam.request.misc.RebootRequest
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.slf4j.Logger
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Command(
  name = "reboot",
  description = ["Reboot an attached device."]
)
class Reboot : Runnable, KoinComponent {

  private val adb: AndroidDebugBridgeClient = get()
  private val logger: Logger = get()

  @Parameters(
    arity = "0..*",
    paramLabel = "serial",
    description = ["Optional serial IDs of devices to reboot."]
  )
  private val serial: Array<String>? = null

  override fun run() {
    runBlocking {
      serial
        ?.forEach {
          try {
            reboot(it)
          } catch (notFound: RequestRejectedException) {
            logger.error("Device not found: $it")
          }
        }
        ?: let {
          val devices: List<Device> = adb.execute(ListDevicesRequest())
          when (devices.size) {
            0 -> logger.error("No attached devices to reboot.")
            1 -> reboot(devices[0].serial)
            else -> logger.error("More than one attached device.")
          }
        }
    }
  }

  private suspend fun reboot(serial: String) {
    logger.info("Requesting reboot for $serial ...")
    adb.execute(
      request = RebootRequest(),
      serial = serial
    )
  }
}
