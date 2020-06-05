# ==============================================================
# Shortest Path Program
# ==============================================================
# Programming Assignment 3 - Shortest Path Program, Part 1 (Dijkstra)
#
# Code assisted by GeeksForGeeks
#
# Graph using an adjacency matrix implementation.
# Our graph will be the graph in Programming Assignment 3

# The math module is used for its infinity value
import math


class Graph:
    def __init__(self, vertices):
        self.num_of_vertices = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]

    def addEdge(self, src, dest, weight):
        # Since our first node's number starts with 1 instead of 0,
        # subtract 1 to work as a valid matrix index.
        if src > self.num_of_vertices or dest > self.num_of_vertices:
            print("[!] No edge created!!! Node %d is out of scope for this graph (this graph has %d nodes)." % (
                max(src, dest), self.num_of_vertices))
        elif weight < 0:
            print("[!] No edge created!!! Weight cannot be negative in Dijkstra.")
        elif src != dest:
            self.graph[src - 1][dest - 1] = weight
        elif weight > 0:  # src == dest
            print(
                "[!] No edge created!!! Weight from node %d to itself cannot be anything but 0." % src)

    def removeEdge(self, src, dest):
        # Subtracting 1 for the same reason as stated in addEdge above
        self.graph[src - 1][dest - 1] = 0

    def isConnected(self, src, dest):
        return self.graph[src][dest] != 0

    def printGraph(self):
        print("Source \\ Destination")
        print("    | 1    2    3    4    5    6    7")
        print("-------------------------------------")
        for row_number, row in enumerate(self.graph):
            print("{0:3} | ".format(row_number + 1), end='')
            for column in row:
                print("{0:<5}".format(column), end='')
            print()

    def dijkstra(self, src):
        # Create a distances list for use with dijkstra,
        # initially setting all distances to infinity
        dist = [math.inf] * self.num_of_vertices
        # The distance from source to source is zero
        # Since our first node is 1, subtract 1 to use as an index
        dist[src - 1] = 0

        # Keep track of finished nodes
        viewed_nodes = [False] * self.num_of_vertices

        # Calculate distances
        for i in range(self.num_of_vertices):
            u = self.minDistance(dist, viewed_nodes)
            viewed_nodes[u] = True
            for v in range(self.num_of_vertices):
                if self.graph[u][v] > 0 and viewed_nodes[v] == False and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]  # relax edge

        # Print the minimum distances from source to every node
        self.printSolution(dist)

    def minDistance(self, dist, viewed_nodes):
        min = math.inf
        for v in range(self.num_of_vertices):
            # Look at every node and find the minimum distance,
            # setting the new min if the node hasn't been finished yet
            if dist[v] < min and viewed_nodes[v] is False:
                min = dist[v]
                min_index = v
        return min_index

    def printSolution(self, dist):
        print("Vertex\tDistance from Source")
        for node in range(self.num_of_vertices):
            print(node + 1, "\t\t", dist[node], sep='')


# Creating our Graph
graph = Graph(7)

print("[-] Creating edges...")

print("[?] Testing the three error cases:")
graph.addEdge(1, 1, 10)
graph.addEdge(1, 2, -10)
graph.addEdge(8, 1, 10)

# Filling our graph
graph.addEdge(1, 2, 2)
graph.addEdge(1, 4, 1)

graph.addEdge(2, 4, 3)
graph.addEdge(2, 5, 10)

graph.addEdge(3, 1, 4)
graph.addEdge(3, 6, 5)

graph.addEdge(4, 3, 2)
graph.addEdge(4, 6, 8)
graph.addEdge(4, 7, 4)
graph.addEdge(4, 5, 2)

graph.addEdge(5, 7, 6)

graph.addEdge(7, 6, 1)

print("[+] Finished creating edges")
print()

graph.printGraph()
print()

# Start Dijkstra at Node 1
print("Source: Node 1")
graph.dijkstra(1)
