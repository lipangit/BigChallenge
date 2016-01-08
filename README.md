泛型反射父类的全局函数
===================

####这个是一个关于java语法的问题,从工作中的代码抽象出来的,归根结底是取得泛型的Class<T>,同事们都说没办法

####结构很简单

```java
public class BaseMessage {
    public static String parseFromString(String string) {
        System.out.println("BaseMessage ref function " + string);
        return string;
    }
}
```

```java
public class ArticalMessage extends BaseMessage {
}
```

####这里的两个方法,第二个方法通过传参的方式回避了这个问题,第一个方法想直接反射,却报错

```java
public class PbRequest<T extends BaseMessage> {
    public void run_T_StaticFunction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) BaseMessage.class.getClass().getGenericSuperclass()).getActualTypeArguments()[0];//这行报错
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
```

####目的很明确让 run_T_StaticFunction() 能通过运行
```java
public class RunMe {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PbRequest<ArticalMessage> pb = new PbRequest<>();
        //这个不报错
        pb.run_T_StaticFunction(ArticalMessage.class);
        //现在的目的是让这个也不报错
        //pb.run_T_StaticFunction();
    }
}
```