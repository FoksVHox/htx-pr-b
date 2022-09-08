public class CharList {
    public TreeNode Node;
    private CharList Next;
    private static CharList First;

    CharList(char c, long n){
        if(First == null){
            First = this;
        }else {
            Next = First;
            First = this;
        }
        Node = new TreeNode();
        this.Node.Character = c;
        this.Node.Number = n;
    }

    // function for combing the two least common elements into a new element
    private static void CombineLeastCommon() {
        //if (firstElement.nextElement == null) return;  //can't combine with only one element
        CharList low1 = First;
        CharList low2 = First.Next;
        CharList tempElement = First.Next.Next;
        //loop through the list
        while (tempElement != null) {
            //compare node values
            if (tempElement.Node.Number < low1.Node.Number || tempElement.Node.Number < low2.Node.Number) {
                if (low1.Node.Number < low2.Node.Number) {
                    low2 = tempElement;
                } else {
                    low1 = tempElement;
                }
            }
            //step down the list
            tempElement = tempElement.Next;
        }
        //Combine into a new TreeNode
        TreeNode tempNode = new TreeNode();
        tempNode.Left = low1.Node;
        tempNode.Right = low2.Node;
        tempNode.Number = low1.Node.Number + low2.Node.Number;
        //insert into CharList (more or less)
        low1.Node = tempNode;
        removeElement(low2);
    }

    public static void removeElement(CharList element ) {
        //special case for firstElement = element
        if (element == First) First = First.Next;
        //all the rest
        CharList tempElement = First;
        while (tempElement.Next != element) {
            //move down the list
            tempElement = tempElement.Next;
            //break if we reached the end
            if (tempElement == null) return;
        }
        //if we make it here, we must have found the element, and its tempElement.nextElement - Delete it!
        tempElement.Next = element.Next;
    }

    public static void removeNextElement(CharList element) {
        if (element.Next != null) element.Next = element.Next.Next;
    }

    public static CharList getFirstElement() {
        return First;
    }

    public CharList getNextElement() {
        return Next;
    }

    public static void GrowTree(){
        System.out.println("Growing Tree");
        while(First.Next != null){
            CombineLeastCommon();
        }
        TreeNode.Top = First.Node;
        First = null;
    }

    public static void main(String[] args) {

        byte[] bytes = FileReader.ReadFile("C:\\temp\\lort.txt");
        if(bytes == null) System.exit(0);
        int[] nrBytes = new int[256];

        int len = bytes.length;

        for (byte aByte : bytes) {
            nrBytes[aByte + 128]++;
        }

        for (int i = 0; i<256; i++){
            if(nrBytes[i] != 0){
                new CharList((char)(i-128), nrBytes[i]);
            }
        }
        System.out.println("4");

        //grow the tree
        CharList.GrowTree();
        //print the tree
        TreeNode.PrintTree();
    }
}
