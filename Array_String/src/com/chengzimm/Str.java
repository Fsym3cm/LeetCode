package com.chengzimm;

/**
 * 当我们使用  “==” 时，它实际上会比较这两个对象是否是同一个对象。
 *
 * 字符串不可变意味着一旦字符串被初始化，你就无法改变它的内容。
 * */
// "static void main" must be defined in a public class.
public class Str {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));

        System.out.println("================================================");
        String str1 = "Hello World";
        //str1[5] = ',';
        System.out.println(str1);

        System.out.println("================================================");
        String str2 = "Hello World";
        // 1. concatenate
        str2 += "!";
        System.out.println(str2);
        // 2. find
        System.out.println("The position of first 'o' is: " + str2.indexOf('o'));
        System.out.println("The position of last 'o' is: " + str2.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s1.substring(6, 11));
    }
}
