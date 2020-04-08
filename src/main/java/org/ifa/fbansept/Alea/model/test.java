package org.ifa.fbansept.Alea.model;

public class test {
    public static void main(String[] args){
        long s = 23456L;
        System.out.println("s = " + s );
        optimalChange(s);

        System.out.println("coin 2 :" );
    }

    public static class Change {
        private long coin2;
        private long bill10;
        private long bill5;

        public Change() {
        }

        public long getCoin2() {
            return coin2;
        }

        public void setCoin2(long coin2) {
            this.coin2 = coin2;
        }

        public long getBill10() {
            return bill10;
        }

        public void setBill10(long bill10) {
            this.bill10 = bill10;
        }

        public long getBill5() {
            return bill5;
        }

        public void setBill5(long bill5) {
            this.bill5 = bill5;
        }
    }

    static Change optimalChange(long s) {
        Change change = new Change();
        if( (s <= 1) || ((((s % 10)) % 5 ) % 2 != 0) ){
            return null;
        }

        long div10 = s/10;
        long restDiv10 = s % 10;
        change.setBill10(div10);

        if((restDiv10 % 5) % 2 == 0){
            long div5 = restDiv10/5;
            long restDiv5 = restDiv10 % 5;
            change.setBill5(div5);

            long div2 = restDiv5/2;
            change.setCoin2(div2);
        } else  {
            long div2 = restDiv10/2;
            change.setCoin2(div2);
        }

        return change;

    }
}
