// https://leetcode.com/problems/defanging-an-ip-address

public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}