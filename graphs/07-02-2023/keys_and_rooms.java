class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.offer(0);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int neigh:rooms.get(curr))
            {
                if(!visited[neigh])
                {
                    q.offer(neigh);
                    visited[neigh]=true;
                }
            }
        }
        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==false)
            {
                return false;
            }
        }
        return true;
        
    }
}
