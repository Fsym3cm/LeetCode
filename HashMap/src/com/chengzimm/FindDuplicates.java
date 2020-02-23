package com.chengzimm;

import java.util.HashSet;

public class FindDuplicates {
    public static void main(String[] args) {
        //简单地迭代每个值并将值插入集合中。 如果值已经在哈希集中，则存在重复
       /* *//*
         * 使用哈希集查找重复项的模板
         *//*
        boolean findDuplicates(List<Type>& keys) {
            // Replace Type with actual type of your key
            Set<Type> hashset = new HashSet<>();
            for (Type key : keys) {
                if (hashset.contains(key)) {
                    return true;
                }
            hashset.insert(key);
            }
            return false;
        }*/
    }
}
