package Misc;

import java.util.HashMap;

public class LeetCode
{
    private int[] m_nums;
    private int m_target;
    public LeetCode(int[] nums, int target)
    {
        m_nums = nums;
        m_target = target;
    }
    //pre:Takes an array of ints and an target number
    //post:returns the two indices of the elements that add up to target number
    public int[] twoSums(int[] nums, int target)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0; i<nums.length;i++)
       {
           int tar = target - nums[i];
           if(map.containsKey(tar))
           {
               return new int[]{map.get(target-nums[i]),i};
           }else{
               map.put(nums[i],i);
           }

       }
        return null;
    }

   public static void main(String args[])
   {
        int [] sample = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        LeetCode obj1 = new LeetCode(sample,target);
        for(int i:obj1.twoSums(sample,target))
        {
            System.out.println(i);
        }
        ;
   }
}

