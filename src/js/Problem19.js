/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if(head === null) {
        return null;
    }
    let curr = head, prev = head, iterator = -1;
    while(curr !== null) {
        iterator++;
        if(iterator > n) {
            iterator = n;
            prev = prev.next;
        }
        curr = curr.next;
    }
    if(prev.next === null) {
        return null;
    }
    if(iterator < n) {
        head = head.next;
        return head;
    }
    prev.next = prev.next.next;
    return head;
};