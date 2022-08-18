/*
    LinkedList exercise from programming lesson at HTX Roskilde in 5. semester.
 */
public class LinkedList {
    private static LinkedList firstElement;
    private LinkedList nextElement;

    LinkedList() {
        if(firstElement == null) {
            firstElement = this;
        } else {
            nextElement = firstElement;
        }
    }

    public static void remove(LinkedList element)
    {
        LinkedList tmp = firstElement;
        while(tmp.nextElement != element) {
            tmp = tmp.nextElement;
            if (tmp == null) break;
            if (tmp.nextElement == null) break;
        }

        tmp.nextElement = element.nextElement;
    }

    public LinkedList getNextElement(LinkedList element) {
        return element.nextElement;
    }

    public LinkedList getFirstElement() {
        return firstElement;
    }
}
