class Solution {
    public boolean rotateString(String s, String goal) {

        // Rotations cannot change the length
        if (s.length() != goal.length()) {
            return false;
        }

        // Every rotation of s will appear in s + s
        String doubled = s + s;

        return doubled.contains(goal);
    }
}
