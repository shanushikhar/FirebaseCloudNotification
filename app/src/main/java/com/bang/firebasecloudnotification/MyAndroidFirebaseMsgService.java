package com.bang.firebasecloudnotification;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

// it was not importing because we have not add a
// a classpath into the app’s build.gradle ...
// implementation 'com.google.android.gms:play-services:9.2.0' -> was missing


//class file for com.google.android.gms.internal.zzbgl not found then i add
//  implementation 'com.google.firebase:firebase-messaging:17.3.3'

// to get notification simply go to Tools -> Firebase and do the linking process
//  do not go to manually process like download google-services.json and all



public class MyAndroidFirebaseMsgService extends FirebaseMessagingService {
    private static final String TAG = "MyAndroidFCMService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //Log data to Log Cat
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        //create notification
        createNotification(remoteMessage.getNotification().getBody());
    }

    private void createNotification( String messageBody) {
        Intent intent = new Intent( this , ResultActivity. class );
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent resultIntent = PendingIntent.getActivity( this , 0, intent,
                PendingIntent.FLAG_ONE_SHOT);




        //Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder( this)
                // if R does not found then go to google-service.json and check thr project name
                //.setSmallIcon(R.mipmap.ic_launcher)// gives a sign of square shape
                //.setSmallIcon(android.R.drawable.sym_def_app_icon)// gives a sign of android

                .setContentTitle("Kreative digital solution")
                .setContentText(messageBody)
                .setAutoCancel( true )
                //.setSound(notificationSoundURI)
                .setContentIntent(resultIntent);
        //implementation 'com.google.android.gms:play-services:12.0.1'

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,mNotificationBuilder.build() );
    }
}
