泛型反射父类的全局函数
===================

这个是一个关于java语法的问题,同事们都说没办法

从工作中的代码抽象出来的

```java
public class PbRequest<T extends BaseMessage> {
    public void ref(){
        //在这里把T的全局函数反射出来
    }
}
```
