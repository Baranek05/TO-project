package com.example.server.model;

public record MessageFromStandManagerService(MessageAssignTimeFromStandManager assignTime, MessageStartFromStandManager start) {
}


//record A(int a){}
//
//record B(int b){}
//
//record C(A a, B b){}
//
//class Cc {
//    private final A a;
//    private final B b;
//
//    Cc(A a, B b) {
//        this.a = a;
//        this.b = b;
//    }
//
//    public A a() {
//        return a;
//    }
//
//    public B b() {
//        return b;
//    }
//}
//
//class x{
//    public void x(){
//        var x = new C(null, new B(1));
//        var y = new C(new A(1), null);
//
//        var isSecondCase = x.a == null && x.b != null;
//    }
//}