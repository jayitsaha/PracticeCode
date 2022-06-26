class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s); 
        String rev="";
        String b = sb.toString();
        b = b.replaceAll("[^a-zA-Z0-9]", "");
        b= b.trim();
        b= b.toLowerCase();
        char ch[]=b.toCharArray();
        for(int i=ch.length-1;i>=0;i--){  
        rev+=ch[i];  
    }  
        if(rev.equals(b) || b.equals(" ") ||rev.length() == 1)
            return true;
        else
            return false;
    }
}