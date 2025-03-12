
class Minimum_SubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        int l =0;
        int ans = Integer.MAX_VALUE;
        int temp = 0;
        for(int r=0;r<arr.length;r++){
            temp += arr[r];
            while(temp>=target){
                ans = Math.min(ans,r-l+1);
                temp -= arr[l];
                l++;
            }
        }
        System.out.println(ans);
    }
