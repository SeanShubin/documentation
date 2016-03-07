package com.seanshubin.documentation.core;

import static com.seanshubin.documentation.core.ConstantA.A;
import static com.seanshubin.documentation.core.ConstantB.B;
import static com.seanshubin.documentation.core.ConstantC.C;

public class Constants {
    public static void main(String[] args) {
        System.out.println(A + B + C); //14
        System.out.println(B + C + A); //11, if above line is commented out
    }
}
