package cn.com.nadav.sms.handler.codec.sgip;

public class SgipMethod implements Comparable<SgipMethod> {

    private String name;


    public SgipMethod(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(SgipMethod o) {
        return 0;
    }
}
