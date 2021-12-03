graph -> graph 1 + graph 2 + graph 3 ... 

1, 2, 3, ...  are the connected components of the graph

dfs / bfs code 
I usually create a visited array to store which index is visited 

the same array can be used to traverse a disconnected graph


how can we detect cycle in a graph using dfs
parent array -> initially all values are indices itself
kruskals algorithm


sourceParent, destinationParent => same cycle else not

count n-1
input array 

let the graph be 
3 3
0 1
1 2
2 0