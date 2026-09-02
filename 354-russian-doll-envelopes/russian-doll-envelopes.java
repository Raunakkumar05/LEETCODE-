// class Pair implements Comparable<Pair>{
//     int le;
//     int hi;
//     Pair(int le, int hi){
//         this.le = le;
//         this.hi = hi;
//     }
//     public int compareTo(Pair s){
//         if(this.le == s.le){
//             return Integer.compare(this.hi, s.hi);
//         }
//         return Integer.compare(this.le,s.le);
//     }
// }

class Solution {
    public int maxEnvelopes(int[][] nums) {
    Arrays.sort(nums, (a,b) -> (a[0] != b[0]) ? Integer.compare(a[0],b[0]) : Integer.compare(b[1],a[1]) );
    int n = nums.length;
    int lis[]  = new int[n];
    for(int i =0; i<n; i++){
        lis[i] = nums[i][1];
    }
    ArrayList<Integer> ans = new ArrayList<>();
    for(int x : lis){
        if(ans.isEmpty() || x>ans.get(ans.size()-1) ){
            ans.add(x);
        }
        else {
            int i=0;
            while(x>ans.get(i)){
                i++;
            }
            ans.set(i,x);
        }
    }
    return ans.size();

        }
    }

//         PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
//         int row = nums.length;
//         int col = nums[0].length;
//         for(int i =0;i<row-1 ; i++){
//             int first = nums[i][0];
//             int secound = nums[i][1];
//          pq.add(new Pair(first, secound));
//         }   
//         int count = 1;
//          Pair top = pq.remove();
//         while(!pq.isEmpty()){
//             int len   = top.le;
//             int height = top.hi;
//             if(!pq.isEmpty() && (len>pq.peek().le && height>pq.peek().hi) ){
//                 top = pq.remove();
//                 count++;
//             }
//             else pq.remove();
//         } 
//         return count;
//     }
// }