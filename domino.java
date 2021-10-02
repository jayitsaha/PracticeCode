private static final int MODULO = (int) Math.pow(10, 9) + 7;
public int numTilings(int n) {
    if(n == 1) return 1;
    if(n == 2) return 2;
    long[] dp1 = new long[n+1];
    
    dp1[0] = 1;
    dp1[1] = 1;
    dp1[2] = 2;
    
    for(int i = 3; i < dp1.length; i++){
        dp1[i] = (dp1[i-1] * 2 + dp1[i-3])%MODULO;  
    }
    return (int)dp1[n];
}
