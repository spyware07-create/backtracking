import static java.util.Collections.swap;

public class bktrk1 {
    //Find all possible rearrangements of a string (e.g., "ABC"). : permutations
    private String swap(String str , int j , int i ) {
        char[] ch = str.toCharArray();
        char c = ch[j];
        ch[j] = ch[i];
        ch[i] = c;
        return new String(ch);
    }
    public void findPermutations(String str, int left , int right){
        if(left == right) System.out.println(str);
        else{
            for(int i = left ; i<= right ;i++){
                str = swap( str , left ,i);
                findPermutations(str , left+1 , right );
                str = swap(str , left , i); //backtrack
            }
        }
    }
    public static void main(String[] args){
        bktrk1 obj = new bktrk1();
        obj.findPermutations("ADITYA",0,5);
    }
}

/*
When you call findPermutations("ABC", 0, 2):
Level 1: left = 0 (Fixing the 1st character)
    i = 0: Swaps index 0 with 0 ("ABC" stays "ABC").
        Calls findPermutations("ABC", 1, 2).
            Level 2: left = 1 (Fixing the 2nd character)
                i = 1: Swaps index 1 with 1 ("ABC" stays "ABC").
                    Calls findPermutations("ABC", 2, 2).
                    Level 3: left = 2, right = 2. Base case hit! Prints "ABC".
                i = 2: Swaps index 1 with 2 ("ABC" becomes "ACB").
                    Calls findPermutations("ACB", 2, 2).
                    Level 3: left = 2, right = 2. Base case hit! Prints "ACB".
                    Backtracks: Swaps index 1 and 2 back ("ACB" becomes "ABC").
    i = 1: Swaps index 0 with 1 ("ABC" becomes "BAC").
        Calls findPermutations("BAC", 1, 2).
            Level 2: left = 1
                i = 1: Swaps index 1 with 1 ("BAC" stays "BAC").
                    Base case prints "BAC".
                i = 2: Swaps index 1 with 2 ("BAC" becomes "BCA").
                    Base case prints "BCA".
                    Backtracks back to "BAC".
        Backtracks: Swaps index 0 and 1 back ("BAC" becomes "ABC").
    i = 2: Swaps index 0 with 2 ("ABC" becomes "CBA")
        Calls findPermutations("CBA", 1, 2).
            Level 2: left = 1
                i = 1: Base case prints "CBA".
                i = 2: Swaps index 1 with 2, base case prints "CAB".
        Backtracks: Restores original string to "ABC".
 */