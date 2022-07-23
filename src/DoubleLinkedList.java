public class DoubleLinkedList {
//实现双向链表的类












}

//单个节点
class GT <T>{
    T date;//储存的数据
    GT last;//用于记录上一个节点；
    GT next;//用于记录下一个节点
    public GT(T t){
        this.date = t;
    }
}