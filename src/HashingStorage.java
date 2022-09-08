public class HashingStorage {

    public static void main(String[] args) {
        System.out.println("Running Basic Storage");
        BasicVersion();
        System.out.println("--------------------");
        System.out.println("Running Hashing Storage");
        HashingVersion();
    }

    public static void BasicVersion(){
        long Start, End;

        // fill list with 1 million numbers between 1 and 100001
        int[] List = new int[1000000];
        int Count = 0;
        for (int i = 0; i < List.length; i++) {
            List[i] = (int) (Math.random() * 100000 + 1);
        }

        Start = System.nanoTime();
        // find and print all numbers in the list equal to 117
        for (int j : List) {
            if (j == 117) Count++;
        }
        System.out.println("    Found " + Count + " numbers equal to 117");

        End = System.nanoTime();
        System.out.println("Time: " + (End - Start) + "ns");
        System.out.println("Time: " + (End - Start)/1000000d + "ms");
    }

    public static void HashingVersion(){
        long Start, End;

        // fill list with 1 million numbers between 1 and 100001
        int ListSize = 2000000;

        int[] List = new int[ListSize];
        int NumPos, Number = 0;

        for (int i = 0; i < 1000000; i++) {
            Number = (int) (Math.random() * 100000 + 1);
            NumPos = (int)(((long)Number * Number) % ListSize);

            // check if the position is already taken
            while (List[NumPos] != 0) {
                NumPos++;
            }
            List[NumPos] = Number;
        }

        Start = System.nanoTime();

        // find and print all numbers in the list equal to 117
        Number = 117;
        NumPos = (int)(((long)Number * Number) % ListSize);

        while (List[NumPos] != 0) {
            if (List[NumPos] == Number) System.out.println("    Found number " + Number);
            NumPos++;
        }
        End = System.nanoTime();
        System.out.println("Time: " + (End - Start) + "ns");
        System.out.println("Time: " + (End - Start)/1000000d + "ms");
    }
}
