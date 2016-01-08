package me.nathen.bigchallenge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Nathen on 16/1/5.
 */
public class PbRequest<T extends BaseMessage> {//extends Request<T>

    public void run_T_StaticFunction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) BaseMessage.class.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        java.lang.reflect.Method parseFrom = entityClass.getMethod("parseFromString", String.class);
        String str = (String) parseFrom.invoke(null, "Some String");
        System.out.println(str);
    }

    public void run_T_StaticFunction(Class<T> entityClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Class<T> entityClass = (Class<T>) ((ParameterizedType) BaseMessage.class.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        java.lang.reflect.Method parseFrom = entityClass.getMethod("parseFromString", String.class);
        String str = (String) parseFrom.invoke(null, "Some String");
        System.out.println(str);
    }

}
