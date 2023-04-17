import java.io.*;
import java.util.*;

public class GFG{
    public static int minOper(String A, String B){
        if(A.length() != B.length()){
            return -1;
        }
        int i, j, res = 0;
        int count[] = new int [256];

        for(i = 0; i<A.length(); i++){
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }
    }
}

// Algorithm BFS(G, s)
// // G is a graph with n vertices, and s is a vertex from G
// // state is an array n long, and contains the label of each node as
// //      undiscovered, discovered, and processed
// // pred is an array n long, and holds the node that preceded each node
// // in the search (from this we can reconstruct the shortest paths
// 	for each vertex v in G do
// 		let state[v] = “undiscovered”
// 		let pred[v] = nil   # no known predecessor so far
// 	let state[s] = “discovered”
// 	let Q = Queue()   // make a new empty queue
// 	Q.enqueue(s)
// 	while Q is not empty do
// 		let u = Q.dequeue()
// 		for each neighbor v in G.getNeighbors(u)
// 			if state[v] = “undiscovered” then
// 				let state[v] = “discovered”
// 				let pred[v] = u
// 				Q.enqueue(v)
// 		let state[u] = “processed”
// 	return state, pred



// Algorithm reconstructPath(pred, goalNode)
// // pred is an array n long, which holds the node that preceded each node
// 	let currNode = goalNode
// 	let path = []
// 	while currNode is not nil do
// 		add currNode to the front of path
// 		let currNode = pred[currNode]
// 	return path