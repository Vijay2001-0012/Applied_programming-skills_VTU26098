class Solution {
    public int[] asteroidCollision(int[] a) {
    Stack<Integer> s= new Stack<>();
     for(int i=0; i<a.length; i++){
        if(a[i]>0) s.push(a[i]);
        else{
        while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(a[i])){
            s.pop();
        }
        if(!s.isEmpty() && s.peek()==Math.abs(a[i])) s.pop();
        else if( s.isEmpty() || s.peek()<0) s.push(a[i]);
        } 
     }
     int ans[]= new int[s.size()];
     int i=s.size()-1;
     while(!s.isEmpty()){
        ans[i--]=s.pop();
     }
        return ans;
    }
}