package me.nathen.bigchallenge;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Nathen on 16/1/5.
 */
public class RunMe {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        PbRequest<ArticalMessage> pb = new PbRequest<>();

        //这个不报错
        pb.run_T_StaticFunction(ArticalMessage.class);

        //现在的目的是让这个也不报错
//        pb.run_T_StaticFunction();

    }

}
