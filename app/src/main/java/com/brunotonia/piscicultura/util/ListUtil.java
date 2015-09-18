package com.brunotonia.piscicultura.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static List<String> convertToStringList(List<?> objects) {
        List<String> newList = new ArrayList<>();

        if (objects != null && !objects.isEmpty()) {
            for (Object o : objects) {
                newList.add(o.toString());
            }
        }

        return newList;
    }
}
