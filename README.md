# Project Title

Shortest Paths Algorithms for Directed Weighted Graphs

## Introduction
In this project, we have implemented three different shortest path algorithms for directed weighted graphs: Dijkstra, Bellman-Ford, and Floyd-Warshall. These algorithms are widely used in graph theory and have various applications in fields such as network routing, transportation, and social networks.

### Dijkstra Algorithm
Dijkstra's algorithm finds the shortest paths from a source node to all other nodes in the graph, producing a shortest path tree. Its time complexity is O(V^2), but it can be optimized to reach less than that when using a priority queue. Dijkstra's algorithm cannot handle negative weights, but it is asymptotically the fastest known single-source shortest path algorithm for arbitrary directed graphs with unbounded non-negative weights.

### Bellman-Ford Algorithm
The Bellman-Ford algorithm is capable of computing shortest paths from a single source vertex to all other vertices in a weighted directed graph. It can handle graphs in which some of the edge weights are negative numbers. It works in O(V * E) time and O(V) space complexities, where V is the number of vertices and E is the number of edges in the graph. Additionally, it can detect the presence of a negative cycle in the graph.

### Floyd-Warshall Algorithm
The Floyd-Warshall algorithm is used to find the shortest paths between all pairs of vertices in a directed weighted graph. It can handle both positive and negative edge weights. A single execution of the algorithm will find the lengths of shortest paths between all pairs of vertices. It works in O(V^3) time complexity and can detect the presence of a negative cycle in the graph.

## Graph Class
We have implemented a Graph class that encapsulates the graph structure and provides methods to apply the different shortest path algorithms on it. The following methods are implemented in this class:

1. **Initialize (constructor)**: Takes a path to a graph input file, structured as described in section 1.4 of this README, reads it, and initializes the graph structure.
2. **Size()**: Returns the number of nodes in the graph.
3. **Dijkstra()**: Takes three parameters: the source node, the costs array, and the parents array. It applies Dijkstra's algorithm starting from the source node, filling the costs array with the cost of the shortest path to all other target nodes, and the parents array with the parent of each node in the shortest path tree.
4. **Bellman-Ford()**: Takes three parameters: the source node, the costs array, and the parents array. It applies Bellman-Ford algorithm starting from the source node, filling the costs array with the cost of the shortest path to all other target nodes, and the parents array with the parent of each node in the shortest path tree. Returns False if a negative cycle is found and True otherwise.
5. **Floyd-Warshall()**: Takes two parameters: the costs matrix and the predecessors matrix. It applies Floyd-Warshall algorithm, filling the costs matrix with the cost of the shortest path between all pairs of nodes, and the predecessors matrix with the appropriate values to reconstruct the paths. Returns False if a negative cycle is found and True otherwise.

## Command Line Interface
We have also implemented a command line interface that allows the user to interact with the implemented graph. The interface takes the path of the file describing the graph structure as an initial input and creates a Graph object using it. The interface is composed of a main menu and two sub-menus, which allow the user to apply subsequent operations on the graph.

## Dependencies
This project requires Java Development Kit (JDK) to be installed on your local machine to compile and run the Java code. Additionally, JUnit and Hamcrest libraries are used for unit testing and should be included in the classpath when compiling and running the tests.

## Contributing
If you would like to contribute to this project, please follow the steps below:

1. Fork the repository to your own GitHub account.
2. Clone the forked repository to your local machine.
3. Create a new branch for your changes.
4. Make your changes and commit them with descriptive commit messages.
5. Push your changes to your forked repository.
6. Create a pull request to the original repository, explaining the changes you made.

## License
This project is licensed under the MIT License. You can find the license details in the LICENSE file.
