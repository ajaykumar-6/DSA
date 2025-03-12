import java.util.*;
class Solution {
    public static boolean anagram(HashMap<Character,Integer> hma,HashMap<Character,Integer> hmb){
      if(hma.size() != hmb.size()){
        return false;
      } 
      for(char key:hma.keySet()){
        if(!hmb.containsKey(key)){
            return false;
        }
        int a = hma.get(key);
        int b = hmb.get(key);
        if(a!= b){
            return false;
        }
      } 
      return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hms = new HashMap<>();
        HashMap<Character,Integer> hmp = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            hmp.put(ch,hmp.getOrDefault(ch,0)+1);
        }
        int k = p.length();
        int n = s.length();
        int l = 0;
        List<Integer> li = new ArrayList<>();
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            hms.put(ch,hms.getOrDefault(ch,0)+1);
            if(r-l==k){
                char chl = s.charAt(l);
                hms.put(chl,hms.get(chl)-1);
                if(hms.get(chl)==0){
                    hms.remove(chl);
                }
                l++;
            }
            if(r-l+1 == k){
                boolean valid = anagram(hms,hmp);
                if(valid){
                    li.add(l);
                }
            }
        }
        return li;
    }
public static void main(String args[]){
Scanner k = new Scanner(System.in);
String s = k.nextLine();
String p = k.nextLine();
k.close();
Solution x = new Solution();
System.out.println(x.findAnagrams(s,p));
}
}