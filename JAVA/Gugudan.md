# 구구단 만들기

구구단 만들기 및 자바의 기초를 다지는 공부입니다.


# 2, 3단 구현 - 계산 및 출력


* 코드
    ```
    public class Gugudan {
        public static void main(String[] args) {
            //2단
            System.out.println("2단");
            System.out.println("2 * 1");
            System.out.println("2 * 2");
            System.out.println("2 * 3");
            System.out.println("2 * 4");
            System.out.println("2 * 5");
            System.out.println("2 * 5");
            System.out.println("2 * 6");
            System.out.println("2 * 7");
            System.out.println("2 * 8");
            System.out.println("2 * 9");
            
            //3단
            System.out.println("3단");
            System.out.println("3 * 1");
            System.out.println("3 * 2");
            System.out.println("3 * 3");
            System.out.println("3 * 4");
            System.out.println("3 * 5");
            System.out.println("3 * 5");
            System.out.println("3 * 6");
            System.out.println("3 * 7");
            System.out.println("3 * 8");
            System.out.println("3 * 9");
    
            }
        }
    ```
* 결과
    ```
    2단
    2 * 1
    2 * 2
    2 * 3
    2 * 4
    2 * 5
    2 * 5
    2 * 6
    2 * 7
    2 * 8
    2 * 9
    3단
    3 * 1
    3 * 2
    3 * 3
    3 * 4
    3 * 5
    3 * 5
    3 * 6
    3 * 7
    3 * 8
    3 * 9
    ```

* 정리
    ```
    System.out.println("문자열");
    ```
    을 이용하여 원하는 문자열을 출력할 수 있다.



# 4, 5단 구현 - 값 입력 및 변수

* 코드
    ```
    import java.util.Scanner;

    public class Gugudan {
        public static void main(String[] args) {
            System.out.println("구구단을 출력할 단은?");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("number : " + number);

            int result = number * 1;
            System.out.println(number + " * 1 = " + result);
            result = number * 2;
            System.out.println(number + " * 2 = " + result);
            result = number * 3;
            System.out.println(number + " * 3 = " + result);
            result = number * 4;
            System.out.println(number + " * 4 = " + result);
            result = number * 5;
            System.out.println(number + " * 5 = " + result);
            result = number * 6;
            System.out.println(number + " * 6 = " + result);
            result = number * 7;
            System.out.println(number + " * 7 = " + result);
            result = number * 8;
            System.out.println(number + " * 8 = " + result);
            result = number * 9;
            System.out.println(number + " * 9 = " + result);
        }
    }
    ```
    


* 결과
    ```
    구구단을 출력할 단은?
    4
    number : 4(입력값)
    4 * 1 = 4
    4 * 2 = 8
    4 * 3 = 12
    4 * 4 = 16
    4 * 5 = 20
    4 * 6 = 24
    4 * 7 = 28
    4 * 8 = 32
    4 * 9 = 36

    ```



* 정리
    ```
    import java.util.Scanner;
    ```

    import란 C언어에서의 include같은 역할을 해주는 것으로
클래스를 사용하기 위해 호출하는 것이다.

    Scanner란 클래스는 값을 입력받아주는 역할을 하는 클래스 이다.

    java.utll 패키지 안에 있는 클래스이기에 앞에 java.util을 붙여준다.

    ```
    Scanner scanner = new Scanner(System.in);
    ```
    값을 입력 받기 위해 Scanner클래스를 호출하였고 사용하기 위해 객체를 생성하여야 한다.
    
    객체를 생성하기 위한 방법은 다음과 같다
    ```
    Class_name  object_name = new class_name();
    ```
    system.in은 키보드 입력을 위해 사용한다고만 알아두자
    
    ```
    int number = scanner.nextInt();
    ```
    nextInt 메서드는 scanner 객체(object)를 통해 입력받은 값을 INT(정수)형으로 받아 읽어들인 후 number라는 정수형 변수에 저장한다.

    Scanner 에서 값을 읽을 때 사용하는 다른 메서드로는
    ```
    nextBoolean()	    Reads a boolean value from the user
    nextByte()	        Reads a byte value from the user
    nextDouble()	    Reads a double value from the user
    nextFloat()	        Reads a float value from the user
    nextInt()	        Reads a int value from the user
    nextLine()	        Reads a String value from the user
    nextLong()	        Reads a long value from the user
    nextShort()	        Reads a short value from the user
    ```
    등이 있다.


