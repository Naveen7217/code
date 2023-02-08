class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            for(int j : adj.get(i))
            {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            int curr = q.poll();
            res.add(curr);
            for(int j:adj.get(curr))
            {
                indegree[j]--;
                if(indegree[j]==0)
                {
                    q.offer(j);
                }
            }
        }
        return res.size()==numCourses;
        
    }
}
