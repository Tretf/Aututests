package com.geekbrains.lesson4;

public class Triangle {
    private Integer A;
    private Integer B;
    private Integer C;
    public Double S;

    public Triangle(Integer a, Integer b, Integer c) {
        A = a;
        B = b;
        C = c;
    }

    public Integer getA() {
        return A;
    }

    public void setA(Integer a) {
        A = a;
    }

    public Integer getB() {
        return B;
    }

    public void setB(Integer b) {
        B = b;
    }

    public Integer getC() {
        return C;
    }

    public void setC(Integer c) {
        C = c;
    }

//    public Double areaTriangle(int A, int B, int C) {
//
//        if (A <= 0 | B <= 0 | C <= 0 | (A + B < C) | (B + C < A) | (C + A < B)) {
//            throw new NullPointerException("Это не треугольник");
//        }
//        Double p = Double.valueOf((A + B + C) / 2);  //полупериметр
//        S = Math.sqrt(p * (p - A) * (p - B) * (p - C));
//        return S;
//    }

    public Double areaTriangle() {

        if (A <= 0 | B <= 0 | C <= 0 | (A + B < C) | (B + C < A) | (C + A < B)) {
            //throw new NullPointerException("Это не треугольник");
            return 0.0;
        }
        Double p = Double.valueOf((A + B + C) / 2);  //полупериметр
        S = Math.sqrt(p * (p - A) * (p - B) * (p - C));
        return S;
    }

        public void sidesOfTheTriangle() throws TriangleException {
        if (A <= 0 | B <= 0 | C <= 0 | (A + B < C) | (B + C < A) | (C + A < B)) {
            throw new TriangleException();
        }
    }

}
