package com.voxeet.uxkit.cordova.push;

import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.voxeet.sdk.push.center.RemoteMessageFactory;
import com.voxeet.sdk.services.notification.INotificationTokenProvider;
import com.voxeet.sdk.services.notification.NotificationTokenHolderFactory;

import by.chemerisuk.cordova.firebase.FirebaseMessagingPluginService;

/**
 * Simple class aiming at overriding the cordova-plugin-firebase-messaging's FirebaseMessagingPluginService
 * for compatibility issues
 */
public class CordovaVoxeetPushMessagingService extends FirebaseMessagingPluginService {

    private final static String TAG = CordovaVoxeetPushMessagingService.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "onMessageReceived called, will try to forward to Voxeet's then after to the FirebaseMessagingPluginService's");

        INotificationTokenProvider provider = NotificationTokenHolderFactory.provider;
        boolean managed = false;
        if (null != provider) {
            provider.log("New notification with body " + remoteMessage.getData());

            managed = RemoteMessageFactory.manageRemoteMessage(getApplicationContext(), remoteMessage.getData());

            provider.log("notification managed := " + managed);
        }

        if (!managed) {
            super.onMessageReceived(remoteMessage);
        }
    }
}
