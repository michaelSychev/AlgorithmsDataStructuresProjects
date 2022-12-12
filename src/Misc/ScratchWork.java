package Misc;

public class ScratchWork
{
    public static int[] twoSum(int[] nums, int target) {
        int ar[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    ar[0] = i;
                    ar[1] = j;

                }

            }
        }

        return ar;
    }

    public static void main(String[] args) {
        int [] sample = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        for(int i :ScratchWork.twoSum(sample,target))
        {
            System.out.println(i);
        }
    }
}
