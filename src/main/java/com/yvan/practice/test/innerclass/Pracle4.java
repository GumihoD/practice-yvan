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

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}
