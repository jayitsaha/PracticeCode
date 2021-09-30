class Solution{
public:
void merge(vector<int>& nums1, int m, const vector<int>& nums2, int n)
    {
        if(n==0)return;
        int i=-1 ,j=0;
        for(i = 0,j = 0; i<m and j<n ;){
            cout<<nums1[i]<<" "<<nums2[j]<<endl;
            if(nums2[j]<nums1[i]){
               nums1.insert(nums1.begin()+i,nums2[j++]);
               nums1.pop_back();
                i--;
             }
            i++;
        }            
        for( ;j<n;){
             cout<<nums1[i]<<" "<<nums2[j]<<endl;
            nums1.push_back(nums2[j++]);   
            nums1.erase(nums1.begin() + ++i);
         }
    }
};

