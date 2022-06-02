import java.util.ArrayList;

public class TreeWithNode{

	private TreeNode root;


	public TreeWithNode(){
		this.root = null;
	}


	public void add(String genre) {
		if (this.root == null)
			this.root = new TreeNode(genre);
		else
			this.add(this.root, genre);
	}
/* 
	private void add(TreeNode actual, String genre) {
		if(actual != null){
			if(actual.getGenre().compareTo(genre) == -1)
				add(actual.getRight(), genre);
			else if(actual.getGenre().compareTo(genre) == 1)
				add(actual.getLeft(), genre);
		}else{
			TreeNode temp = new TreeNode(genre);
			actual = temp;
		}
	}
*/
	private void add(TreeNode actual, String genre) {
		if(actual.getGenre().compareTo(genre) > 0){
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(genre);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),genre);
			}
		} else if(actual.getGenre().compareTo(genre) < 0){
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(genre);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),genre);
			}
		}
	}


	public boolean hasGenre(String genre) {
		return hasGenre(this.root, genre);
	}

	private boolean hasGenre(TreeNode actual, String genre) {
		if(actual != null){
			if(actual.getGenre().compareTo(genre) < 0) {
				if(actual.getRight() == null) {
					return false;
				}else {
					return hasGenre(actual.getRight(), genre);
				}
			}
			if(actual.getGenre().compareTo(genre) > 0) {
				if(actual.getLeft() == null) {
					return false;
				}else {
					return hasGenre(actual.getLeft(), genre);
				}
			}
			else return true;
		}else return false;
	}

    public TreeNode getGenre(String genre){
        return getGenre(this.root, genre);
    }

	private TreeNode getGenre(TreeNode actual, String genre) {
		if(actual.getGenre().compareTo(genre) == -1) {
			if(actual.getRight() == null) {
				return null;
			}else {
				return getGenre(actual.getRight(), genre);
			}
		}
		if(actual.getGenre().compareTo(genre) == 1) {
			if(actual.getLeft() == null) {
				return null;
			}else {
				return getGenre(actual.getLeft(), genre);
			}
		}
		else return actual;
	}

	private boolean isEmpty() {
		if(this.root.getLeft() == null && this.root.getRight() == null) {
			return true;
		}else {
			return false;
		}
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
		if(node == null ) {
			//System.out.println("- ");
			return;			
		}
		printPosOrder(node.getLeft());
		printPosOrder(node.getRight());
		System.out.print(node.getGenre() + " ");
	}
	
	private void printPreOrder(TreeNode node) {
		if (node == null ) {
			//System.out.println("- ");
			return;
		}
		System.out.print(node.getGenre() + " ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}
	
	private void printInOrder(TreeNode node) {
		if(node == null) {
			//System.out.println("- ");
			return;			
		}
		printInOrder(node.getLeft());
		System.out.print(node.getGenre() + " ");
		printInOrder(node.getRight());
	}


/*
	public boolean delete(int i) {
		if (arbolgenre.getRoot() == i) {
			if (this.root.esHoja()) {
				this.root = null;
				return true;
			}
			else if(root.getRight() == null) {
				this.root = root.getLeft();
			}
			else if(root.getLeft() == null) {
				this.root = root.getRight();
			}
			else {
				TreeNode mayor = maxNode(root.getLeft());
				root.setValue(mayor.getValue());
				return delete(root, mayor.getValue());
			}
		}
		return delete(this.root, i);
	}
	
	private boolean delete(TreeNode actual, int i) {
		if(actual.getValue() < i) {
			if(actual.getRight() == null) {
				return false;
			}else if (actual.getRight().getValue() != i) {
				return delete(actual.getRight(), i);
			}
			//si entra a este else es xq el valor de la DERECHA, es el valor a eliminar
			else {//si es hoja
				if (actual.getRight().esHoja()) {
					actual.setRight(null);
					return true;
				}//si tiene 1 hijo
				if(actual.getRight().getRight() == null) {
					actual.setRight(actual.getRight().getLeft());
					return true;
				}
				else if(actual.getRight().getLeft() == null) {
					actual.setRight(actual.getRight().getRight());
					return true;
				}//si tiene 2 hijos
				else {
					TreeNode mayor = maxNode(actual.getRight().getLeft());
					actual.getRight().setValue(mayor.getValue());
					return delete(actual.getRight(), mayor.getValue());
				}
			}
		}
		else  {
		 if(actual.getLeft() == null) {
				return false;
			}else if (actual.getLeft().getValue() != i) {
				return delete(actual.getLeft(), i);
			}//si entra a este else es xq el valor de la IZQUIERDA, es el valor a eliminar
			else {//si es hoja
				if (actual.getLeft().esHoja()) {
					actual.setLeft(null);
					return true;
				}//si tiene 1 hijo
				if(actual.getLeft().getRight() == null) {
					actual.setLeft(actual.getLeft().getLeft());
					return true;
				}
				else if(actual.getLeft().getLeft() == null) {
					actual.setLeft(actual.getLeft().getRight());
					return true;
				}// si tiene 2 hijos
				else {
					TreeNode mayor = maxNode(actual.getLeft().getLeft());
					actual.getLeft().setValue(mayor.getValue());
					return delete(actual.getLeft(), mayor.getValue());
				}
			}
		}
	}
	
	public int getHeight() {
		return getHeight(this.root) - 1;
	}
	
	private int getHeight(TreeNode actual) {
		if(actual == null){
			return 0;
		}else {
			int rightHeight = getHeight(actual.getRight()); 
			int leftHeight = getHeight(actual.getLeft());
			int height;
			height = Math.max(rightHeight, leftHeight) + 1;
			return height;
		}
	}
	
	public int getLongestBranch() {
		return getLongestBranch(this.root);
	}
	
	private int getLongestBranch(TreeNode actual) {
		return this.getHeight() + 1;
	}
	
	public int maxValue() {
		return this.maxValue(this.root);
	}
	
	private int maxValue(TreeNode actual){
		int resultado = actual.getValue();
		if(actual.getRight() != null) {
			return maxValue(actual.getRight());
		}
		else {
			return resultado;
		}
			
	}
	
	private TreeNode maxNode(TreeNode actual){
		if(actual.getRight() != null) {
			return maxNode(actual.getRight());
		}
		else {
			return actual;
		}
	}
	
	private TreeNode minNode(TreeNode actual) {
		if(actual.getLeft() != null) {
			return minNode(actual.getLeft());
		}
		else {
			return actual;
		}
	}

	
	public void getElementsAtLevel(int nivel) {
		ArrayList<Integer> list = new ArrayList<>();
		getElementsAtLevel(nivel, this.root, list);
		for (Integer integer : list) {
			System.out.print(integer + " - ");
		}
	}
	
	private void getElementsAtLevel(int nivel, TreeNode actual, ArrayList<Integer> list){
		if(actual == null) return;
		if(nivel == 0) {
			//System.out.println(actual.getValue());
			list.add(actual.getValue());
		}
		else {
			if(actual.getRight() != null) {
				
				getElementsAtLevel(nivel -1, actual.getRight(), list);
			}
			if (actual.getLeft() != null) {
				
				getElementsAtLevel(nivel -1, actual.getLeft(), list);
			}
		}
	}
	
	public ArrayList<Integer> getFrontera() {
		ArrayList<Integer> frontera = new ArrayList<Integer>();
		return getFrontera(this.root, frontera);
	}
	
	private ArrayList<Integer> getFrontera(TreeNode actual, ArrayList<Integer> frontera) {
		if(actual == null) {
			return frontera;
		}
		if (actual.getLeft() == null && actual.getRight() == null) {
			frontera.add(actual.getValue());
		}
		getFrontera(actual.getLeft(), frontera);
		getFrontera(actual.getRight(), frontera);
		return frontera;
	}
	*/
}
