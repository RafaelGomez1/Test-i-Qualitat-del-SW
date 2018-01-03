package entrega;

public class Node {
	public Node nodeleft;
	public Node noderight;
	public String name;
	
	public Node(String name) {
		this(name, null, null);
	}
	
	public Node(String name, Node nodeleft, Node noderight) {
        this.name = name;
        this.nodeleft = nodeleft;
        this.noderight = noderight;
    }	
}
