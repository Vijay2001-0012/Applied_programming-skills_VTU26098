class Solution {
    public int firstUniqChar(String s) {
        int[] n = new int[256];
        for(int i = 0;i < s.length();i++){
            n[s.charAt(i)]++;
        }
        for(int i = 0;i < s.length();i++){
            if(n[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
        
    }
}