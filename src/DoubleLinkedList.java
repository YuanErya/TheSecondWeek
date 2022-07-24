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
                if (d.next.next != null)
                    System.out.print(",");
            }
            if (d.next == null) {
                break;
            }
            d = d.next;
        }
        System.out.print("]");
    }


    //删除功能
    public void remove(int r) {
        int i = 0;
        GT<T> d = begin;
        if (r == 0) {
            d.next.last = null;
            begin = d.next;
        } else {
            d = find(d, r);
            GT<T> temple = d.last;
            d.last.next = d.next;
            d.next.last = temple;
        }
    }


    //插入功能
    public void getin(int r, T t) {
        GT<T> d = begin;
        d = find(d, r);
        GT<T> temple = d.next;
        d.next = new GT<T>(t);
        d = d.next;
        d.last = temple.last;
        d.next = temple;
    }


    //索引查找法
    public T get(int r) {
        GT<T> d = begin;
        d = find(d, r);
        return d.date;
    }


    //链表翻转功能
    public void fz() {
        GT<T> d = begin;
        while (true) {
            if (d.last == null) {
                d.last = new GT<T>();
                now = d.last;
            }
            if (d.next == null) {
                d.last.last = null;
                begin = d.last;
                break;
            }
            GT<T> temple = d.next;
            d.next = d.last;
            d.last = temple;
            d = temple;
        }

    }


    //将实现每个功能时的定位功能进行封装，精简代码
    private GT<T> find(GT<T> d, int r) {
        int i = 0;
        while (true) {
            if (r == 0) {
                break;
            }
            d = d.next;
            i++;
            try {
                if (d.next == null) {
                    throw new ArrayIndexOutOfBoundsException();//索引越界则抛出异常
                }
            } catch (ArrayIndexOutOfBoundsException E) {
                System.out.println("");
                System.out.println("所给下标越界");
            }
            if (i == r) {
                break;
            }
        }
        return d;
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