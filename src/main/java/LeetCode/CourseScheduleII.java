package LeetCode;

import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List[] course = new List[numCourses];

        int[] map = new int[numCourses];
        List<Integer> ans = new ArrayList<>();


        for (int[] pair : prerequisites) {

            int key = pair[0];
            int val = pair[1];

            if(course[key] == null) {
                course[key] = new ArrayList<>();
            }

            course[key].add(val);
        }

        for(int i = 0; i < numCourses; i++) {
            if (dfs(course, i, ans, map)) {
                return new int[0];
            }
        }

        return ans.parallelStream().mapToInt(a -> a).toArray();
    }

    public static boolean dfs(List[] course, int req, List<Integer> ans, int[] map)
    {
        if(map[req] == 0)
        {
            map[req] = 1;

            if(course[req] != null) {
                for (int i = 0; i < course[req].size(); i++) {
                    if (!dfs(course, (int) course[req].get(i), ans, map)) {
                        return false;
                    }
                    map[req] = 2;
                }
            }
        } else if(map[req] == 1) {
            return false;
        } else if(map[req] == 2) {
            return true;
        }

        ans.add(req);
        return true;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1,0}})));
    }
}
