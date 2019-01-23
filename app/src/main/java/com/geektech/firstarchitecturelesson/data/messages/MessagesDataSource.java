package com.geektech.firstarchitecturelesson.data.messages;

import com.geektech.core.BaseCallback;
import com.geektech.firstarchitecturelesson.data.messages.local.model.RMessage;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public interface MessagesDataSource {
    void getMessages(MessageListCallback callback);

    @Nullable
    RMessage getMessage(long id);

    void saveMessage(RMessage message);

    interface MessageListCallback extends BaseCallback<List<RMessage>> {

    }
}
