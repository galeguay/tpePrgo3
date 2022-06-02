public class TreeWithNode {

	private TreeNode root;

	public TreeWithNode() {
		this.root = null;
	}

	public void add(String genre) {
		if (this.root == null)
			this.root = new TreeNode(genre);
		else
			this.add(this.root, genre);
	}

	private void add(TreeNode actual, String genre) {
		if (actual.getGenre().compareTo(genre) > 0) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(genre);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(), genre);
			}
		} else if (actual.getGenre().compareTo(genre) < 0) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(genre);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), genre);
			}
		}
	}

	public boolean hasGenre(String genre) {
		return hasGenre(this.root, genre);
	}

	private boolean hasGenre(TreeNode actual, String genre) {
		if (actual != null) {
			if (actual.getGenre().compareTo(genre) < 0) {
				if (actual.getRight() == null) {
					return false;
				} else {
					return hasGenre(actual.getRight(), genre);
				}
			}
			if (actual.getGenre().compareTo(genre) > 0) {
				if (actual.getLeft() == null) {
					return false;
				} else {
					return hasGenre(actual.getLeft(), genre);
				}
			} else
				return true;
		} else
			return false;
	}

	public TreeNode getGenre(String genre) {
		return getGenre(this.root, genre);
	}

	private TreeNode getGenre(TreeNode actual, String genre) {
		if (actual.getGenre().compareTo(genre) < 0) {
			if (actual.getRight() == null) {
				return null;
			} else {
				return getGenre(actual.getRight(), genre);
			}
		}
		if (actual.getGenre().compareTo(genre) > 0) {
			if (actual.getLeft() == null) {
				return null;
			} else {
				return getGenre(actual.getLeft(), genre);
			}
		} else
			return actual;
	}

	public void printInOrder() {
		printInOrder(this.root);
	}

	public void printPosOrder() {
		printPosOrder(this.root);
	}

	public void printPreOrder() {
		printPreOrder(this.root);
	}

	private void printPosOrder(TreeNode node) {
		if (node == null) {
			// System.out.println("- ");
			return;
		}
		printPosOrder(node.getLeft());
		printPosOrder(node.getRight());
		System.out.print(node.getGenre() + " ");
	}

	private void printPreOrder(TreeNode node) {
		if (node == null) {
			// System.out.println("- ");
			return;
		}
		System.out.print(node.getGenre() + " ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}

	private void printInOrder(TreeNode node) {
		if (node == null) {
			// System.out.println("- ");
			return;
		}
		printInOrder(node.getLeft());
		System.out.print(node.getGenre() + " ");
		printInOrder(node.getRight());
	}

}
