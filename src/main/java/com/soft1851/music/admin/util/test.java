package com.soft1851.music.admin.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName test
 * @Description TODO
 * @date 2020-04-24 22:11
 **/
public class test {
    public static void main(String[] args) {
        String str = "111,222,333";
        String[] st1 = str.split(",");
        List<String> allIds = new ArrayList<>();
        for (int i = 0;i<st1.length;i++){
            allIds.add(st1[i]);
        }
        System.out.println(allIds);

    }
}
