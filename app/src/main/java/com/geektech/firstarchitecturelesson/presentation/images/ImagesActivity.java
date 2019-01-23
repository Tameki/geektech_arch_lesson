package com.geektech.firstarchitecturelesson.presentation.images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geektech.firstarchitecturelesson.data.messages.MessagesDataSource;
import com.geektech.firstarchitecturelesson.data.messages.MessagesRepository;
import com.geektech.firstarchitecturelesson.data.messages.local.model.RMessage;

import java.util.Date;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {

    private MessagesDataSource mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = new MessagesRepository();

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, new ImagesFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        RMessage newMessage = new RMessage(
                0,
                "",
                "",
                new Date()
        );

        mRepository.saveMessage(newMessage);

        mRepository.getMessages(new MessagesDataSource.MessageListCallback() {
            @Override
            public void onSuccess(List<RMessage> result) {
                for (RMessage message : result) {
                    Log.d("ololo", message.toString());
                }
            }

            @Override
            public void onFail(String message) {
                Log.e("ololo", message);
            }
        });
    }
}
