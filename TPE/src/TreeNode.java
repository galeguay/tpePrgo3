import java.util.LinkedList;

public class TreeNode {
    private String genres;
    private TreeNode left;
    private TreeNode right;
    private LinkedList<Integer> bookIndexes;

    public TreeNode(String genres) {
        this.genres = genres;
        this.left = null;
        this.right = null;
        this.bookIndexes = new LinkedList<>();
    }

    public TreeNode(String genres, TreeNode left, TreeNode right) {
        this.genres = genres;
        this.left = left;
        this.right = right;
        this.bookIndexes = new LinkedList<>();
    }

    public String getGenre() {
        return genres;
    }

    public void setGenre(String genres) {
        this.genres = genres;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public LinkedList getbookIndexes() {
        return bookIndexes;
    }

    public void setbookIndexes(LinkedList bookIndexes) {
        this.bookIndexes = bookIndexes;
    }

    public boolean hasIndexBook(int b) {
        return bookIndexes.contains(b);
    }

    public void addBook(int indexBook) {
        bookIndexes.add(indexBook);
    }

}
