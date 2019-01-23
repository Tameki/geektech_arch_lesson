package com.geektech.firstarchitecturelesson.data.messages;

import com.geektech.core.realm.RealmDataSource;
import com.geektech.firstarchitecturelesson.data.messages.local.model.RMessage;

import javax.annotation.Nullable;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public class MessagesRepository extends RealmDataSource
        implements MessagesDataSource {

    //region Private

    private void addOrUpdateMessage(RMessage message) {
        if (message.getId() == 0) {
            message.setId(getNextId(RMessage.class));
        }

        executeTransaction( realm -> {
            realm.copyToRealmOrUpdate(message);

            RMessage managed = realm.where(RMessage.class)
                    .equalTo("id", message.getId()).findFirst();
            managed.setContent("New content");

            RMessage unmanaged = realm.copyFromRealm(managed);
            managed.deleteFromRealm();
            unmanaged.setContent("---------------");
        });
    }

    //endregion

    //region Contract

    @Override
    public void getMessages(MessageListCallback callback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            RealmResults<RMessage> messages = realm.where(RMessage.class)
                    .findAll();

            callback.onSuccess(realm.copyFromRealm(messages));
        } catch (Exception e) {
            callback.onFail(e.getMessage());
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Nullable
    @Override
    public RMessage getMessage(long id) {
        Realm realm = null;
        RMessage message = null;

        try {
            realm = getRealmInstance();

            RMessage rMessage = realm.where(RMessage.class)
                    .equalTo("id", id)
                    .findFirst();

            if (rMessage != null)
                message = realm.copyFromRealm(rMessage);
        } catch (Exception e) {
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

        return message;
    }

    @Override
    public void saveMessage(RMessage message) {
        addOrUpdateMessage(message);
    }

    //endregion

}
