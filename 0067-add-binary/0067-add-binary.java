class Solution {

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        char carry = '0';

        while (i >= 0 || j >= 0) {
            char num1 = (i >= 0) ? a.charAt(i--) : '0';
            char num2 = (j >= 0) ? b.charAt(j--) : '0';

            if (num1 == '1' && num2 == '1') {
                if (carry == '1') {
                    carry = '1';
                    sb.insert(0, '1');
                } else {
                    carry = '1';
                    sb.insert(0, '0');
                }
            } else {
                if (num1 == '1' || num2 == '1') {
                    if (carry == '1') {
                        carry = '1';
                        sb.insert(0, '0');
                    } else {
                        carry = '0';
                        sb.insert(0, '1');
                    }
                } else {
                    if (carry == '1') {
                        carry = '0';
                        sb.insert(0, '1');
                    } else {
                        carry = '0';
                        sb.insert(0, '0');
                    }
                }
            }
        }

        if(carry == '1'){
            sb.insert(0,'1');
        }

        return sb.toString();
    }
}
