public class DoubleLinkedList<T> {
    //实现双向链表的类
    public DoubleLinkedList() {

    }

    //初始化链表
    GT<T> now = new GT<>();
    GT<T> begin = now;//记录首位

    //往后增添的功能
    public void add(T t) {
        now.date = t;
        GT<T> temp = now;//储存当前
        now.next = new GT<T>(t);
        now = now.next;
        now.last = temp;
    }

    //输出遍历当前链表
    public void print() {
        System.out.print("[");
        GT<T> d = begin;
        while (true) {
            if (d.next != null) {
                System.out.print(d.date);
                if(d.next.next!=null)
                System.out.print(",");
            }
            if (d.next == null) {
                break;
            }
            d=d.next;
        }
        System.out.print("]");
    }

}

//泛型类的单个节点
class GT<T> {
    T date;//储存的数据
    GT<T> last;//用于记录上一个节点；
    GT<T> next;//用于记录下一个节点

    public GT() {

    }//无参构造，用于初始化；

    public GT(T t) {
        this.date = t;
    }
}