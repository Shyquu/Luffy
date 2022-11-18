package dev.koo.admin;

public class TestClass {

    public static void main(String[] args) {
        for (int x = 0; x < 8; x++) {
            for (int z = 0; z < 8; z++) {
                if (x % 2 == 0 ^ z % 2 == 0) {
                    System.out.println("w");
                } else {
                    System.out.println("s");
                }
            }
        }
    }

}
