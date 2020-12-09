class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, hi = matrix.length - 1, row = -1;
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        while(low <= hi){
            int mid = (hi+low)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
                return helper(matrix[mid], target);
            }else if(target < matrix[mid][0]) hi = mid - 1;
            else if(target > matrix[mid][matrix[mid].length - 1]) low = mid+1;
        }
        return false;
    }
    
    public boolean helper(int[] arr, int target){
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] < target)lo = mid + 1;
            else if(arr[mid] > target) hi = mid - 1;
            else return true;
        }
        
        
        return false;
    }
}