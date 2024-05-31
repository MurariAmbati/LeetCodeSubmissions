// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int absences = 0;
        int consecutiveLates = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absences++;
                consecutiveLates = 0; // Reset consecutiveLates when there's an absence
            } else if (c == 'L') {
                consecutiveLates++;
            } else {
                consecutiveLates = 0; // Reset consecutiveLates when the student is present
            }
            
            if (absences >= 2 || consecutiveLates >= 3) {
                return false;
            }
        }
        
        return true;
    }
}
