public class CharList {
    private TreeNode Node;
    private CharList Next;
    private static CharList First;

    CharList(char c, long n){
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
                if(low1.Node.Number < low2.Node.Number){
                    low2 = temp;
                }
                else{
                    low1 = temp;
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

    public static void removeElement(CharList element){
        CharList temp = First;
        while(temp.Next != element){
            temp = temp.Next;
        }
        temp.Next = element.Next;
    }

    public static void GrowTree(){
        while(First.Next != null){
            CombineLeastCommon();
        }
        TreeNode.Top = First.Node;
        First = null;
    }

    public static void main(String[] args)
    {
        new CharList('a', 1);
        new CharList('b', 20);
        new CharList('c', 30);
        new CharList('d', 40);
        new CharList('e', 50);
        new CharList('f', 69);
        new CharList('g', 70);
        new CharList('h', 80);
        new CharList('i', 90);
        new CharList('j', 100);
        new CharList('k', 110);
        new CharList('l', 120);
        new CharList('m', 130);
        new CharList('n', 140);
        new CharList('o', 150);
        new CharList('p', 160);
        new CharList('q', 170);
        new CharList('r', 180);
        new CharList('s', 190);
        new CharList('t', 200);
        new CharList('u', 210);
        new CharList('v', 220);
        new CharList('w', 230);
        new CharList('x', 240);
        new CharList('y', 250);
        new CharList('z', 260);

        CharList.GrowTree();
    }
}
