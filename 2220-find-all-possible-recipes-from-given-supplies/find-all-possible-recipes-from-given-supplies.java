class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> st = new HashSet();
        for(int i = 0; i<supplies.length; i++){
            st.add(supplies[i]);
        }
        boolean[] cooked = new boolean[n];
        int count = n;
        while(count-->0){
            for(int j = 0; j< n; j++){
                if(cooked[j]){
                    continue;
                }
                boolean banpayega = true;
                for(int k = 0; k<ingredients.get(j).size(); k++){
                    if(!st.contains(ingredients.get(j).get(k))){
                        banpayega = false;
                        break;
                    }
                }
                 if(banpayega){
                    st.add(recipes[j]);
                    result.add(recipes[j]);
                    cooked[j] = true;
                }
            }
        }
        return result;
    }
}