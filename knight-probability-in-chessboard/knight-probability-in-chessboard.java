class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        
        
            double current[][] = new double[n][n];
            double next[][] = new double[n][n];
    
            current[row][column] = 1;

            for(int m=0; m<k; m++){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        if(current[i][j] != 0) {
                        int ni = 0;
                        int nj = 0;

                        ni = i-2;
                        nj = j+1;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i-1;
                        nj = j+2;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i+1;
                        nj = j+2;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i+2;
                        nj = j+1;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i+2;
                        nj = j-1;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i+1;
                        nj = j-2;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i-1;
                        nj = j-2;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }
                        ni = i-2;
                        nj = j-1;
                        if(isValid(ni, nj, n)){
                            next[ni][nj] += current[i][j]/8;
                        }

                        }


                    }
                }

                current = next;
                next = new double[n][n];
            }

            double sum = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    sum += current[i][j];
                }
            }

            return sum;


        }

        private boolean isValid(int ni, int nj, int n) {
            if(ni >= 0 && nj >=0 && ni < n && nj < n) {
                return true;
            }
            return false;  
        }
    
}