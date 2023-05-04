package com.example.conatainer_tut.objrefers;

public class ReferenceObjs {
    private int x;
    private ReferenceObjs2 obj;

    public ReferenceObjs() {
        super();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public ReferenceObjs2 getObj() {
        return obj;
    }

    public void setObj(ReferenceObjs2 obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ReferenceObjs{" +
                "x=" + x +
                ", obj=" + obj +
                '}';
    }
}
