package LeetCode;

import java.util.*;

public class CourseSchedule {

    Map<Integer, Boolean> postCourses = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> courseMap = new HashMap<>();

        for (int[] pair : prerequisites) {

            int key = pair[0];
            int val = pair[1];

            Set<Integer> values = courseMap.getOrDefault(key, new HashSet<>());
            values.add(val);
            courseMap.put(key, values);
        }

        for (int i = 0; i < numCourses; i++) {

            if(!postCourses.containsKey(i) && isCyclic(i, courseMap)){
                return false;
            }

        }

        return true;
    }

    private boolean isCyclic(int course, Map<Integer, Set<Integer>> courseMap) {

        boolean hasCycle = false;

        postCourses.put(course, true) ;

        if (courseMap.containsKey(course)) {
            for (int v : courseMap.get(course)) {

                if(!postCourses.containsKey(v)){
                    hasCycle = isCyclic(v, courseMap);
                    if(hasCycle){
                        break;
                    }
                }else if (postCourses.get(v)){
                    hasCycle = true;
                    break;
                }
            }
        }

        postCourses.put(course, false);
        return hasCycle;
    }


    boolean[] marked;
    boolean[] onStack;

    public boolean canFinish1(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0) return true;

        marked = new boolean[numCourses]; //marked[v] is true if vertex v is visisted in dfs(in this case hasCycle)
        onStack = new boolean[numCourses]; //onStack[v] is true during the call of hasCycle

        //represent the graph with adjacency lists
        ArrayList<Integer>[]  graph = new ArrayList[numCourses];

        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[1];
            int ele = prerequisite[0];
            if (graph[key] == null) graph[key] = new ArrayList<>();
            graph[key].add(ele);
        }

        for(int i = 0; i < numCourses; i++){
            if(!marked[i] && hasCycle(i, graph)) return false;
        }

        return true;
    }

    private boolean hasCycle(int vertex, List[] g){
        marked[vertex] = true;
        onStack[vertex] = true;
        boolean hasCycle = false;

        if(g[vertex] != null){
            for(Object w :  g[vertex]){
                if(!marked[(int)w]) {
                    hasCycle = hasCycle((int)w, g);
                    if(hasCycle) break;
                }
                else if(onStack[(int)w]) {
                    hasCycle = true;
                    break;
                }
            }
        }
        onStack[vertex] = false;
        return hasCycle;
    }
}
