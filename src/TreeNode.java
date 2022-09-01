public class TreeNode {
    public static TreeNode Top;
    public TreeNode Left;
    public TreeNode Right;
    public char Character;
    public long Number;

    public static void PrintTree(){
        PrintTree(Top, "");
    }

    public static void PrintTree(TreeNode node, String s){
        if(node.Left != null){
            PrintTree(node.Left, s+"0");
            PrintTree(node.Right, s+"1");
        } else {
            System.out.println(node.Character + " " + s);
        }
    }
}
