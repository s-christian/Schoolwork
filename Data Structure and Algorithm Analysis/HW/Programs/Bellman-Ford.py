# ==============================================================
# Shortest Path Program
# ==============================================================
# Programming Assignment 3 - Shortest Path Program, Part 2 (Bellman-Ford)
#
# Code assisted by GeeksForGeeks
#
# Graph using an adjacency matrix implementation.
# Our graph will be the graph in Programming Assignment 3 with the adjustments mentioned in Part 2

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
        elif src != dest:
            self.graph[src - 1][dest - 1] = weight
        elif weight != 0:  # src == dest
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

    def bellmanFord(self, src):
        # Create a distances list for use with bellman-ford,
        # initially setting all distances to infinity
        dist = [math.inf] * self.num_of_vertices
        # The distance from source to source is zero
        # Since our first node is 1, subtract 1 to use as an index
        dist[src - 1] = 0

        # Calculate distances
        # Go through every entry in the adjacency matrix and test only the edges (non-zero weights)
        for u in range(self.num_of_vertices):
            for v in range(self.num_of_vertices):
                if self.graph[u][v] != 0 and dist[v] > dist[u] + self.graph[u][v]:
                    dist[v] = dist[u] + self.graph[u][v]  # relax edge

        # Check for negative weight cycles
        for u in range(self.num_of_vertices):
            for v in range(self.num_of_vertices):
                if self.graph[u][v] != 0 and dist[v] > dist[u] + self.graph[u][v]:
                    # If an improvement is found after finishing our initial full-graph calculation, there is a negative cycle
                    print(
                        "Graph contains a negative weight cycle. Cannot calculate distances.")
                    return

        # Print the minimum distances from source to every node
        self.printSolution(dist)

    def printSolution(self, dist):
        print("Vertex\tDistance from Source")
        for node in range(self.num_of_vertices):
            print(node + 1, "\t\t", dist[node], sep='')


# Creating our Graph
graph = Graph(7)

print("[-] Creating edges...")

print("[?] Testing the two error cases:")
graph.addEdge(1, 1, 10)
graph.addEdge(8, 1, 10)

# Filling our graph
graph.addEdge(1, 2, 2)
graph.addEdge(1, 4, -1)

graph.addEdge(2, 4, 3)
graph.addEdge(2, 5, 10)

graph.addEdge(3, 1, 4)
graph.addEdge(3, 6, 5)

graph.addEdge(4, 3, 2)
graph.addEdge(4, 6, 8)
graph.addEdge(4, 7, 4)
graph.addEdge(4, 5, -2)

graph.addEdge(5, 7, 6)

graph.addEdge(7, 6, -1)

print("[+] Finished creating edges")
print()

graph.printGraph()
print()

# Start Bellman-Ford at Node 1
print("Source: Node 1")
graph.bellmanFord(1)
