package com.yy.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，
 * 每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，
 * 如果不可能凑出，算法返回 -1 。
 * @author: yy
 * @date: 2020/7/10 10:01
 */
public class CoinAmount {

    /**
     * 动态规划问题
     *  base 0 =》0
     *  状态转移过程： dp(n) = min(1+dp(n-1))
     * @param coins
     * @param amount
     * @return
     */
    public int minCountCoin(int[] coins,int amount,Map<Integer,Integer> map ){
        // 暴力解决
        if(amount == 0){return 0;}
        if(amount < 0){return -1;}
        if(map.get(amount) != null){return map.get(amount);}
        int res = 100000;
        // 什么时候返回-1 也就是所有的代码
        for(int coin:coins) {
            int sub =  minCountCoin(coins, amount - coin,map);
            if(sub == -1){continue;}
            res = Math.min(res,sub+1);
        }
        map.put(amount,res);
        return res != 100000?res:-1;
    }

    /**
     * 也就是每个位置按最差来算也就是一块钱硬币
     *  也是说从底向上每个位置都已经是最优的
     * @param coins
     * @param amount
     * @return
     */
    public int minCountCoinBottom(int[] coins,int amount ){
        if(amount == 0){return 0;}
        if(amount < 0){return -1;}
        int[] dp = new int[amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = i;
            for(int coin:coins){
                if((i-coin)<0){continue;}
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,3};
        // 暴力解决
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(new CoinAmount().minCountCoin(coins,80,map));

        System.out.println(new CoinAmount().minCountCoinBottom(coins,80));
    }
}
