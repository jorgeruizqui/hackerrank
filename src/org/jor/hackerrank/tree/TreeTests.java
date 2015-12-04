package org.jor.hackerrank.tree;

public class TreeTests {

	public static void main(String[] args) {
		TreeTests ts = new TreeTests();
		Node n = ts.new Node(3);
		n.left = ts.new Node(5);
		n.right = ts.new Node(2);
		n.left.left = ts.new Node(1);
		n.left.right = ts.new Node(4);
		n.right.left = ts.new Node(6);
		n.right.left.left = ts.new Node(7);

		System.out.println("\nPREORDER");
		Preorder(n);
		System.out.println("\nPOSTORDER");
		Postorder(n);
		System.out.println("\nINORDER");
		Inorder(n);
		System.out.println("\nHEIGHT");
		System.out.println(height(n));
		System.out.println("\nTOPVIEW");
		topView(n);
		System.out.println("\nLEVELORDER");
		levelOrder(n);
		System.out.println("\nINSERTNODE");
		Insert(n, 3);
		levelOrder(n);
		
		// Huffman Tree
		NodeHuffman nh = ts.new NodeHuffman('\0', 5);
		nh.left = ts.new NodeHuffman('\0', 2);
		nh.right = ts.new NodeHuffman('A', 1);
		nh.left.left = ts.new NodeHuffman('B', 1);
		nh.left.right = ts.new NodeHuffman('C', 1);
		System.out.println("\nDECODE HUFFMAN");
		decode3(nh, "1001011");
		
	}

	private class Node {
		int data;
		Node left;
		Node right;

		public Node() {

		}

		public Node(int d) {
			data = d;
		}
	}

	private static void Preorder(Node root) {
		System.out.print(String.valueOf(root.data) + " ");

		if (root.left != null) {
			Preorder(root.left);
		}
		if (root.right != null) {
			Preorder(root.right);
		}
	}

	private static void Postorder(Node root) {

		if (root.left != null) {
			Postorder(root.left);
		}
		if (root.right != null) {
			Postorder(root.right);
		}
		System.out.print(String.valueOf(root.data) + " ");
	}

	private static void Inorder(Node root) {

		if (root.left != null) {
			Inorder(root.left);
		}
		System.out.print(String.valueOf(root.data) + " ");
		if (root.right != null) {
			Inorder(root.right);
		}
	}

	private static int height(Node root) {
		int hl = 0;
		int hr = 0;

		if (root.left == null && root.right == null) {
			return 1;
		} else {
			if (root.left != null) {
				hl = height(root.left);
			}

			if (root.right != null) {
				hr = height(root.right);
			}
			return 1 + (hl > hr ? hl : hr);
		}
	}

	private static void topView(Node root) {
		topViewL(root.left);
		System.out.print(String.valueOf(root.data) + " ");
		topViewR(root.right);

	}

	private static void topViewL(Node root) {
		if (root.left != null) {
			topViewL(root.left);
		}
		System.out.print(String.valueOf(root.data) + " ");
	}

	private static void topViewR(Node root) {
		System.out.print(String.valueOf(root.data) + " ");
		if (root.right != null) {
			topViewR(root.right);
		}
	}

	private static void levelOrder(Node root) {

		java.util.LinkedList<Node> q = new java.util.LinkedList<Node>();

		if (root != null)
			q.add(root);

		while (q.peekFirst() != null) {
			Node current = q.poll();
			System.out.print(current.data + " ");
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);

		}
	}

	private static Node Insert(Node root, int value) {
		TreeTests ts = new TreeTests();

		if (root == null) {
			root = ts.new Node(value);
		} else {
			if (value < root.data) {
				if (root.left != null) {
					Insert(root.left, value);
				} else {
					root.left = ts.new Node();
					root.left.data = value;
				}
			} else {
				if (root.right != null) {
					Insert(root.right, value);
				} else {
					root.right = ts.new Node();
					root.right.data = value;
				}
			}
		}
		return root;
	}

	/**
	 * Decode HUFFMAN. // {x,5} // 0 / \ 1 //{x,2} {A,3} //0/ \1 //{B,1} {C,1}
	 * // //S="1001011" Solution print ABACA
	 */
	static NodeHuffman nhs;
	
	private static void decode(NodeHuffman root, String code) {
		char[] arr = code.toCharArray();
		while (code.length() > 0) {
			NodeHuffman current = root;
			char c = arr[0];
			boolean isLeaf = current.left == null && current.right == null;
			if (isLeaf) {
				System.out.print(current.data);
				decode(root, code.substring(1));
			} else {
				if (c == '0') {
					current = current.left;
				} else if (c == '1') {
					current = current.right;
				}
				decode(current, code.substring(1));
			}
			
		}
		
	}

	private class NodeHuffman {
		public int frequency; // the frequency of this tree
		public char data;
		public NodeHuffman left, right;
		
		public NodeHuffman(char d, int f) {
			this.frequency = f;
			this.data = d;
		}
	}

	private static void decode2(NodeHuffman root, String code) {
		char[] arr = code.toCharArray();
		NodeHuffman current = root;
		char c = arr[0];

		boolean isLeaf = current.left == null && current.right == null;
		if (!isLeaf) {
			if (c == '0') {
				current = current.left;
			} else if (c == '1') {
				current = current.right;
			}
			decode2(current, code.substring(1));
		} else {
			System.out.print(current.data);
		}
	}
	
	private static void decode3(NodeHuffman root, String code) {
		NodeHuffman current = root;

		while (code.length() > 0) {
			char c = code.charAt(0);
			code = code.substring(1);
			
			if (c == '0') {
				current = current.left;
			} else if (c == '1') {
				current = current.right;
			}
			
			boolean isLeaf = current != null && current.left == null && current.right == null;
			if (isLeaf) {
				System.out.print(current.data);
				current = root;
			}
		}
	}
	
	private static Node lca(Node root,int v1,int v2) {
		
		if ( (root.data <= v1 && root.data > v2) 
				|| (root.data <= v2 && root.data > v1) ) {
			return root;
		} else if (root.data <= v1 && root.data <= v2) {
			return lca(root.left, v1, v2);
		} else {
			return lca(root.right, v1, v2);
		}
		
	}
}
