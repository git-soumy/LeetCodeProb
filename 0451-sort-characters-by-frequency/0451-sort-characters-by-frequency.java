class Solution {

    public String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        List<Character>[] bucket = new ArrayList[s.length()+1];

        for(Map.Entry<Character,Integer> entry : map.entrySet()){

            int freq = entry.getValue();

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(entry.getKey());
        }

        StringBuilder ans = new StringBuilder();

        for(int i=bucket.length-1;i>=0;i--){

            if(bucket[i] != null){

                for(char c : bucket[i]){

                    for(int j=0;j<i;j++){
                        ans.append(c);
                    }

                }

            }

        }

        return ans.toString();
    }
}