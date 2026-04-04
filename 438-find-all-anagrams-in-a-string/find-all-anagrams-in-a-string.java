class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        char[] ch = s.toCharArray();
        char[] c = p.toCharArray();
        for(char n:c){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int i=0;
        int j=0;
        int k=p.length();
        int count=map.size();

        while(j<ch.length){
            if(map.containsKey(ch[j])){
                map.put(ch[j],map.get(ch[j]) - 1);
                if(map.get(ch[j])==0){
                    count--;
                }
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(count==0){
                    list.add(i);
                }
                if(map.containsKey(ch[i])){
                    map.put(ch[i],map.getOrDefault(ch[i],0)+1);
                    if(map.get(ch[i]) == 1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return list;
    }
}