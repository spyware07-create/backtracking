import java.util.ArrayList;
import java.util.List;

public class bktrk2 {
    //subsets
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums , 0 , new ArrayList<>() , result);
        return result;
    }
    private void backtrack(int[] nums, int index , List<Integer> current, List<List<Integer>> result ){
        // Add a copy of the current list to the result
        result.add(new ArrayList<>(current));

        for(int i = index ; i < nums.length; i++){
            current.add(nums[i]); //choose
            backtrack(nums , i+1 , current , result); //explore
            current.removeLast();
        }
    }
    public static void main(String[] args){
        bktrk2 obj = new bktrk2();
        System.out.println(obj.subsets(new int[]{1, 3, 4, 23, 4, 5,}));
    }
}
/*
Here is a step-by-step trace of your code using the input array nums = [1, 2].
        ## Initial State

* result = []
        * current = []
        * index = 0

        ------------------------------
        ## Step-by-Step Execution Trace## 1. First Call: backtrack(nums, index=0, current=[], result)

* result.add(new ArrayList<>(current)) $\rightarrow$ result = [[]]
        * Loop starts (i = 0 to 1):
        * i = 0:
        * current.add(nums[0]) $\rightarrow$ current = [1]
        * Call backtrack(nums, index=1, current=[1], result)

## 2. Second Call: backtrack(nums, index=1, current=[1], result)

* result.add(new ArrayList<>(current)) $\rightarrow$ result = [[], [1]]
        * Loop starts (i = 1 to 1):
        * i = 1:
        * current.add(nums[1]) $\rightarrow$ current = [1, 2]
        * Call backtrack(nums, index=2, current=[1, 2], result)

## 3. Third Call: backtrack(nums, index=2, current=[1, 2], result)

* result.add(new ArrayList<>(current)) $\rightarrow$ result = [[], [1], [1, 2]]
        * Loop starts (i = 2 to 1):
        * i < nums.length ($2 < 2$) is false. The loop does not run.
* Return to Second Call.

        ## 4. Resume Second Call (i = 1)

* current.removeLast() $\rightarrow$ current = [1]
        * Loop ends for i = 1.
        * Return to First Call.

        ## 5. Resume First Call (i = 0)

* current.removeLast() $\rightarrow$ current = []
        * Loop continues (i = 1):
        * current.add(nums[1]) $\rightarrow$ current = [2]
        * Call backtrack(nums, index=2, current=[2], result)

## 6. Fourth Call: backtrack(nums, index=2, current=[2], result)

* result.add(new ArrayList<>(current)) $\rightarrow$ result = [[], [1], [1, 2], [2]]
        * Loop starts (i = 2 to 1):
        * $2 < 2$ is false. Loop does not run.
        * Return to First Call.

        ## 7. Resume First Call (i = 1)

* current.removeLast() $\rightarrow$ current = []
        * Loop ends for i = 1.
        * Return to main subsets method.

------------------------------
        ## Final Output
The method returns result: [[], [1], [1, 2], [2]].
If you would like, I can:

        * Show you the recursion tree diagram for this execution.
* Explain how to modify this to handle duplicate numbers in the input array.
        * Compare the performance of this approach against the iterative bitmasking method.


*/