package main;

import java.util.Comparator;

public class Edge {
	
	public Vertex firstVertex;
	public Vertex secondVertex;
	public int edgeWeight;
	
	public Edge() {
		
	}
	
	public Edge(Vertex firstVertex, Vertex secondVertex, int edgeWeight) {
		super();
		this.firstVertex = firstVertex;
		this.secondVertex = secondVertex;
		this.edgeWeight = edgeWeight;
	}
	
	
	
	public Vertex getFirstVertex() {
		return firstVertex;
	}
	public void setFirstVertex(Vertex firstVertex) {
		this.firstVertex = firstVertex;
	}
	
	public Vertex getSecondVertex() {
		return secondVertex;
	}
	public void setSecondVertex(Vertex secondVertex) {
		this.secondVertex = secondVertex;
	}
	
	public int getEdgeWeight() {
		return edgeWeight;
	}
	public void setEdgeWeight(int edgeWeight) {
		this.edgeWeight = edgeWeight;
	}
	
	
	
	public static Comparator<Edge> compareByEdgeWeight = new Comparator<Edge>() {
		
		public int compare(Edge edge1, Edge edge2) {
			int edgeWeight1 = edge1.getEdgeWeight();
			int edgeWeight2 = edge2.getEdgeWeight();
			return edgeWeight1 - edgeWeight2;
		}
		
	};
	
	public static Comparator<Edge> compareByFirstVertexID = new Comparator<Edge>() {
		
		public int compare(Edge edge1, Edge edge2) {
			int firstVertexIDEdge1 = edge1.getFirstVertex().getId();
			int firstVertexIDEdge2 = edge2.getFirstVertex().getId();
			return firstVertexIDEdge1 - firstVertexIDEdge2;
		}
		
	};
	
	public static Comparator<Edge> compareBySecondVertexID = new Comparator<Edge>() {
		
		public int compare(Edge edge1, Edge edge2) {
			int secondVertexIDEdge1 = edge1.getSecondVertex().getId();
			int secondVertexIDEdge2 = edge2.getSecondVertex().getId();
			return secondVertexIDEdge1 - secondVertexIDEdge2;
		}
		
	};
	
}
