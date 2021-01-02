/**
 * Debugger:
 * n =    100100
 * n-1 =  100011
 * &      100111
 * 
 * n =  (0)000000
 * n-1 =(1)111111
 * &    (0)000000
 */
public class Debugger {
    //check if n is 0
    public static boolean isZero(int n){
        return (n & (n - 1)) == 0;
    }
}