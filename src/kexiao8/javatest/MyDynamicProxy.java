package kexiao8.javatest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



//cglib
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Created by tommyxiao on 3/1/20 12:51
 * --静态代理与jdk动态代理的区别主要在---
 * 1.静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 2.动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
 * 特点：
 * 动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
 *
 *
 * ----cglib特点----
 * 1.JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
 * 如果想代理没有实现接口的类，就可以使用CGLIB实现。
 * 2.CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。
 * 它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
 * 3.CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
 * 不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
 *
 * cglib与动态代理最大的区别就是
 * 1.使用动态代理的对象必须实现一个或多个接口
 * 2.使用cglib代理的对象则无需实现接口，达到代理类无侵入。
 */

public class MyDynamicProxy {
    public static  void main (String[] args) {
        HelloImpl hello = new HelloImpl();

        // static proxy
        HelloStaticProxy staticProxy = new HelloStaticProxy(hello);
        staticProxy.sayHello();

        //--- jdk dynamic proxy ---
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        // construct code instance
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
        // invoke
        proxyHello.sayHello();

        //cglib
        CGLIBProxyFactory proxyFactory = new CGLIBProxyFactory(hello);
        ((HelloImpl)proxyFactory.getProxyInstance()).sayHello();
    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements  Hello {
    @Override
    public void sayHello() {
        System.out.println("kexiao8.javatest.Hello World");
    }
}

class HelloStaticProxy implements Hello {
    private Hello target;

    public HelloStaticProxy(Hello target){
        this.target = target;
    }

    @Override
    public void sayHello() {
        System.out.println("static proxy begin:src.kexiao8.javatest.Hello World");
        target.sayHello();
        System.out.println("static proxy end");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(target, args);
        return result;
    }
}

class CGLIBProxyFactory implements MethodInterceptor{

    private Object target;//维护一个目标对象
    public CGLIBProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }
}

