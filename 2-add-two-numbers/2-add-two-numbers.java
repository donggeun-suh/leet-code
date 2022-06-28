/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        StringBuilder sb = new StringBuilder();
        
        boolean roundUp = false;
        int sum;
        
        // 자릿수가 같은 데 직전까지 일단 더해줌.
        while(l1.next != null && l2.next != null){
            
            if(roundUp){
                sum = l1.val + l2.val + 1;
                roundUp = false;
            } else {
                sum = l1.val + l2.val;
            }
            
            if(sum >= 10){
                sb.append(sum%10);
                roundUp = true;
            } else {
                sb.append(sum);
            }
            
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        // 짧은 쪽 마지막 자릿수 처리
        
        if(roundUp){
            sum = l1.val + l2.val + 1;
            roundUp = false;
        } else {
            sum =  l1.val + l2.val;
        }
        
        if(sum >= 10){
            sb.append(sum%10);
            roundUp =true;
        } else {
            sb.append(sum);
        }
        
        // 더 긴쪽 처리 
        if(l1.next != null){
            // l1이 더 긴 경우
            l1= l1.next;
            
            while(l1.next != null){
                
                    if(roundUp){
                        sum = l1.val + 1;
                        roundUp = false;
                    } else {
                        sum = l1.val;
                    }
                
                
                    if(sum >= 10){
                        sb.append(sum%10);
                        roundUp = true;
                    }else{
                        sb.append(sum);
                        roundUp = false;
                    }
                
                l1 = l1.next;
            
            }
            
            if(roundUp){
                        sum = l1.val + 1;
                        roundUp = false;
            } else {
                        sum = l1.val;
            }
            
            if(sum >= 10){
                        sb.append(sum%10);
                        sb.append(1);
            }else{
                        sb.append(sum);
            }
            
            
        } else if(l2.next != null) {
            // l2가 더 긴 경우
            l2 = l2.next;
                        while(l2.next != null){
                
                    if(roundUp){
                        sum = l2.val + 1;
                        roundUp = false;
                    } else {
                        sum = l2.val;
                    }
                
                
                    if(sum >= 10){
                        sb.append(sum%10);

                        roundUp = true;
                    }else{
                        sb.append(sum);
                        roundUp = false;
                    }
                
                l2 = l2.next;
            
            }
            
            if(roundUp){
                        sum = l2.val + 1;
                        roundUp = false;
            } else {
                        sum = l2.val;
            }
            
            if(sum >= 10){
                        sb.append(sum%10);
                        sb.append(1);
            }else{
                        sb.append(sum);
            }
            
            
            
        } else {
            // 같은 경우
            if(roundUp){
                sb.append(1);
            }
        }
        
        String ans = sb.toString();
        
        
        ListNode first = new ListNode(Character.getNumericValue(ans.charAt(ans.length()-1)));
        if(ans.length() == 1){
            return first;
        }
        
        ListNode next = first;
        ListNode makeNode = new ListNode(0);
        
        for(int i = ans.length() -2 ; i>=0; i--){
            makeNode = new ListNode(Character.getNumericValue(ans.charAt(i)),next);
            next = makeNode;
        }
        
        return makeNode;
        
    }
}