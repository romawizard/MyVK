package ru.roma.vk.post;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Type;

import ru.roma.vk.holders.Keys;

/**
 * Created by Ilan on 08.11.2017.
 */

public abstract class Attachment {

    private final static String PHOTO = "photo";
    private final static String VIDEO = "video";
    private final static String AUDIO = "audio";

    private static Attachment createObject(JSONObject jsonObject, Type type) {

        Gson gson = new Gson();

        Log.d(Keys.LOG,"before");
        Attachment a = gson.fromJson(jsonObject.toString(), type);
        Log.d(Keys.LOG,"OBJECT = " + a.toString());
        return gson.fromJson(jsonObject.toString(), type);
    }

    public static final Attachment getInstance(String type, JSONObject jsonObject) {

        switch (type) {
            case PHOTO:
                return createObject(jsonObject, Photo.class);
            case VIDEO :
                return createObject(jsonObject, Video.class);
            case  AUDIO:
                return createObject(jsonObject, Audio.class);
            default:
                return createObject(jsonObject,Empty.class);
        }
    }

    public abstract View draw();

    public abstract void doAction();

}
