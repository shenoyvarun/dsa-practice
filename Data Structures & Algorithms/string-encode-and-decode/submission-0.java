class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            String len = "";
            while (i < str.length() && str.charAt(i) != '#') {
                len += str.charAt(i);
                i++;
            }

            res.add(str.substring(i + 1, Integer.parseInt(len) + i + 1));

            i = i + Integer.parseInt(len) + 1;
        }

        return res;
    }
}
