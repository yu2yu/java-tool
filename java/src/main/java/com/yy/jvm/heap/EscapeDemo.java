package com.yy.jvm.heap;

/**
 * @description: 逃逸分析
 * @author: yy
 * @date: 2020/7/31 13:42
 */
public class EscapeDemo {

    private Object o;

    /**
     * 给全局变量赋值，发生逃逸 GlobalEscape
     */
    public void globalVariablePointerEscape(){
        o = new Object();
    }

    /**
     * 返回对象发生逃逸 GlobalEscape
     * @return
     */
    public Object methodEscape(){
        return new Object();
    }

    /**
     * 实例引用传递发生逃逸 ArgEscape
     */
    public void instancePassEscape(){
        Object o1 = methodEscape();
    }


    /**
     * 没有发生逃逸
     */
    public void noEscape() {
        Object o = new Object();
    }
}
