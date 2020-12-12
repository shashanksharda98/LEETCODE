/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int a = 1, b = n;
        while(a <= b){
            int mid = a + (b-a)/2;
            int c = guess(mid);
            if(c == -1) b = mid - 1;
            else if(c == 1) a = mid + 1;
            else return mid;
        }
        return -1;
    }
}