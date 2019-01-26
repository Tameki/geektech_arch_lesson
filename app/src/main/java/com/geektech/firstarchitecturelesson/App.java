package com.geektech.firstarchitecturelesson;

import android.app.Application;

import com.geektech.firstarchitecturelesson.data.messages.local.model.RMessage;
import com.geektech.firstarchitecturelesson.data.messages.model.RComment;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
//                .migration(new RealmMigration() {
//                    @Override
//                    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//                        realm.getSchema()
//                                .get(RMessage.class.getSimpleName())
////                                .addField()
//                                .addRealmListField("comments", RComment.class);
//                    }
//                })
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);
    }

}
