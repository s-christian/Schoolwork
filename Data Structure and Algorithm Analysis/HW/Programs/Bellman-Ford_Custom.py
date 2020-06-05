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
        # min index is 0, max index is vertices-1
        if src >= self.num_of_vertices or dest >= self.num_of_vertices:
            print("[!] No edge created!!! Node %d is out of scope for this graph (this graph has %d nodes)." % (
                max(src, dest), self.num_of_vertices))
        elif src < 0 or dest < 0:
            print("[!] No edge created!!! Index cannot be negative.")
        elif src != dest:
            self.graph[src][dest] = weight
        elif weight != 0:  # src == dest
            print(
                "[!] No edge created!!! Weight from node %d to itself cannot be anything but 0." % src)

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

    def bellmanFord(self, src):
        dist = [math.inf] * self.num_of_vertices
        dist[src] = 0

        # Find minimum distances
        # Go over the entire graph V-1 times (the maximum possible total number of edges)
        for i in range(self.num_of_vertices - 1):
            for u in range(self.num_of_vertices):
                for v in range(self.num_of_vertices):
                    if self.graph[u][v] != 0 and dist[u] != math.inf and dist[u] + self.graph[u][v] < dist[v]:
                        dist[v] = dist[u] + self.graph[u][v]  # relax edge

        # Look for negative weight cycles
        # Go over all edges one more time
        for u in range(self.num_of_vertices):
            for v in range(self.num_of_vertices):
                if self.graph[u][v] != 0 and dist[u] != math.inf and dist[u] + self.graph[u][v] < dist[v]:
                    # If an improvement is found after finishing our initial full-graph calculation, there is a negative cycle
                    print(
                        "Graph contains a negative weight cycle. Cannot calculate distances.")
                    return

        self.printSolution(dist)

    def printSolution(self, dist):
        print("Vertex\tDistance from Source")
        for node in range(self.num_of_vertices):
            print(node, "\t\t", dist[node], sep='')


# Creating our Graph
print("[-] Creating Graph...")
graph = None
while graph is None:
    num = input("--> How many vertices are in your graph?: ")
    try:
        num = int(num)
        graph = Graph(num)
    except ValueError:
        print("!!! Your input must be a single integer")
print("[+] Graph created")
print()

print("[-] Creating edges...")
print("--> Type 'done' to stop")
print("--> Please input edges in the following form: source destination weight")
while True:
    inputList = input("--> ").split()
    v = inputList[0]
    if v == "done":
        break
    try:
        v, u, w = int(v), int(inputList[1]), int(inputList[2])
        graph.addEdge(v, u, w)
    except ValueError:
        print("!!! Input must contain three integers separated by whitespace, or 'done' to finish")
print("[+] Finished creating edges")
print()

graph.printGraph()
print()

# Start Bellman-Ford at Node 0
print("Source: Node 0")
graph.bellmanFord(0)
