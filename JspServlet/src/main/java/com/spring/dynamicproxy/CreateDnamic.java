/*
package com.spring.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

*/
/**
 * 帮我们动态的(JVM编译期间)创建代理对象
 *//*

public class CreateDnamic implements InvocationHandler {
    //目标对象
    private Object targetObject;
    */
/**
     * 给目标对象赋值(构造方法)
     *//*

    public CreateDnamic(Object obj) {
        this.targetObject = obj;
    }

    */
/**
     * 通过调用该方法来创建代理对象
     * @return
     * ClassLoader loader:得知目标对象的类加载器
     * Class<?>[] interfaces:得知目标对象所实现的方法
     * InvocationHandler h:实现了InvocationHandler接口的那个类的实例(也就是引用)
     *//*

    public Object newDynamicObjectInstance() {
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),
                this);
    }

    */
/**
     * Invoke方法是自动调用的(系统自动调用，系统在创建动态代理对象的时候第一个调用的方法)
     * @param proxy  ：目标对象
     * @param method ：目标对象中的方法(荚膜)
     * @param args  ：目标对象方法中的参数
     * @return
     *//*

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object obj = null;
        try {
            this.securityCheck();
            obj = method.invoke(this.targetObject,args);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public void securityCheck(){
        System.out.println("----------securityCheck------");
    }

}
*/


