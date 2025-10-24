// 생성자
public class Ex05_Constructors {
    public static void main(String[] args) {
        // 생성자(constructor) : new 키워드를 앞에 붙어서

        // 메서드 -> 접근제어자.
        Programmer p = new Programmer();
        // 1. 나는 생성자를 만든 기억이 없는데 왜 new로 만들어지지?
        // - default 값이 내장되어 있다는 뜻
        // 2. 메서드라면 리턴이 있어야하는거 아니야?
        // 3. 메서드라면 패러미터가 있는거 아니야?
        Programmer p2 = new Programmer(2000);
        Programmer p3 = new Programmer("조자바", "자바");
        p3.intro();
    }
}

class Programmer {
    // 필드(인스턴스 변수)
    private String name;
    private String language;

    // 클래스이름(패러미터) {}
    Programmer() { } // 디폴트 생성자

    // return 값? -> 자기 자신 타입
    // Programmer 생성자() {return Programmer()}
    Programmer(int age) {
        System.out.println(age);
    }

    Programmer(String name, String language) {
        // 매개변수로 전달받은 name인지 인스턴트의 name인지 불분명
        // 우선권이 가장 가깝게 정의된 local 지역변수인 매개변수가 가져감

        // this : 이 클래스를 통해서 결과적으로 만들어질 인스턴스
        this.name = name;
        this.language = language;
    }

    void intro() {
        System.out.println("안녕하세요!! " + language + "개발자: " + name + "입니다.");
        System.out.println("""
                안녕하세요, %s 개발자 %s입니다.
                """.formatted(language, name));
    }
}
