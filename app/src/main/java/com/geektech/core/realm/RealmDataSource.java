package com.geektech.core.realm;

import com.geektech.firstarchitecturelesson.data.messages.local.model.RMessage;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public abstract class RealmDataSource {

    //One instance for every thread
    protected Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    protected long getNextId(Class c) {
        Realm realm = null;

        ArrayList<RMessage> message = new ArrayList<>();

        try {
            realm = getRealmInstance();

            String primaryKeyField = realm.getSchema()
                    .get(c.getSimpleName())
                    .getPrimaryKey();

            Number maxId = realm.where(c).max(primaryKeyField);
            if (maxId == null)
                return 1;

            return maxId.intValue() + 1;
        } catch (Exception e) {
            return -1;
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }


    protected void executeTransaction(Realm.Transaction transaction) {
        Realm realm = null;

        try {
            realm = getRealmInstance();
            realm.executeTransaction(transaction);
        } catch (Exception e) {
            //Log
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

}
