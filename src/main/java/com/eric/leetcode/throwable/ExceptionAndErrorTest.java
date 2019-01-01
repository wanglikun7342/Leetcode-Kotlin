package com.eric.leetcode.throwable;

import java.io.IOException;

public class ExceptionAndErrorTest {

    public void exceptionAndErrorTest() {
//        throwNone();
        try {
            throwError();
        } catch (Error e) {
            System.out.println("catch error");
        }
//        try {
//            throwCheckedException();
//        } catch (IOException e) {
//        System.out.println("catch IOException");
//        }
//        throwUncheckedException();
    }

    private void throwUncheckedException() {
        throw new RuntimeException("this is a Test Unchecked Exception");
    }

    private void throwCheckedException() throws IOException {
        throw new IOException("this is a Test Checked Exception");
    }

    private void throwNone() throws RuntimeException {
        System.out.println("throw none");
    }

    private void throwError() {
        throw new StackOverflowError("this is a Test error");
    }

    public static void main(String args[]) {
        System.out.println("main start");
        ExceptionAndErrorTest exceptionAndErrorTest = new ExceptionAndErrorTest();
        exceptionAndErrorTest.exceptionAndErrorTest();
        System.out.println("main finish");
    }
}
