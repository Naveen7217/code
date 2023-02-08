class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        int id = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            res[id++]=curr;
            List<Integer> get = adj.get(curr);
            for(int j:get)
            {
                indegree[j]--;
                if(indegree[j]==0)
                {
                    q.offer(j);
                }
            }
        }
        if(numCourses!=id)
        {
            return new int[0];
        }
        return res;
        
    }
}
