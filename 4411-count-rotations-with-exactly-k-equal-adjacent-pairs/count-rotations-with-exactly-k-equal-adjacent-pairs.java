class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
         int ttl = 0;
        for(int i =0; i<n;i++){
            int next = (i+1) %n;
            if(s.charAt(i)==s.charAt(next)) ttl++;
        }
        if(k==ttl-1) return ttl;
        if(k==ttl) return n-ttl;
        return 0;
    }
}