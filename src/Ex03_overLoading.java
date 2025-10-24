// 메서드 오버로딩(param 갯수,타입을 통해 동일한 param이름을 재사용) <-> 오버라이딩 (상속, 구현 -> 이미 존재하던 메서드를 재정의)
public class Ex03_overLoading {
    public static void main(String[] args) {
        // integer, double, String을 입력했을때, 커서를 올리면 각각 설명들이 다 다르다!!
        // System.out도 오버로딩을 사용하고 있었다!!
        System.out.println(1);
        System.out.println(1.0);
        System.out.println("1");

        Util u = new Util();
        int num = u.add(30, 10); // 40
        System.out.println(num);

        double num2 = u.add(1.9, 10.4); // 40
        System.out.println(num2);
    }
}

class Util {
    int add(int a, int b) {
        return a + b;
    }

    // 한 메서드는 하나의 데이터타입만 return 가능.
    double addDouble(double a, double b) {
        return a + b;
    }

    // 오버로딩
    double add(double a, double b) {
        return a + b; // 같은 이름인데 다른 메서드 패러미터 타입 조합을 가지고 있기에
        // 동일한 이름의 메서드를 허용한다.
    }

    double add(double a, double b, double c) {
        return a + b + c; // 갯수와 구조가 다르면 된다.
    }

    // 타입이 달라야함. (이름이 달라도 타입이 같으면 같은 구조로 인식한다)
    /*double add(double x, double y) {
        return x + y; // 같은 이름인데 다른 메서드 패러미터 타입 조합을 가지고 있기에
        // 동일한 이름의 메서드를 허용한다.
    }*/
}
