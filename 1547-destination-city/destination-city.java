class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> fromto = new HashMap<>();
        HashMap<String, String> tofrom = new HashMap<>();

        for (List<String> path : paths) {
        String from = path.get(0);
        String to = path.get(1);
        fromto.put(from, to);
        tofrom.put(to, from);
        }
        for(String city : tofrom.keySet()){
            if(!fromto.containsKey(city)){
                return city;
            }
        }
        return "";
    }


}