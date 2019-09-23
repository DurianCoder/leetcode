package com.durian.leetcode;

/**
 * 类说明：两数相加
 * <p>
 * 详细描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jiang
 * @since 2019年09月23日
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = ListNode.initListNode(1, 2, 9, 8);
        ListNode l2 = ListNode.initListNode(1, 9, 3, 0 );
        System.out.println(addTwoNumbers(l1, l2));

    }

    /**
     * x,y分别用来表示当前节点的值，carry表示前一位相加的进位，sum = (x + y + carry) % 10, carry = sum / 10;
     * 循环：下一个节点相加；最后返回时，返回listNode.next，去除第一个初始化val为0的节点
     *
     * @param l1 l1
     * @param l2 l2
     * @return 时间复杂度：O(max(m,n))  空间复杂度：O(max(m,n))
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = l1, q = l2, cur = listNode;

        int carry = 0;
        while (p != null || q != null) {
            int x = null == p ? 0 : p.val;
            int y = null == q ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return listNode.next;
    }


    /**
     * 定义节点
     */
    static class ListNode {
        int val;
        ListNode next;

        public static ListNode initListNode(int ...nums) {
            ListNode listNode = new ListNode(0);
            ListNode cur = listNode;
            for (int i = 0; i < nums.length; i++) {
                cur.next = new ListNode(nums[i]);
                cur = cur.next;
            }
            cur.next = new ListNode(0);
            return listNode.next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public String toString() {
            String str = "";
            ListNode l = this;
            while (null != l.next) {
                str += l.val;
                l = l.next;
            }
            return str;
        }
    }

}