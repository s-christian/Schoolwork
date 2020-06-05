# ==============================================================
# Network Flow Program
# ==============================================================
# Programming Assignment 4 - Ford-Fulkerson Network Flow Algorithm
# Graph uses an adjacency matrix implementation
#
# Code assisted by GeeksForGeeks
#
#
#              --- OBSERVATIONS ---
#     Default edge weight: 0.000284391... seconds
#       1000x edge weight: 0.000297544... seconds
#    1000000x edge weight: 0.000378215... seconds
# 1000000000x edge weight: 0.000228273... seconds
#
# Changing the edge weights does not seem to have a significant effect on
# running time, especially since the program actually runs faster when edge
# weights are multiplied by one billion. It is interesting to note that
# lower edge weights do result in slightly faster running times, but only
# up to a certain point, as observed by the last result. After running the
# program multiple times for each edge weight multiplier, the results do
# change slightly. For instance, running with default edge weights a second
# time took 0.000333... seconds. I am assuming that due to the low number of
# comparisons made using edge weight, any effect on running time by how large
# the edge weights are is negligible. The noise in the data is likely due to
# processes running on the system in the background.
# --------------------------------------------------------------


# The math module is used for its infinity value
import math
# The time module is used to calculate running time
import time


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

    # Returns true if there is a path from source to sink
    # in the residual graph. Also fills paths with parents.
    # Only tells us if a path exists!
    def bfs(self, src, sink, paths):
        if src == sink:
            return True

        # Create a visited list and mark all vertices as not visited
        visited = [False] * self.num_of_vertices

        # Create a queue, enqueue source, mark source as visited
        queue = []
        queue.append(src)
        visited[src] = True

        parents = [-1] * self.num_of_vertices  # Keep track of the path we take

        # Standard BFS loop
        # While the queue is not empty
        while queue:
            # Dequeue a vertex
            u = queue.pop()

            # Get all adjacent vertices of the dequeued vertex.
            # If an adjacent vertex has not been visited,
            # mark it as visited and enqueue it.
            # Branch out to every valid (unvisited) path until
            # either all paths have been visited without seeing sink,
            # or we reach sink.
            for node_num, weight in enumerate(self.graph[u]):
                if not visited[node_num] and weight > 0:  # only look at connected nodes
                    parents[node_num] = u
                    if node_num == sink:  # Can return True immediately if we know there is a connection to sink
                        # Add this path to our list of paths
                        paths.append(parents)
                        return True
                    else:
                        queue.append(node_num)
                        visited[node_num] = True

        # If we reach sink, return True
        return False

    # Ford-Fulkerson is a greedy algorithm that promises the global optimum
    def fordFulkerson(self, src, sink):
        if src == sink:
            return math.inf

        paths = []  # Keep track of all the paths used
        flows = []  # Keep track of flows for paths

        max_flow = 0

        counter = 0  # Counter to select which path we're dealing with

        # While there is a path, augment the flow.
        # For each step, start at the end of the path,
        # working your way back down to the src through the parental chain.
        while self.bfs(src, sink, paths):
            # Find min capacity of the edges along the path.
            flow = math.inf
            s = sink
            while s is not src:
                flow = min(flow, self.graph[paths[counter][s]][s])
                s = paths[counter][s]

            flows.append(flow)
            max_flow += flow  # Add path flow to total flow

            # Update residual capacities
            s = sink
            while s is not src:
                u = paths[counter][s]
                self.graph[u][s] -= flow
                self.graph[s][u] -= flow
                s = paths[counter][s]

            counter += 1

        self.printPaths(src, sink, paths, flows)
        return max_flow

    def printPaths(self, src, sink, paths, flows):
        print("--- Paths ---")

        correct_paths = []  # Properly-formatted paths

        for path in paths:
            node = path[-1]  # Start at ending node
            temp = []
            while node != src:  # Go through every parent until src is reached
                temp.append(node)
                node = path[node]
            temp.reverse()  # Since we appended everything, reverse our list
            correct_paths.append(temp)

        for num, path in enumerate(correct_paths):
            print(src, "--> ", end='')
            for node in path:
                print(node, "--> ", end='')
            print(sink, "\t\t\tFlow of", flows[num])


if __name__ == "__main__":
    print("[-] Creating Graph...")
    graph = None
    while graph is None:
        num = input("--> How many vertices are in your graph? : ")
        try:
            num = int(num)
            graph = Graph(num)
        except ValueError:
            print("!!! Your input must be a single integer")
    print("[+] Graph created")
    print()

    print("[-] Creating edges...")
    print("--> The first node is represented with 0")
    print("--> Type 'done' to stop")
    print("--> Please input edges in the following form: source destination weight")
    while True:
        inputList = input("--> ").split()  # Split our arguments into a list

        v = None
        try:
            v = inputList[0]
        except IndexError:
            print("!!! No input provided")

        if v == "done":
            break
        try:
            v, u, w = int(v), int(inputList[1]), int(inputList[2])
            graph.addEdge(v, u, w)
        except (TypeError, ValueError, IndexError):
            print(
                "!!! If input is not 'done', provide three integers for [source destination weight]")
    print("[+] Finished creating edges")
    print()

    graph.printGraph()
    print()

    # Get user input for source node
    source_node = None
    while source_node is None:
        node = input("Source node (0 - %d) : " % (graph.num_of_vertices - 1))
        try:
            temp = int(node)
        except ValueError:
            print("! Input must be an integer !")
            continue
        if temp >= 0 and temp < graph.num_of_vertices:
            source_node = temp
        else:
            print("! Input must be within the specified range !")

    # Get user input for sink node
    sink_node = None
    while sink_node is None:
        node = input("Sink node (0 - %d) : " % (graph.num_of_vertices - 1))
        try:
            temp = int(node)
        except ValueError:
            print("! Input must be an integer !")
            continue
        if temp >= 0 and temp < graph.num_of_vertices:
            sink_node = temp
        else:
            print("! Input must be within the specified range !")

    print()

    tic = time.perf_counter()
    print("\nThe maximum possible flow is",
          graph.fordFulkerson(source_node, sink_node))
    toc = time.perf_counter()
    print("\nRunning time:", toc - tic)
