package com.topics.recursion;
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note: The solution set must not contain duplicate combinations.
//
//
//
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]

import java.lang.reflect.Array;
import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates ={10,1,2,7,6,1,5};
        System.out.println(combinationSum(candidates,8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
       findCombinations(0,candidates,target,list,new ArrayList<>());
       return list;
    }

    private static void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> storeList) {
       if(target==0){
           ans.add(new ArrayList<>(storeList));
           return;
       }
       for(int i=ind;i<candidates.length;i++){
           if(i>ind && candidates[i]==candidates[i-1]) continue;
           if(candidates[i]>target) break;
           storeList.add(candidates[i]);
           findCombinations(i+1,candidates,target-candidates[i],ans,storeList);
           storeList.remove(storeList.size()-1);
       }
    }
}
