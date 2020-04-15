package _01_sort._01_Comparable;

public class StudentTestComparable {

    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("zhangsan");
        stu1.setAge(17);

        Student stu2 = new Student();
        stu2.setName("lisi");
        stu2.setAge(19);
        Comparable max = getMax(stu1, stu2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1,Comparable c2){
        int i = c1.compareTo(c2);
        if (i >= 0){
            return c1;
        }else{
            return c2;
        }
    }

}
