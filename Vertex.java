package main;

public class Vertex {
	
	public int id;
	public Vertex parent;
	public int size;
	
	public Vertex() {
		this.parent = this;
	}
	
	public Vertex(int id, int size) {
		this.id = id;
		this.parent = this;
		this.size = size;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Vertex getParent() {
		return parent;
	}
	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
