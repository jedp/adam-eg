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
- [shadow](https://imperceptiblethoughts.com/shadow/) minimized fat jar builds

## Running

You can gradle run the app and provide `picocli` arguments with `--args="your args"`.
This is useful for testing incremental changes.
```
$ ./gradlew app:run --args="devices"

> Task :app:run
[main] INFO ADB CLI - Running.
[main] INFO ADB CLI - Retrieving device info.
Got devices: [Device(serial=192.168.86.181:5555, state=DEVICE)]
```

## Distributing

You can also make a stand-alone build using the
[shadow](https://imperceptiblethoughts.com/shadow/) plugin for gradle, which
reduces the size of release by about two thirds.
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

## Troubleshooting

### BlockedThreadChecker

Your app hangs on startup and produces logs like:
```
Feb 15, 2022 23:09:42 PM io.vertx.core.impl.BlockedThreadChecker
WARNING Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 2940 ms, time limit is 2000 ms
```

See [this gist](https://gist.github.com/jedp/249a6eaa9a2dc56a32d7efaf671ace8e)
for diagnosis and three solutions.


## References

- [The Making of a Tiny Kotlin
  App](https://dev.to/autonomousapps/tools-of-the-build-trade-the-making-of-a-tiny-kotlin-app-3eba),
  by Tony Robalik.

