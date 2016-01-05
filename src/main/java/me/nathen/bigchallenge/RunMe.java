package me.nathen.bigchallenge;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Nathen on 16/1/5.
 */
public class RunMe {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        PbRequest<PBFeedArticale> pb = new PbRequest<>();
//        pb.run_T_StaticFunction(PBFeedArticale.class);
        pb.run_T_StaticFunction();

    }
    
}
