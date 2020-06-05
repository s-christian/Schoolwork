# These would be placed within the Graph class
# In this case, 1000 represents the max distance, or our "infinity"

def dijkstra(self, src):
    distances = [1000] * self.size
    distances[src] = 0
    shortestPathTree = [False] * self.size
    for cout in range(self.size):
        u = self.minDistance(distances, shortestPathTree)
        shortestPathTree[u] = True
        for v in range(self.size):
            if self.graph[u][v] > 0 and shortestPathTree[v] == False and distances[v] > distances[u] + self.graph[u][v]:
                distances[v] = distances[u] + self.graph[u][v]


def minDistance(self, distances, shortestPathTree):
    min = 1000
    for v in range(self.size):
        if distances[v] < min and shortestPathTree[v] == False:
            min = distances[v]
            min_index = v
    return min_index
