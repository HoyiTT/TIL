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

# 6, 7단 구현 - 반복문 
* 코드
    ```
    public class Gugudan {
        public static void main(String[] args) {
            System.out.println("구구단을 출력할 단은?");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("number : " + number);		
            
            for(int i = 1; i < 10; i++ ) {
                System.out.println(number + " * " + i +" = " + number * i);
            }
            
        }
    }
    ```

* 결과
    ```
    구구단을 출력할 단은?
    6
    number : 6
    6 * 1 = 6
    6 * 2 = 12
    6 * 3 = 18
    6 * 4 = 24
    6 * 5 = 30
    6 * 6 = 36
    6 * 7 = 42
    6 * 8 = 48
    6 * 9 = 54
    ```

* 정리
    
    지금까지 2 ~ 5단까지 구현하기 위해 단순, 반복적인 작업이 많았다.
    단순, 반복적인 작업의 수가 적다면 상관이 없지만 굉장히 100개,1000개,10000개 정도로 늘어난다면 일일이 하나하나 입력할 순 없을 것이다.
    
    이러한 단순 반복작업을 간단히 하기 위해 사용하는 것이 반복문이다.

    반복문에는 for문과 while문이 있지만 for문만 설명하겠다.

    ```
    for(int i = 1; i < 10; i++ ) {
                    System.out.println(number + " * " + i +" = " + number * i);
                }
    ```
    for문은 세가지 값을 정해주고 정해진 내용중 조건을 만족하면 몸통에 있는 코드가 실행되게 된다.

    ```
    for(초기식;조건식;변화식){
        실행될 코드
    }
    ```
    초기식 : 코드 블록을 실행하기 전에 한 번 실행된다. 루프가 실행되기 전에 변수를 설정한다.

    조건식 : 코드 블록을 실행하기 위한 조건을 정의한다. 조건이 참이면 루프가 다시 시작되고 거짓이면 루프가 종료된다.

    변화식 : 매 루프마다 실행된다.

    위의 식으로 설명해보면
    초기식은 i = 1 이고 조건식은 i < 10 인데 이 때 결과는 참이므로 코드블럭 안에 있는 내용이 실행된다.
    변화식이 i++ 이므로 실행 후 i = i + 1이 된다.
    (++i 일 경우 코드블럭이 실행 전에 i = i + 1이 먼저 시행된다.)

    쭉 진행하다가 i = 10 이 된 순간 조건식의 결과가 거짓이 되므로 반복문은 중단되게 된다.

    for를 이용한 반복문은 다른 방법도 있는데
    ```
	int[] list = {1,2,3,4,5};

	for(int val : list) {
		System.out.println(val);
	}
    ```
    for문이 실행될 때 마다 val(초기식)에 list배열의 내용을 순서대로 저장하여 반복문을 실행하는 방식이다

    이를 구구단에 적용해보면
    ```
    import java.util.Scanner;

    public class Gugudan {
        public static void main(String[] args) {
            System.out.println("구구단을 출력할 단은?");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("number : " + number);	
            
            int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for(int i : list) {
                System.out.println(number + " * " + i +" = " + number * i);
            }
            
        }
    }

    ```
    로 적용해볼수 있다.

