// 메서드(함수)
public class Ex02_method {
    public static void main(String[] args) {
        // Java는 원칙적으로 모든 함수가 클래스에 소속되는 것을 권장한다.
        // 클래스 내부에 있는 인스턴스(instance) 혹은 static을 통해서 호출되는 함수를 -> 메서드라고 한다.
        Animal animal = new Animal();
        animal.hello(); //인스턴스에 소속되어있는 메서드()를 호출함.
        // 인스턴스.메서드
        animal.add(1, 10); // return값이 있다고 해서 변수에 안넣어도됨!
        System.out.println(animal.add(1, 10)); // 다른 메서드들의 param에 재전달하거나
        int result = animal.add(10, 10); // 함수에다가 넣어서 사용
        System.out.println(result);

        // 자바에서는 구조분해할당은 없나요? 없다! (객체 구조분해할당, 배열 구조분해할당 X)
        // POJO, VO, DTO -> 매개변수를 객체로 받는 패턴이 있음! 얘네의 속성(필드, 인스턴스변수, 멤버변수)를 조회하는
        int animalSum = animal.addAll(1,2,3,4,5);
        System.out.println(animalSum); //15
    }
}

class Animal {
    // return타입 name(param) {...}
    // return타입이 없으면 void
    void hello() {
        System.out.println("Hello!");
    }
    // [접근제어자] [static] [리턴타입] 이름(param) [throws 에러타입] {...}
    // 리턴타입이 변수 타입과 일치해야함.
    // void가 아니라 지정되어 있다면 return 필수.
    int add(int a, int b) { // param -> 타입이 필요
        return a + b; // 인스턴스 변수(클래스변수, 생성자..)를 제외하고
        // 외부에서 값을 받아오기 위해서는 일반적으로는 매개변수를 사용해야함.
    }

    int addAll(int... nums) { // java1.5 -> 가변인자 <- JS에서의 나머지 연산자와 유사
        // nums가 배열취급
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}