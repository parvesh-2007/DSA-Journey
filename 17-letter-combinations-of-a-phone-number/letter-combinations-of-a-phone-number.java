class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keypad = new String[10];
        keypad[2] = "abc";
        keypad[3] = "def";
        keypad[4] = "ghi";
        keypad[5] = "jkl";
        keypad[6] = "mno";
        keypad[7] = "pqrs";
        keypad[8] = "tuv";
        keypad[9] = "wxyz";
        List<String> ans = new ArrayList<String>();
        helper(keypad, digits, "", 0, ans, digits.length());
        return ans;
    }
    public static void helper(String[]keypad, String digits, String curr,int i, List<String> ans, int n){
        if(i==n){
            ans.add(curr);
            return;
        }
        int num = digits.charAt(i)-'0';
        for(int j = 0; j<keypad[num].length(); j++){
            char ch = keypad[num].charAt(j);
            helper(keypad, digits, curr+ch, i+1, ans, n);
        
        }
    }
}