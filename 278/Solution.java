/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int a = 1, b = n;
            while(a <= b){
                int mid = a+ (b-a)/2;
                if(isBadVersion(mid)){
                    if(isBadVersion(mid-1)) b = mid -1;
                    else return mid;
                } 
                else a = mid + 1;
            }
            
            return a;
        }
    }