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
    변수를 사용하기 위해서는 먼저 변수를 선언해야 한다. 
    
    변수 선언은 어떤 변수에 어떤 타입의 데이터를 저장할 것인지 그리고 변수 이름은 무엇인지를 결정한다.
    
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

# 8, 9단 구현 - 값 입력 및 조건문
* 코드
    ```
    import java.util.Scanner;

    public class Gugudan {
        public static void main(String[] args) {
            System.out.println("구구단을 출력할 단은?");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("number : " + number);	
            
            if (number < 2) {
                System.out.println("숫자가 2이하입니다.");
            } else if (number > 9) {
                System.out.println("숫자가 9보다 큽니다");
            } else {
                int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                for(int i : list) {
                    System.out.println(number + " * " + i +" = " + number * i);
                }
            }
        }
    }

    ```
* 결과
    * 결과 1
        ```
        구구단을 출력할 단은?
        1
        number : 1
        숫자가 2이하입니다.

        ```
    * 결과 2
        ```
        구구단을 출력할 단은?
        11
        number : 11
        숫자가 9보다 큽니다

        ```
    * 결과 3
        ```
        구구단을 출력할 단은?
        8
        number : 8
        8 * 1 = 8
        8 * 2 = 16
        8 * 3 = 24
        8 * 4 = 32
        8 * 5 = 40
        8 * 6 = 48
        8 * 7 = 56
        8 * 8 = 64
        8 * 9 = 72

        ```
* 정리
    구구단을 출력할 때 2 ~ 9단 사이만 출력되도록 하기 위해 조건을 걸어주는 코드이다.

    이렇게 조건을 걸어야 할 때에는 if else문을 사용한다.
    ```
    if (number < 2) {
        System.out.println("숫자가 2이하입니다.");
    } else if (number > 9) {
        System.out.println("숫자가 9보다 큽니다");
    } else {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for(int i : list) {
                System.out.println(number + " * " + i +" = " + number * i);
                }
            }
    ```

    순서도를 이용하여 설명해보자면

    <img src=img/gugudan1.png>

    첫 if문인 
    ```
    if (number < 2) {
        System.out.println("숫자가 2이하입니다.");
    }
    ```
    에서 입력한 값이 2이하라면 "숫자가 2이하입니다."라는 출력값이 나오고

    아니라면 바로 뒤에 붙은 else if문으로 넘어간다
    ```
    if (number < 2) {
        System.out.println("숫자가 2이하입니다.");
    } else if (number > 9) {
        System.out.println("숫자가 9보다 큽니다");
    }
    ```

    이 때에 입력한 값이 9보다 크다면 "숫자가 9보다 큽니다"라는 출력 값이 나오고

    아니라면 바로 뒤에 붙은 else 넘어가 구구단이 출력되게 된다.
    ```
     if (number < 2) {
        System.out.println("숫자가 2이하입니다.");
    } else if (number > 9) {
        System.out.println("숫자가 9보다 큽니다");
    } else {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i : list) {
            System.out.println(number + " * " + i +" = " + number * i);
        }
    }
    ```
# 배열로 구구단 다시 구현
* 코드
    ```
    public class Gugudan {
        public static void main(String[] args){
            int[] result = new int[9];
            for(int i = 2; i < 10; i++) {
                for(int k = 1; k < 10; k++) {
                    result[k-1] = i * k;
                    System.out.println(i+" * " + k + " = " +result[k-1]);
                }
            }
        }
        
    }
    ```
* 결과
    ```
    2 * 1 = 2
    2 * 2 = 4
    2 * 3 = 6
    2 * 4 = 8
    2 * 5 = 10
    2 * 6 = 12
    2 * 7 = 14
    2 * 8 = 16
    2 * 9 = 18
    ...
    8 * 9 = 72
    9 * 1 = 9
    9 * 2 = 18
    9 * 3 = 27
    9 * 4 = 36
    9 * 5 = 45
    9 * 6 = 54
    9 * 7 = 63
    9 * 8 = 72
    9 * 9 = 81
    ```

* 정리

    배열이란 각 데이터를 연속된 공간에 나열허고, 각 데이터에 인덱스를 부여해놓은 자료구조를 말한다.

    생성방식
    ```
    타입[] 변수 = new 타입[길이];
    ```

    ```
    int[] result = new int[9];
    ```
    int형의 길이는 9인 배열 객체를 생성해주었다. 
    new 연산자로 배열을 처음 생성할 경우 배열은 자동적으로 기본값으로 초기화된다.

    <img src=img/array1.png>

    위의 그림이 현재 생성된 배열의 모습이다.

    반복문을 이용하여 대입 연산자를 사용하여 배열에 데이터를 넣어주면 

    ```
    for(int i = 2; i < 10; i++) {
        for(int k = 1; k < 10; k++) {
            result[k-1] = i * k;
            System.out.println(i+" * " + k + " = " +result[k-1]);
        }
    }
    ```
    위의 코드는 각 단(2단,3단...)을 result 배열 객체에 대입연산자를 이용해 저장하고
    출력한뒤 그 다음 단을 저장하고 출력하는 방식이다.

    <img src=img/array2.png>
    2단이 입력되었을 때 에는 이러한 형식으로 저장되게 된다.     

    입력된 배열을 바탕으로 각 단을 중첩 반복문을 이용하여 출력한다.

# 메소드 활용해 구구단 다시 구현
* 코드
    ```
    public class Gugudan {
        public static int[] caculate(int times) {
            int[] result = new int[9];
            
            for(int i = 0; i < result.length; i++) {
                //계산 결과를 배열에 저장
                result[i] = times * (i + 1); 
            }
            
            return result;
        }
        
        public static void print(int[] result) {
            for(int i = 0; i < result.length; i++) {
                //계산 결과를 화면에 출력
                System.out.println(result[i]);
            }
            
        }
        
        
        public static void main(String[] args){
            for(int j =2; j < 10; j++) {
                int[] result = caculate(j);
                print(result);
            }
            
        }
        
    }
    ```
* 결과
    ```
    2
    4
    6
    8
    10
    12
    14
    16
    18
    ...
    9
    18
    27
    36
    45
    54
    63
    72
    81
    ```
* 정리
    
    메소드 선언은 선언부(리턴 타입, 메소드 이름, 매개 변수 선언)와 실행 블록으로 구성된다.
    ```
    public static int[] caculate(int times) {
            int[] result = new int[9];
            
            for(int i = 0; i < result.length; i++) {
                //계산 결과를 배열에 저장
                result[i] = times * (i + 1); 
            }
            
            return result;
        }
    ```
    위 메소드는 계산 결과를 배열에 저장해주는 메소드로서 리턴 타입이 int형 배열 객체이기에 int형 리턴 타입인 메소드로 선언되었다. 매개 변수로는 계산하고 저장여야 할 단의 숫자가 주어졌다.

    ```
    public static void print(int[] result) {
            for(int i = 0; i < result.length; i++) {
                //계산 결과를 화면에 출력
                System.out.println(result[i]);
            }
            
        }
    ```
    위 메소드는 그저 배열의 값들을 출력해주는 메소드로서 따로 리턴 타입이 필요가 없다. 따라서 void로 선언 되었다. 매개변수로는 출력해야할 배열 객체가 주어졌다.
    
    메소드 이름은 자바 식별자 규칙에 맞게 작성하면 된다.
        
        * 숫자로 시작하면 안되고, $와 _를 제외한 특수문자를 사용하지 말아야 한다.
        * 관례적으로 메소드 이름은 소문자로 작성한다.
        * 서로 다른 단어가 혼합된 이름이라면 뒤이어오는 단어의 첫 글자는 대문자로 작성한다. ex)startEngine, goShoot...


# 클래스를 활용해 다시 구현
* 코드

    Gugudan.java
    ```
    public class Gugudan {
        public static int[] caculate(int times) {
            int[] result = new int[9];
            
            for(int i = 0; i < result.length; i++) {
                //계산 결과를 배열에 저장
                result[i] = times * (i + 1); 
            }
            
            return result;
        }
        
        public static void print(int[] result) {
            for(int i = 0; i < result.length; i++) {
                //계산 결과를 화면에 출력
                System.out.println(result[i]);
            }
            
        }	
    }
    
    ```
    GugudanMain.java
    ```
    public class GugudanMain {
        public static void main(String[] args){
            for(int j = 2; j < 10; j++) {
                int[] result = Gugudan.caculate(j);
                Gugudan.print(result);
            }	
        }
    }
    ```
* 결과
    ```
    2
    4
    6
    8
    10
    12
    14
    16
    18
    ...
    9
    18
    27
    36
    45
    54
    63
    72
    81
    ```
* 정리
    
    클래스를 생성하여 코드를 분리할 수 있다.
    다른 클래스에 있는 메소드를 사용하기 위해서는 
    ```
    클래스이름.메소드이름
    ```
    방식으로 사용할 수 있다.

    

