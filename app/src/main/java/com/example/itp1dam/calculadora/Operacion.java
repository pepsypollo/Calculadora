package com.example.itp1dam.calculadora;

public class Operacion {
    private char op;
    private double num1;
    private double num2;
    private double resul;

    public Operacion(double num1, char op, double num2, double resul){
        this.op = op;
        this.num1 = num1;
        this.num2 = num2;
        this.resul = resul;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResul() {
        return resul;
    }

    public void setResul(double resul) {
        this.resul = resul;
    }
}
