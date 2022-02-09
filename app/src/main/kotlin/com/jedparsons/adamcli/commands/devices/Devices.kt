package com.jedparsons.adamcli.commands.devices

import com.malinskiy.adam.AndroidDebugBridgeClientFactory
import com.malinskiy.adam.interactor.StartAdbInteractor
import com.malinskiy.adam.request.device.Device
import com.malinskiy.adam.request.device.ListDevicesRequest
import kotlinx.coroutines.runBlocking
import picocli.CommandLine.Command

@Command(
  name = "devices",
  description = ["Summarize attached devices"]
)
class Devices : Runnable {
  override fun run() {
    runBlocking {
      StartAdbInteractor().execute()
      val adb = AndroidDebugBridgeClientFactory().build()

      val devices: List<Device> = adb.execute(ListDevicesRequest())
      println("Got devices: $devices")
    }
  }
}
