/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode cur=slow.next;
        slow.next=null;
        fast=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        cur=pre;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=fast.next;
            fast.next=cur;
            fast=fast.next.next;
            cur=curNext;
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        while(cur.next!=null&&cur.val<cur.next.val){
            cur=cur.next;
        }
        while(cur!=null){
            ListNode pre=dummy;
            if(cur.next!=null&&cur.val>cur.next.val){
                ListNode curNext=cur.next;
                cur.next=curNext.next;
                while(pre.next.val<curNext.val){
                    pre=pre.next;
                }
                curNext.next=pre.next;
                pre.next=curNext;

            }else{
                cur=cur.next;
            }
        
        }
        return dummy.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode afterHead=head.next;
        ListNode before=head;
        ListNode after=head.next;
        while(before.next!=null&&after.next!=null){
            before.next=after.next;
            before=before.next;
            after.next=before.next;
            after=after.next;
        }
        if(after!=null){
            after.next=null;
        }if(before!=null){
            before.next=afterHead;
        }
        
        return head;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=reverse(l1);
        ListNode head2=reverse(l2);
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        int carry=0;
        while(head1!=null||head2!=null||carry!=0){
            int a=head1==null?0:head1.val;
            int b=head2==null?0:head2.val;
            int sum=a+b+carry;
            ListNode node=new ListNode(sum%10);
            cur.next=node;
            cur=cur.next;
            carry=sum/10;
            if(head1!=null){
                 head1=head1.next;
            }
           if(head2!=null)
            head2=head2.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head){
        ListNode cur=head;
        ListNode pre=null;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=getLen(head);
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        for(int i=0;i<len/k;i++){
            for(int j=0;j<k-1;j++){
                ListNode curNext=cur.next;
                cur.next=curNext.next;
                curNext.next=pre.next;
                pre.next=curNext;
            }
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }

    private int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        while(cur.next!=null&&cur.val<cur.next.val){
            cur=cur.next;
        }
        while(cur!=null){
            ListNode pre=dummy;
            if(cur.next!=null&&cur.val>cur.next.val){
                ListNode curNext=cur.next;
                cur.next=cur.next.next;
                while(pre.next.val<curNext.val){
                    pre=pre.next;
                }
                curNext.next=pre.next;
                pre.next=curNext;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}

