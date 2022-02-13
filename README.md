# adam-eg

Template for an app based on Anton Malinskiy's splendid
[Android Bridge helper, adam](https://github.com/Malinskiy/adam).

Planting this demo here to show how to resolve some of the quirky warnings that
one might see when using adam. If you get any additional errors, you may have
broken some dependency or other with proguard or something.

App includes enough to get you up and running:

- [adam](https://github.com/Malinskiy/adam) android debug bridge client
- [picocli](https://picocli.info/) command-line interface
- [koin](https://insert-koin.io/) dependency injection

You can gradle run the app and provide `picocli` arguments with `--args="your args"`:
```
$ ./gradlew app:run --args="devices"

> Task :app:run
[main] INFO ADB CLI - Running.
[main] INFO ADB CLI - Retrieving device info.
Got devices: [Device(serial=192.168.86.181:5555, state=DEVICE)]
```

Or you can use gradle to make a binary release of a stand-alone script. Here,
the `installShadowDist` task creates a single, fat jar:
```
$ ./gradlew :app:installShadowDist
$ app/build/install/app-shadow/bin/app -h
[main] INFO ADB CLI - Running.
Usage: adam-cli [-hV] [COMMAND]
Working example of adam adb client.
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
  devices   Summarize attached devices
  packages  Information about installed packages
  reboot    Reboot an attached device.
```

For information about packaging the script in to a single jar and minimizing it
size, see [The Making of a Tiny Kotlin
App](https://dev.to/autonomousapps/tools-of-the-build-trade-the-making-of-a-tiny-kotlin-app-3eba)
by Tony Robalik.

