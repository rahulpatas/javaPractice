package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        getResult(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[],
                                  int target, int start){
        if(target > 0){

            for(int i = start; i < candidates.length; i++){

                if (target < candidates[i]){
                    break;
                }

                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }
        else if(target == 0 ){
            result.add(new ArrayList<>(cur));
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{1}, 1);
    }
}
