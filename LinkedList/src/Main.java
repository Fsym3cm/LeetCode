import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.*;
class Student{
    String name;
    int score;
    Student(String name,int score){
        this.name=name;
        this.score=score;
    }
}
public class Main {

    public static void main(String[] args) {
        LinkedList<Student> mylist=new LinkedList<>();
        Student stu1=new Student("张小一",78),
                stu2=new Student("王小二",98),
                stu3=new Student("李大山",67);
        mylist.add(stu1);
        mylist.add(stu2);
        mylist.add(stu3);
        int number=mylist.size();
        System.out.println("现在链表中有"+number+"个节点：");
        for (int i=0;i<number;i++){
            Student temp=mylist.get(i);
            System.out.printf("第"+i+"节点中的数据，学生：%s，分数：%d\n",temp.name,temp.score);
        }
        Student removeSTU=mylist.remove(1);
        System.out.printf("被删除的节点中的数据是：%s，%d\n",removeSTU.name,removeSTU.score);
        Student replaceSTU=mylist.set(1,new Student("赵钩林",68));
        System.out.printf("被替换的节点中的数据是：%s，%d\n",replaceSTU.name,replaceSTU.score);
        number=mylist.size();
        System.out.println("现在链表中有"+number+"个节点：");
        Student Frist=mylist.getFirst();
        System.out.println("首节点为："+Frist);
        Student Last=mylist.getLast();
        System.out.println("尾节点为："+ Last);
        System.out.println(Last.name+","+Last.score);
        mylist.add(new Student("李刚",50));
        System.out.println("节点为："+mylist.get(1).name);
        Iterator<Student> iter=mylist.iterator();
        while(iter.hasNext()){
            Student te=iter.next();
            System.out.println("学生："+te.name+",分数："+te.score);
        }


        if (mylist.contains(stu1)) {
            System.out.println("链表包含" + stu1 + ":");
            System.out.println(stu1.name + "," + stu1.score);
        }else{
            System.out.println("链表没有节点含有"+stu1);
        }
    }
}
