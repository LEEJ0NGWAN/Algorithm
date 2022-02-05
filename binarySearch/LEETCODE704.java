class Solution {
    
    public int search(int[] nums, int target) {

        int ans = -1;
        
        int left = 0;
        int right = nums.length-1;
        int pivot = (left + right) / 2;
        
        if (target < nums[left] || nums[right] < target) return ans;
        
        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        
        while (left <= right) {
            
            if (nums[pivot] == target) {
                
                ans = pivot;
                break;
            }
            
            pivot = nums[pivot] < target?
                ((left = pivot + 1) + right) / 2:
                (left + (right = pivot - 1)) / 2;
        }
        
        return ans;
    }
}