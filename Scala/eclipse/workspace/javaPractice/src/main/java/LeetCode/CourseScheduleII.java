package LeetCode;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List[] course = new List[numCourses];
        int[] map = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {

            if(course[i] == null) {
                course[i] = new ArrayList<Integer>();
            }

            course[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++) {
            if (dfs(course, i, ans, map)) {
                return new int[0];
            }
        }

        int[] an=new int[ans.size()];

        for(int i=0;i<ans.size();i++) {
            an[i] = ans.get(i);
        }
        return an;
    }

    public boolean dfs(List[] course,int req,List<Integer> ans,int[] map)
    {
        if(map[req]==0)
        {
            map[req]=1;
            for(int i=0;i<course[req].size();i++) {
                if (!dfs(course, (int) course[req].get(i), ans, map)) return false;
                map[req] = 2;
            }
        }
        else if(map[req]==1) return false;
        else if(map[req]==2) return true;
        ans.add(req);
        return true;
    }
}
