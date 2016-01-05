package me.nathen.bigchallenge;

/**
 * Created by Nathen on 16/1/5.
 */
public class BaseMessage {
    String params;

    public BaseMessage(String string) {
        this.params = string;
    }

    public static BaseMessage parseFromString(String string) {
        System.out.println("BaseMessage ref function " + string);
        return new BaseMessage(string);
    }
}
