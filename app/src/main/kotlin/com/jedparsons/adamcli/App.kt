package com.jedparsons.problems

import com.malinskiy.adam.AndroidDebugBridgeClientFactory
import com.malinskiy.adam.interactor.StartAdbInteractor
import com.malinskiy.adam.request.device.Device
import com.malinskiy.adam.request.device.ListDevicesRequest
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

class App {

  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      runBlocking {
        StartAdbInteractor().execute()
        val adb = AndroidDebugBridgeClientFactory().build()

        val devices: List<Device> = adb.execute(ListDevicesRequest())
        println("Got devices: $devices")
      }

      exitProcess(0)
    }
  }
}
