package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	public static int n, m;							//n = number of vertices and m = number of edges
	public static ArrayList<Edge> graphEdges = new ArrayList<Edge>();	//stores edges of the input graph
	public static ArrayList<Edge> mSTEdges = new ArrayList<Edge>();		//stores edges of the output MST 
	public static int optimumWeight = 0;					//optimum weight of the MST
	
	
	
	public static void main(String[] args) {
		System.out.print("Enter the number of vertices and edges: ");
		n = scanner.nextInt();
		m = scanner.nextInt();
		getGraph();
		Collections.sort(graphEdges, Edge.compareByEdgeWeight);
		
		System.out.println("##################################################RESULTS##################################################");
		System.out.println();
		
		System.out.println("State of the Vertices before applying Kruskal's algorithm:");
		for (Edge edge : graphEdges) {
			System.out.println("ID1: " + edge.getFirstVertex().getId() + " Size1: " + edge.getFirstVertex().getSize() + " Parent1: " + edge.getFirstVertex().getParent().getId() + "     ID2: " + edge.getSecondVertex().getId() + " Size2: " + edge.getSecondVertex().getSize() + " Parent2: " + edge.getSecondVertex().getParent().getId());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		for (Edge edge : graphEdges) {
			optimumWeight += unify(edge.getFirstVertex(), edge.getSecondVertex(), edge.getEdgeWeight());
		}
		
		System.out.println("State of the Vertices after applying Kruskal's algorithm:");
		for (Edge edge : graphEdges) {
			System.out.println("ID1: " + edge.getFirstVertex().getId() + " Size1: " + edge.getFirstVertex().getSize() + " Parent1: " + edge.getFirstVertex().getParent().getId() + "     ID2: " + edge.getSecondVertex().getId() + " Size2: " + edge.getSecondVertex().getSize() + " Parent2: " + edge.getSecondVertex().getParent().getId());
		}
		System.out.println();
		
		Collections.sort(mSTEdges, Edge.compareBySecondVertexID);
		Collections.sort(mSTEdges, Edge.compareByFirstVertexID);
		System.out.println("\n\nOptimum weight of the MST is: " + optimumWeight);
		for (Edge edge : mSTEdges) {
			if (edge.getFirstVertex().getId() > edge.getSecondVertex().getId()) {
				System.out.println(edge.getSecondVertex().getId() + " " + edge.getFirstVertex().getId());
			}
			else {
				System.out.println(edge.getFirstVertex().getId() + " " + edge.getSecondVertex().getId());
			}
		}
		
		scanner.close();
	}
	
	
	
	public static void getGraph() {
		System.out.println("Enter each pair of vertices connected by an edge and then the weight of the edge concecting the two vertices: ");
		for (int i = 0; i < m; i++) {
			Edge newEdge = new Edge();
			System.out.printf("Enter info of edge number %d: ", i+1);
			
			
			int firstVertexID = scanner.nextInt();
			if (getVertexByID(firstVertexID) != null) {
				newEdge.setFirstVertex(getVertexByID(firstVertexID));
			}
			else {
				newEdge.setFirstVertex(new Vertex(firstVertexID, 1));
			}
			
			int secondVertexID = scanner.nextInt();
			if (getVertexByID(secondVertexID) != null) {
				newEdge.setSecondVertex(getVertexByID(secondVertexID));
			}
			else {
				newEdge.setSecondVertex(new Vertex(secondVertexID, 1));
			}
			
			newEdge.setEdgeWeight(scanner.nextInt());
			graphEdges.add(newEdge);
		}
	}
	
	
	
	public static Vertex getVertexByID(int vertexID) {
		for (Edge edge : graphEdges) {
			if (edge.getFirstVertex().getId() == vertexID) {
				return edge.getFirstVertex();
			}
			if (edge.getSecondVertex().getId() == vertexID) {
				return edge.getSecondVertex();
			}
		}
		return null;
	}
	
	
	
	public static int unify(Vertex vertex1, Vertex vertex2, int edgeWeight) {
		Vertex vertex1Root = find(vertex1);
		Vertex vertex2Root = find(vertex2);
		if (vertex1Root == vertex2Root) {
			return 0;
		}
		if (vertex1Root.getSize() < vertex2Root.getSize()) {
			vertex1Root.setParent(vertex2Root);
			vertex2Root.setSize(vertex1Root.getSize() + vertex2Root.getSize());
		}
		else {
			vertex2Root.setParent(vertex1Root);
			vertex1Root.setSize(vertex1Root.getSize() + vertex2Root.getSize());
		}
		mSTEdges.add(new Edge(vertex1, vertex2, edgeWeight));
		return edgeWeight;
	}
	
	
	
	public static Vertex find(Vertex vertex) {
		if (vertex.getParent() != vertex) {
			vertex.setParent(find(vertex.getParent()));
		}
		return vertex.getParent();
	}

}

