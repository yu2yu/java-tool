package com.yy.pattern.single;

/**
 * @description:
 * @author: yy
 * @date: 2020/7/24 9:38
 */
public class SingleonInstanceThreadLazy {

    private static volatile SingleonInstanceThreadLazy singleonInstance;

    private SingleonInstanceThreadLazy(){}

    public static SingleonInstanceThreadLazy getInstance(){
        if(singleonInstance == null){
            synchronized (SingleonInstanceThreadLazy.class){
                if(singleonInstance == null){
                    // 初始化有多条指令，可能涉及指令重排
                    singleonInstance = new SingleonInstanceThreadLazy();
                }
            }
        }
        return singleonInstance;
    }
}
