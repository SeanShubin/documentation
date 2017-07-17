package com.seanshubin.documentation.domain;

import static com.seanshubin.documentation.domain.ConstantA.A;
import static com.seanshubin.documentation.domain.ConstantB.B;
import static com.seanshubin.documentation.domain.ConstantC.C;

public class Constants {
    public static void main(String[] args) {
        System.out.println(A + B + C); //14
        System.out.println(B + C + A); //11, if above line is commented out
    }
}
