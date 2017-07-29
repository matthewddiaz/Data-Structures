# Fundamental Data Structures

## Graphs

### Definitions

A **Graph G(V,E)** is a data structures that shows relations. A Graph contains a Set of **vertices** and a 
set of **edges** which demonstrate how those vertices are related to one another.

**V** in G(V,E) is called the vertex set of G, it's elements are called **vertices**.

**E** in G(V,E) is called the edge set of G, it's elements are called **edges**.

The two main types of graphs are **directed** and **undirected** graphs

**adjacent vertices** - if the pair (u,v) is an edge in a graph G(V,E), vertex v is adjacent to vertex u.
**Note** when the graph is undirected, the adjacency relation is symmetric however in a directed graph it 
is not necessarily symmetric.

**self-loops** - are edges from a vertex to itself

**sparse graph** - when the amount of edges |E| is much less than |V|^2

**dense graph** - when the amount of edges |E| is close to |V|^2

### Directed graphs

A **directed graph G(V,E)** is a pair where **V** is a finite set & **E** is a binary relation on **V**.
 
In a directed graph the edge set **E** consists of **ordered** pairs of vertices. That is edge (1,2) is not
equal to (2,1). The first vertex in the pair is the **source** and the second vertex is the **destination**.
 
**Note:** self-loops are allowed.

### Undirected graphs

A **undirected graph G(V,E)** is the same as a directed graph; except that its edge set **E** consists of **unordered**
pairs of vertices. That is the edge (1,2) is equal to (2,1).

**Note:** self-loops are not allowed.

### Weighted graphs
A **weighted graph** is a graph were each edge in it's edgeSet has an attribute weight. The weight of that edge can 
signify for example distance between the two vertices the edge is connecting in a graph.

### UnWeighted graphs
An **unWeighted graph** is a graph were each edge in it's edgeSet does not have a weight. That is the distance
from a vertex **u** to it's adjacent vertex **v** is always 1.

### Paths in a Graph

A **path** of length **k** from vertex **u** to vertex **u'** in a graph G(V,E) is a sequence <v0... vk>. The length 
of the path is the number of edges in the path. The path consists of the vertices <v0 ... vk> and the edges
(v0, v1) ... (v(k-1)),vk)

If there exists a path **p** from two vertices **u** and **u'** then **u'** is reachable from **u** via the path **p**.

A path is **simple** if all vertices in the path are **distinct**.

### Representing Graphs

There are two common methods 
1) Adjacency List
2) Adjacency Matrix

#### 1) Adjacency List

**Adjacency List** - for a given graph G = (V,E) is an array **Adj** where each vertex **u** in **V** has its own 
list of adjacent vertices in G. These lists are usually implemented using a singly linked list.
 
**Note:** for a directed graph given a edge (u,v) only add **v** to **u**'s adjVertexList; for undirected graph
add **v** to **u**'s adjVertexList and add **u** to **v**'s adjVertexList.

Pros of using an Adjacency List:

1) Best way of representing sparse graphs. Space efficient requires O(V + E)
2) Adj-lists can be easily adapted: ex: can add weights

Con of using an Adjacency List:

1) It's slow to determine if edge(u,v) is present in the graph. That is because you would have to check 
all of the vertices in **u**'s adjVertexList.

#### 2) Adjacency Matrix

**Adjacency Matrix* - for a given graph G = (V,E) consists of |V| * |V| matrix; usually implemented as a 2D array.
If edge (u,v) exists in edge set **E** of graph **G**  then the slot of the matrix adjMatrix[u][v] = 1; else the 
slot of the matrix adjMatrix[u][v] = 0.
  
Pros of using an Adjacency Matrix:
   
1) Simple to implement
   
Con of using an Adjacency Matrix:
   
1) Requires more space   

### Graph Implementations

#### Implementation for Abstract class: [Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/Graph.java)

#### Implementation for Abstract class: [UnWeighted Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/unWeightedGraphs/UnWeightedGraph.java)

#### Implementation for Abstract class: [Weighted Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/weightedGraphs/WeightedGraph.java)



#### Implementation for class: [UnWeighted UnDirected Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/unWeightedGraphs/UnWeightedUnDirectedGraph.java)

#### Implementation for class: [UnWeighted Directed Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/unWeightedGraphs/UnWeightedDirectedGraph.java)



#### Implementation for class: [Weighted UnDirected Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/weightedGraphs/WeightedUnDirectedGraph.java)

#### Implementation for class: [Weighted Directed Graph](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/graphs/weightedGraphs/WeightedDirectedGraph.java)




 
 





