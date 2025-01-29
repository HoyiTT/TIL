# Call By Value VS Call By Reference

## Call By Value (값에 의한 호출)

- 함수 호출 시, 깂 지체를 넘겨주는 방식. 메서드를 호출하는 함수의 변수와 호출된 함수의 파라미터는 서로 다른 변수이다.

자바는 Call By Value 방식만 존재한다.

```java

public class CallByValue {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println("Before swap: a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("After swap: a = " + a + ", b = " + b);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
```

위 코드를 실행하면 출력 결과는 다음과 같다.

```

Before swap: a = 10, b = 20

After swap: a = 10, b = 20

```

위 코드에서 swap 메서드를 호출할 때 a와 b의 값을 넘겨주었지만, swap 메서드에서 a와 b의 값을 변경해도 main 메서드의 a와 b의 값은 변경되지 않는다.

자바의 변수는 스택 영역에 할당됩니다. 이때, 변수의 타입이 원시 타입인 경우에는 값 또한 스택 영역에 저장됩니다. 그리고, 참조 타입인 경우 객체 자체는 힙 영역에 저장되고 스택 영역에 존재하는 변수가 객체의 주소를 가지고 있습니다.

만약 특정 메서드에 원시 타입의 변수를 인자로 전달하여 호출하면, 호출된 메서드의 해당 파라미터가 변경되어도 원본은 수정되지 않습니다. 왜냐하면, 호출된 메서드의 스택 프레임에 인자로 주어진 변수의 값이 복사되어 사용되기 때문입니다.

반면, 참조 타입의 변수를 인자로 전달하여 호출하는 경우에는 호출된 메서드 내부에서 원본이 수정될 수 있습니다. 하지만, 이러한 방식은 호출된 메서드의 스택 프레임에 참조 타입 변수를 중복하여 생성하기 때문에 값에 의한 호출로 판단됩니다. 가령, 다음과 같은 코드가 존재할 때, foo 메서드의 스택 프레임과 var 메서드의 스택 프레임에 각각 같은 student 객체의 주소를 가지고 있는 참조 타입 변수인 student가 존재합니다.





## Call By Reference (참조에 의한 호출)

- 함수 호출 시, 참조 지체를 넘겨주는 방식. 메서드를 호출하는 함수의 변수와 호출된 함수의 파라미터는 서로 같은 변수이다.

- 따라서 호출된 함수에서 파라미터의 값을 변경하면 호출하는 함수의 변수도 변경된다.

```python

def swap(a, b):
    a, b = b, a

a = 10
b = 20

print("Before swap: a = ", a, ", b = ", b)

swap(a, b)

print("After swap: a = ", a, ", b = ", b)

```

위 코드를 실행하면 출력 결과는 다음과 같다.

```

Before swap: a =  10 , b =  20

After swap: a =  20 , b =  10

```

위 코드에서 swap 함수를 호출할 때 a와 b의 값을 넘겨주었고, swap 함수에서 a와 b의 값을 변경하면 main 함수의 a와 b의 값도 변경된다.

파이썬은 Call By Reference 방식만 존재한다.
