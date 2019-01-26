package com.geektech.core.realm;

import android.util.Log;

import com.geektech.firstarchitecturelesson.data.messages.local.model.RMessage;

import java.util.ArrayList;
import java.util.HashMap;

import io.realm.Realm;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public abstract class RealmDataSource {

    private HashMap<Class, Long> mIds = new HashMap<>();

    //One instance for every thread
    protected Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    protected long getNextId(Class c) {
        Realm realm = null;

        Long currentId = mIds.get(c);

        if (currentId == null) {
            try {
                realm = getRealmInstance();

                String primaryKeyField = realm.getSchema()
                        .get(c.getSimpleName())
                        .getPrimaryKey();

                Number maxId = realm.where(c).max(primaryKeyField);

                if (maxId == null) {
                    maxId = 1;
                } else {
                    maxId = maxId.longValue() + 1;
                }

                mIds.put(c, maxId.longValue());

                return maxId.longValue();
            } catch (Exception e) {
                return -1;
            } finally {
                if (realm != null) {
                    realm.close();
                }
            }
        } else {
            currentId ++;
            mIds.put(c, currentId);
            return currentId;
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
