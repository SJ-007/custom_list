package com.company;

import com.customlist.CustomArrayList;
import com.customlist.CustomLinkedList;
import com.customlist.CustomList;
import javafx.css.converter.LadderConverter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        CustomArrayList<Integer> list = new CustomArrayList<>();
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        list.add(9);
//        list.add(12);
////        list.update(2, 10);
//        list.remove(Integer.valueOf(9));
////        list.remove(2);
////        list.insert(2, 100);
////        list.add(17);
//        System.out.println(list+ " "+ list.len());
////        Iterator<Integer> iterator = list.iterator();
////        while(iterator.hasNext()) {
////            System.out.println(iterator.next());
////        }

        CustomList<Integer> list = new CustomLinkedList<>();
        list.add(7);
        list.add(12);
        list.add(13);
        list.add(90);
        list.insert(2, 14);
        list.remove(2);
        list.remove(Integer.valueOf(12));
        Iterator<Integer> i = list.iterator();
//        while(i.hasNext()) {
//            System.out.println(i.next());
//        }
        System.out.println(list);
    }
}
