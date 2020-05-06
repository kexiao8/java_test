package kexiao8.javatest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java.util.Arrays;

interface Calc{
    public int add(int a, int b);
}

class AritCalc implements Calc{
    @Override
    public int add(int a, int b){
        return a+b;
    }
}

class AritClacInvocationHander implements InvocationHandler {
    private Object target = null;
    public AritClacInvocationHander(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("test aop in invoke begin");
        System.out.println("the method[" + method.getName() + "]" + " args=" + Arrays.toString(args));

        Object result = method.invoke(this.target, args);
        
        System.out.println("test aop in invoke end " + result);
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }
}
public class AOPTest{
    public static void main(String[] args){
        Calc caclProxy = (Calc)new AritClacInvocationHander(new AritCalc()).getProxy();
        caclProxy.add(10, 20);
    }
}