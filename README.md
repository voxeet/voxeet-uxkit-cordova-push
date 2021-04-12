# Voxeet UXKit Cordova Push

## SDK License agreement

Before using the UXKit for Cordova, please review and accept the [Dolby Software License Agreement](SDK_LICENSE.md).

## Release Notes

Read the [release notes](RELEASENOTES.md) for this project.

## Installation

To install this library onto the `cordova-plugin-firebase-messaging` library, follow those steps :

```bash
cordova plugin add cordova-plugin-firebase-messaging
cordova plugin add cordova-plugin-voxeet-push
```

### Installation on iOS

This library is only meant to fix an issue with Firebase on Android which means that nothing needs to be done on iOS.

### Installation for Android

It must be used in conjunction with the push notification mode in the standard Voxeet's Cordova plugin

With the current version, this is the only steps to do. If you have a specific other FCM compatible library and issues using this library and `ordova-plugin-voxeet`, please open a new issue and provide as many information about it.