package com.yy.pattern.single;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/24 9:42
 */
public class SingleonInstanceThreadLazyGrace {

    private static final class SingleonInstance {
        private static final SingleonInstanceThreadLazyGrace INSTANCE_THREAD_LAZY_GRACE = new SingleonInstanceThreadLazyGrace();
    }

    private SingleonInstanceThreadLazyGrace(){}

    public static SingleonInstanceThreadLazyGrace getInstance(){
        return SingleonInstance.INSTANCE_THREAD_LAZY_GRACE;
    }
}
