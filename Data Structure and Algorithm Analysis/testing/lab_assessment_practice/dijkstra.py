# Tested and verified accurate

from math import inf  # used for initially setting all distance values to infinity (unreached)


class Graph:
    def __init__(self, vertices):
        self.num_of_vertices = vertices
        self.graph = [[0 for column in range(vertices)] for row in range(vertices)]

    def addEdge(self, src, dest, weight):
        # min index is 0, max index is vertices-1
        if src >= self.num_of_vertices or dest >= self.num_of_vertices:
            print("[!] No edge created!!! Node %d is out of scope for this graph (this graph has %d nodes)." % (max(src, dest), self.num_of_vertices))
        elif src < 0 or dest < 0:
            print("[!] No edge created!!! Index cannot be negative.")
        elif src != dest:
            self.graph[src][dest] = weight
        elif weight != 0:  # src == dest
            print("[!] No edge created!!! Weight from node %d to itself cannot be anything but 0." % src)

    def removeEdge(self, src, dest):
        self.graph[src][dest] = 0

    def isConnected(self, src, dest):
        return self.graph[src][dest] != 0

    def printGraph(self):
        print("Source \\ Destination")
        print("    | ", end='')
        for i in range(self.num_of_vertices):
            print(i, "    ", sep='', end='')
        print()
        print("------", "-----" * (self.num_of_vertices-1), "----", sep='')
        for row_number, row in enumerate(self.graph):
            print("{0:3} | ".format(row_number), end='')
            for column in row:
                print("{0:<5}".format(column), end='')
            print()

    def dijkstra(self, src, print=False):
        dist = [inf] * self.num_of_vertices
        dist[src] = 0

        viewed = [False] * self.num_of_vertices

        for i in range(self.num_of_vertices):
            u = self.minDistance(dist, viewed)
            viewed[u] = True
            for v in range(self.num_of_vertices):
                if self.graph[u][v] > 0 and viewed[v] is False and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]

        if print:
            self.printDistances(dist, src)
        return dist

    def minDistance(self, dist, viewed):
        min = inf
        for v in range(self.num_of_vertices):
            if dist[v] < min and viewed[v] is False:
                min = dist[v]
                min_index = v
        return min_index

    def printDistances(self, dist, src):
        print("Source: Node", src)
        print("--------------")
        print("Node\tDistance from Source")
        for i in range(self.num_of_vertices):
            print(i, "\t\t", dist[i])


graph = Graph(7)

graph.addEdge(0, 1, 2)
graph.addEdge(0, 3, 1)

graph.addEdge(1, 3, 3)
graph.addEdge(1, 4, -10)

graph.addEdge(2, 0, 4)
graph.addEdge(2, 5, 5)

graph.addEdge(3, 2, 2)
graph.addEdge(3, 5, 8)
graph.addEdge(3, 6, -4)
graph.addEdge(3, 4, 2)

graph.addEdge(4, 6, 6)

graph.addEdge(6, 5, 1)

graph.printGraph()
print()

dist = graph.dijkstra(0)
print(dist)
print()

graph.dijkstra(0, True)
