class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int x=0;
        for(int i=0;i<nums.length;i++){
            x = Math.abs(nums[i])-1;
            if(nums[x]>0){
                nums[x] = -nums[x];
            }else{
                ans.add(x+1);
            }
        }
        return ans;
    }
}