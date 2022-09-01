public class CharList {
    public TreeNode Node;
    private CharList Next;
    private static CharList First;

    CharList(char c, long n){
        if (First != null) {
            Next = First;
        }
        First = this;
        Node = new TreeNode();
        this.Node.Character = c;
        this.Node.Number = n;
    }

    // function for combing the two least common elements into a new element
    private static void CombineLeastCommon(){
        CharList low1 = First;
        CharList low2 = First.Next;
        CharList temp = First.Next.Next;

        // loop through the list until you find the two least common elements
        while(temp != null){
            if(temp.Node.Number < low1.Node.Number || temp.Node.Number < low2.Node.Number){
                if(low1.Node.Number > low2.Node.Number){
                    low1 = temp;
                    return;
                }
                else{
                    low2 = temp;
                }
            }
            temp = temp.Next;
        }
        // create a new element with the two least common elements
        TreeNode tempNode = new TreeNode();
        tempNode.Left = low1.Node;
        tempNode.Right = low2.Node;
        tempNode.Number = low1.Node.Number + low2.Node.Number;

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
        while(First.Next != null){
            CombineLeastCommon();
        }
        TreeNode.Top = First.Node;
        First = null;
    }

    public static void main(String[] args) {

        byte[] bytes = FileReader.ReadFile("C:\\devlist.txt");
        int[] nrBytes = new int[256];

        assert bytes != null;
        int len = bytes.length;

        for (int i = 0; i < len; i++) {
            nrBytes[bytes[i]+128]++;
        }



        //grow the tree
        CharList.GrowTree();
        //print the tree
        TreeNode.PrintTree();
    }
}
