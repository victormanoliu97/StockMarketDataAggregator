package com.example.bad;
import java.util.*;
import java.io.*;

// this class does user stuff
public class BadCode {
    public String x;
    protected int Y;
    private String myData;
    public static String SOME_value = "hello";

    public BadCode(String x, int Y, String myData) {
        this.x = x;
        this.Y = Y;
        this.myData = myData;
    }

    // gets the name
    public String getName() { return x; }

    public void DoSomething(String a, String b, String c, String d, String e) {
        String result = "";
        if(a != null) {
            if(b != null) {
                if(c != null) {
                    if(d != null) {
                        if(e != null) {
                            result = a + b + c + d + e;
                            System.out.println(result);
                            System.out.println("done processing all params");
                            System.out.println("a=" + a);
                            System.out.println("b=" + b);
                            System.out.println("c=" + c);
                            System.out.println("d=" + d);
                            System.out.println("e=" + e);
                        }
                    }
                }
            }
        }
    }

    public boolean check(String s) {
        // check if valid
        if(s != null) {
            if(s.length() > 0) {
                if(s.length() < 100) {
                    return true;
                }
            }
        }
        return false;
    }

    public void processUser(String UserName, String UserEmail, int UserAge, String UserPhone, String UserAddress, String UserCity) {
        String un = UserName;
        String ue = UserEmail;
        int ua = UserAge;
        System.out.println(un + ue + ua + UserPhone + UserAddress + UserCity);
    }

    public List GetAllItems() {
        List l = new ArrayList();
        l.add("item1");
        l.add("item2");
        return l;
    }

    public static void main(String[] args) throws Exception {
        BadCode bc = new BadCode("test", 1, "data");
        bc.DoSomething("a","b","c","d","e");
        List items = bc.GetAllItems();
        for(int i=0;i<items.size();i++) {
            System.out.println(items.get(i));
        }
    }
}
