package constructorTest;


class Tree {
    int leavesCount;
    String treeName;
    Tree (int leaves){
        this.leavesCount = leaves;
        System.out.println("int constructor");
    }
    Tree (String treeName, int leaves){
        this(leaves);
        System.out.println("(String, int) constructor");
    }
    Tree (String treeName){
        this.treeName = treeName;
        System.out.println("String constructor");
    }
    Tree () {
        this("huge tree", 50000);
        System.out.println("constructor without parameters");
    }
    void printLeavesCount(){
        System.out.println("leavesCount = " + leavesCount + " treeName = " + treeName);
    }
    public static void main (String[] args) {
        Tree tree = new Tree();
        tree.printLeavesCount();
    }
}