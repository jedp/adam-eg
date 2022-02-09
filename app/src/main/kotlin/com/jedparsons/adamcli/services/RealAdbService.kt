package com.jedparsons.adamcli.services

import com.malinskiy.adam.AndroidDebugBridgeClient
import com.malinskiy.adam.AndroidDebugBridgeClientFactory
import com.malinskiy.adam.interactor.StartAdbInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class RealAdbService : AdbService {

  override lateinit var client: AndroidDebugBridgeClient

  init {
    runBlocking {
      StartAdbInteractor().execute()

      client = AndroidDebugBridgeClientFactory().apply {
        coroutineContext = Dispatchers.IO
      }.build()
    }
  }
}
