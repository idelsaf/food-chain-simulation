package com.idel;

import com.idel.actions.InitAction;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 5);
        InitAction initAction = new InitAction(map);
        System.out.println(map);
    }
}