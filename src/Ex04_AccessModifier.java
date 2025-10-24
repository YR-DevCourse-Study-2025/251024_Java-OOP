import dev.Data1; // 외부 패키지 경로에서 불러오는 경로
// import dev.Data2;

// 접근제어자, 접근자
public class Ex04_AccessModifier {
    // public (default), private, protected -> 접근제어자
    // static -> static 메모리
    public static void main(String[] args) {
        // public <- 공개(완전공개) <- 패키지, 모듈의 경계를 '무시'한다.
        // src -> java. 폴더(패키지)
        Data1 d1 = new Data1();
        // Data2 d2 = new Data2(); <- public 되어 있지 않으면 패키지 경계를 넘을 수가 없음.

        // 접근제어자는 접근하면 안되는 파일이나 코드에 대한 보안적인 측면으로 인해서 접근을 방지하기 위함!
        // d1.test() <- public이 안붙어있어서 접근이 안됨!
        d1.test2(); // 메서드에도 접근제어자가 붙어야하는구나!!

        Data3 d3 = new Data3();
        System.out.println(d3.a); // public은 어디에서나 접근 가능
        System.out.println(d3.b); // default는 같은 파일, 패키지에서 접근 가능
        // System.out.println(d3.c); // private이라서 안된다. -> 같은 클래스 내부에서만 접근 가능

        // getter, setter
        Example e = new Example();
        e.setVal(100);
        System.out.println(e.getVal());

    }
}

class Data3 {
    // 같은 패키지의 클래스지만, 내부에 인스턴스 변수나 메서드의 접근을 원하지 않을 경우가 있음(내부에서만 사용용)
    public int a;
    int b;
    private int c;
}

class Example {
    // public int val; // 어느 코드에서도 다 사용이 가능함. 별도의 검증을 넣어줄 수가 없음.

    private int val; // 외부에서 호출할 수가 없다.
    public int getVal() {return val;} //getter함수
    public void setVal(int newVal) { //setter함수 <- 멤버변수를 패러미터를 받아서 바꿔주는는 접근자.
        this.val = newVal;
    }

    // IntelliJ 자동 (ctrl + n -> getter setter 생성)
    private int val2;

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
    // record -> 이미 getter를 구현한
    // lombok -> @(표시만 달아주면) 알아서 getter/setter를 만들어주게 할 수 있음.
}
