package com.jedparsons.adamcli.services

import com.malinskiy.adam.AndroidDebugBridgeClient

interface AdbService {

  val client: AndroidDebugBridgeClient
}
