package com.yvan.practice.test.innerclass;

/**
 * Created by yvan on 2016/12/22.
 */
public class Pracle4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int values() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        public PDestination(String whereto) {
            label = whereto;
        }

        @Override
        public String readLaber() {
            return label;
        }
    }

    /**
     * 内部类如果是static 那创建内部类的时候将不会建立和外部类的引用
     */
    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}
