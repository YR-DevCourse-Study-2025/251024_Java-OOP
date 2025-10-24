# Java OOP 학습 내용 정리 (25/10/24)

본 문서는 Java의 객체 지향 프로그래밍(OOP) 핵심 개념들을 정리합니다. 각 예제 파일에서 다루는 주요 내용을 요약하고 코드 예시를 포함합니다.

---

## 1. 클래스(Class)와 객체(Object) - `Ex01_class.java`

Java 프로그래밍의 가장 기본이 되는 단위입니다. 클래스는 객체를 만들기 위한 '설계도'이며, 객체는 클래스로부터 생성된 '실체(인스턴스)'입니다.

-   **클래스(Class):** 객체의 속성(필드)과 기능(메서드)을 정의합니다.
-   **객체(Object):** 클래스에 정의된 내용을 바탕으로 메모리에 실제로 생성된 것입니다. 각 객체는 고유한 상태를 가집니다.

```java
// Ex01_class.java 예제
class Person {
    String name; // 필드 (속성)

    void hello() { // 메서드 (기능)
        System.out.println("Hello I'm " + name);
    }
}

public class Ex01_class {
    public static void main(String[] args) {
        Person p1 = new Person(); // new 키워드로 객체 생성
        p1.name = "김자바";

        Person p2 = new Person();
        p2.name = "박JS";

        // p1과 p2는 서로 다른 객체이므로 영향을 주지 않음
        System.out.println(p1.name); // 김자바
        System.out.println(p2.name); // 박JS
    }
}
```

---

## 2. 메서드(Method) - `Ex02_method.java`

메서드는 클래스 내에서 특정 작업을 수행하는 코드의 묶음(함수)입니다. Java에서는 모든 메서드가 클래스에 포함되어야 합니다.

-   **구조:** `[접근제어자] [리턴타입] 이름(매개변수, ...) { ... }`
-   **리턴 타입:** `void` (리턴값 없음) 또는 특정 자료형을 지정할 수 있습니다.
-   **가변 인자:** `(int... nums)`와 같이 매개변수 개수가 정해지지 않았을 때 사용하며, 배열처럼 처리됩니다.

```java
// Ex02_method.java 예제
class Animal {
    // 리턴 타입이 없는 메서드
    void hello() {
        System.out.println("Hello!");
    }

    // int 타입 값을 리턴하는 메서드
    int add(int a, int b) {
        return a + b;
    }

    // 가변 인자를 사용하는 메서드
    int addAll(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
```

---

## 3. 메서드 오버로딩(Method Overloading) - `Ex03_overLoading.java`

하나의 클래스 내에서 이름이 같지만 **매개변수의 타입, 개수, 순서**가 다른 메서드를 여러 개 정의하는 것을 의미합니다. 이를 통해 동일한 기능에 대해 다양한 입력 값을 처리할 수 있습니다.

```java
// Ex03_overLoading.java 예제
class Util {
    // 매개변수가 int 타입인 add 메서드
    int add(int a, int b) {
        return a + b;
    }

    // 매개변수가 double 타입인 add 메서드 (오버로딩)
    double add(double a, double b) {
        return a + b;
    }

    // 매개변수 개수가 다른 add 메서드 (오버로딩)
    double add(double a, double b, double c) {
        return a + b + c;
    }
}
```

---

## 4. 접근 제어자(Access Modifier) - `Ex04_AccessModifier.java`

클래스, 멤버 변수, 메서드, 생성자에 대한 접근 권한을 지정합니다. 캡슐화(Encapsulation)를 구현하는 핵심 요소입니다.

-   **`public`:** 모든 곳에서 접근 가능.
-   **`protected`:** 같은 패키지 또는 상속받은 클래스에서 접근 가능.
-   **`default` (package-private):** 같은 패키지 내에서만 접근 가능 (아무것도 명시하지 않음).
-   **`private`:** 해당 클래스 내에서만 접근 가능.

### Getter와 Setter

`private` 멤버 변수에 안전하게 접근하고 값을 설정하기 위해 `public` 메서드인 Getter와 Setter를 사용합니다.

```java
// Ex04_AccessModifier.java 예제
class Example {
    // private으로 외부 접근을 막음 (정보 은닉)
    private int val;

    // public getter로 값을 읽을 수 있게 함
    public int getVal() {
        return val;
    }

    // public setter로 값을 설정할 수 있게 함 (필요시 유효성 검사 추가 가능)
    public void setVal(int newVal) {
        this.val = newVal;
    }
}
```

---

## 5. 생성자(Constructor) - `Ex05_Constructors.java`

생성자는 `new` 키워드로 객체를 생성할 때 호출되는 특별한 메서드입니다. 객체의 초기화를 담당합니다.

-   이름이 클래스 이름과 동일합니다.
-   리턴 타입이 없습니다.
-   개발자가 생성자를 하나도 만들지 않으면, 컴파일러가 매개변수 없는 기본 생성자를 자동으로 추가합니다.
-   메서드처럼 오버로딩이 가능합니다.

```java
// Ex05_Constructors.java 예제
class Programmer {
    private String name;
    private String language;

    // 기본 생성자
    Programmer() { }

    // 생성자 오버로딩
    Programmer(String name, String language) {
        // this는 생성될 인스턴스 자신을 가리킴
        this.name = name;
        this.language = language;
    }

    void intro() {
        System.out.printf("안녕하세요, %s 개발자 %s입니다.%n", language, name);
    }
}
```

---

## 6. `this` 키워드 - `Ex06_this.java`

`this`는 현재 인스턴스(객체) 자신을 가리키는 참조 변수입니다. 주로 다음과 같은 세 가지 용도로 사용됩니다.

1.  **멤버 변수와 매개변수 이름이 같을 때 구분:** `this.name = name;`
2.  **생성자에서 다른 생성자를 호출 (Constructor Chaining):** `this(name);`
3.  **메서드의 인수로 현재 인스턴스를 전달할 때:** `this.sayHello(this);`

```java
// Ex06_this.java 예제
class Student {
    private String name;
    private int age;

    // 용도 2: 다른 생성자 호출
    Student (String name, int age) {
        this(name); // 반드시 생성자의 첫 줄에 와야 함
        this.age = age;
    }

    // 용도 1: 멤버 변수와 매개변수 구분
    Student (String name) {
        this.name = name;
    }
}
```

---

## 7. `static` 키워드 - `Ex07_static.java`

`static`은 클래스 레벨에 변수나 메서드를 선언할 때 사용합니다. `static` 멤버는 객체를 생성하지 않고도 `클래스이름.멤버이름`으로 접근할 수 있으며, 해당 클래스의 모든 인스턴스가 공유합니다.

-   **`static` 변수:** 모든 인스턴스가 공유하는 변수. (예: `Counter.count`)
-   **`static` 메서드:** 인스턴스 멤버(`this`)에 접근할 수 없는 메서드. 유틸리티 함수 등에 사용됩니다.

```java
// Ex07_static.java 예제
class Counter {
    static int count = 0; // 모든 Counter 인스턴스가 공유

    void increase() {
        count++;
    }
}

public class Ex07_static {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        c1.increase();

        Counter c2 = new Counter();
        c2.increase();

        System.out.println(Counter.count); // 2 출력
    }
}
```

---

## 8. `final` 키워드 - `Ex08_final.java`

`final`은 "변경할 수 없다"는 의미를 부여하는 키워드입니다.

-   **`final` 변수:** 한 번만 초기화할 수 있는 상수가 됩니다.
-   **`final` 메서드:** 오버라이딩(재정의)을 금지합니다.
-   **`final` 클래스:** 상속을 금지합니다.

```java
// Ex08_final.java 예제
final class Calculator { // 더 이상 상속할 수 없음
    final String name; // 생성자에서 반드시 초기화해야 함

    Calculator(String name) {
        this.name = name;
    }

    final void hello() { // 오버라이딩 불가
        System.out.println("Hello");
    }
}
```

---

## 9. `instanceof` 연산자 - `Ex09_instanceof.java`

`instanceof`는 객체가 특정 클래스 또는 인터페이스의 인스턴스인지 확인하는 연산자입니다. `true` 또는 `false`를 반환하며, 다형성과 함께 형 변환 가능 여부를 확인할 때 유용하게 사용됩니다.

```java
// Ex09_instanceof.java 예제
ArrayList<Integer> list = new ArrayList<>();

// list는 ArrayList의 인스턴스이며, List 인터페이스를 구현했으므로 둘 다 true
System.out.println(list instanceof ArrayList); // true
System.out.println(list instanceof List);      // true
```

---

## 10. 상속(Inheritance) - `Ex10_Inheritance.java`

상속은 부모 클래스(Superclass)의 멤버(필드와 메서드)를 자식 클래스(Subclass)가 물려받아 사용할 수 있게 하는 기능입니다. 코드의 재사용성을 높이고 다형성을 구현하는 기반이 됩니다.

-   **`extends` 키워드:** 클래스를 상속받을 때 사용합니다.
-   **`super` 키워드:** 자식 클래스에서 부모 클래스의 멤버(생성자, 필드, 메서드)에 접근할 때 사용합니다.

```java
// Ex10_Inheritance.java 예제
class MyAnimal { // 부모 클래스
    String name;

    MyAnimal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println("먹는다!!!");
    }
}

class MyDog extends MyAnimal { // 자식 클래스
    MyDog(String name) {
        super(name); // 부모 클래스의 생성자 호출
    }

    void bark() {
        System.out.println("멍멍!");
    }
}

public class Ex10_Inheritance {
    public static void main(String[] args) {
        MyDog dog = new MyDog("누렁이");
        dog.eat();  // 부모 클래스의 메서드 사용
        dog.bark(); // 자식 클래스의 메서드 사용
    }
}
```

---

## 11. 메서드 오버라이딩(Method Overriding) - `Ex11_overriding.java`

오버라이딩은 자식 클래스가 부모 클래스로부터 상속받은 메서드를 자신의 기능에 맞게 재정의하는 것입니다. 다형성의 핵심적인 요소입니다.

-   **`@Override` 어노테이션:** 메서드가 부모 클래스의 메서드를 재정의한다는 것을 명시적으로 나타냅니다. 컴파일러가 올바르게 재정의되었는지 확인해 줍니다.
-   **동적 바인딩:** 오버라이딩된 메서드는 참조 변수의 타입이 아닌, 실제 인스턴스의 타입에 따라 런타임에 호출될 메서드가 결정됩니다.
-   **정적 바인딩:** 반면, 멤버 변수는 참조 변수의 타입에 따라 컴파일 타임에 접근할 변수가 결정됩니다.

```java
// Ex11_overriding.java 예제
class Vehicle {
    String name = "부릉이";
    void ride() {
        System.out.println("부릉부릉");
    }
}

class Car extends Vehicle {
    String name = "부릉삼";
    @Override
    void ride() {
        System.out.println("차가 부릉부릉!");
    }
}

public class Ex11_overriding {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.ride(); // "차가 부릉부릉!" 출력 (동적 바인딩)
        System.out.println(v.name); // "부릉이" 출력 (정적 바인딩)
    }
}
```

---

## 12. `super` 키워드 심화 - `Ex12_super.java`

`super`는 `this`와 유사하지만, `this`가 현재 객체 자신을 가리키는 것과 달리 `super`는 부모 클래스의 멤버를 가리킵니다.

-   **부모 생성자 호출:** `super()`는 부모 클래스의 기본 생성자를 호출합니다. 자식 클래스 생성자의 첫 줄에서만 사용할 수 있습니다.
-   **부모 멤버 접근:** 자식 클래스에서 오버라이딩한 메서드 내에서 부모의 원본 메서드를 호출하거나(`super.work()`), 부모와 자식의 필드 이름이 같을 때 부모의 필드에 접근(`super.name`)하기 위해 사용됩니다.

```java
// Ex12_super.java 예제
class MyProgrammer {
    String name = "김씨언어";
    void work() {
        System.out.println("열씨미 일하자!");
    }
}

class MyJavaProgrammer extends MyProgrammer {
    String name = "김자바";
    @Override
    void work() {
        super.work(); // 부모 클래스의 work() 호출
        System.out.println("자바로 일하자!");
        System.out.println(super.name); // "김씨언어" 출력
        System.out.println(this.name);  // "김자바" 출력
    }
}
```

---

## 13. `protected` 접근 제어자 - `ParentClass.java`, `ChildClass.java`

`protected` 멤버는 같은 패키지 내의 모든 클래스와, **패키지가 다르더라도 상속 관계에 있는 자식 클래스**에서 접근할 수 있습니다.

-   `p1` 패키지의 `ParentClass`와 `p2` 패키지의 `ChildClass` 예제를 통해 이를 확인할 수 있습니다.
-   `ChildClass`는 `ParentClass`를 상속받았기 때문에, 다른 패키지에 있음에도 불구하고 `ParentClass`의 `protected` 멤버인 `pt`에 접근할 수 있습니다.
-   단, 상속 관계가 아닌 외부 클래스에서는 `protected` 멤버에 접근할 수 없습니다.

```java
// p1/ParentClass.java
package p1;
public class ParentClass {
    protected String pt = "protected";
}

// p2/ChildClass.java
package p2;
import p1.ParentClass;
public class ChildClass extends ParentClass {
    public ChildClass() {
        // 다른 패키지이지만 상속받았으므로 protected 멤버에 접근 가능
        System.out.println(this.pt);
    }
}
```
