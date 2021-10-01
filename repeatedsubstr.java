class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s.repeat(2);
        if (str.indexOf(s, 1) < s.length())
            return true;
        return false;
    }
}
