class Solution {
public:
    int lastRemaining(int n) {
        int start=1, count=1;
        bool dir=true;
        
        while(n!=1)
        {
            if(dir==true) {
                start=start+count;
                dir=false;  
            }
            else {
                if(n%2==0)
                    dir=true;   
                else {
                    start=start+count;
                    dir=true;
                }
            }
            n=n/2;
            count=count*2;
        }
        return start;
    }
};