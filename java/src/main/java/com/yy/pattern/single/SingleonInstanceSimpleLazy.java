package com.yy.pattern.single;

/**
 * @description: 单例模式
 *  单例模式需要考虑三点：
 *      1. 是否懒加载
 *      2. 是否线程安全
 *      3. 是否反射破坏
 * @author: yy
 * @date: 2020/7/24 9:33
 */
public class SingleonInstanceSimpleLazy {

    private static SingleonInstanceSimpleLazy singleonInstanceSimpleLazy;

    private SingleonInstanceSimpleLazy(){}

    public static SingleonInstanceSimpleLazy getInstance(){
        if(singleonInstanceSimpleLazy == null){
            singleonInstanceSimpleLazy = new SingleonInstanceSimpleLazy();
        }
        return singleonInstanceSimpleLazy;
    }

}
