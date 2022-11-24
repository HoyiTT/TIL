# Map
Map은 Key와 value를 한 쌍으로 갖는 자료형이다. 여기서 Key와 Value는 모두 객체이다.

키는 중복 저장될 수 업지만 값은 중복 저장될 수 있다. 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체된다. 

|Key|Value|
|------|---|
|야구|야구공|
|축구|축구공|
|농구|농구공|

Map은 리스트나 배열처럼 순차적으로 요소 값을 구하지 않고 Key를 통해 Value를 얻는다.

예제
```
Map<String,Integer> map= ...;
map.put("박지성",33);
int age = map.get("박지성");
map.remove("박지성");
```

# HashMap
HashMap은 Map 인터페이스를 구현한 대표적인 Map컬렉션이다.

```
Map<K, V> map = new HashMap(K, V)();
```

```
Map<String,Integer> map=  HashMap<String, Integer>();
Map<String,Integer> map= HashMap<>();

//HashMAp의 K와 V 타입 파라미터를 생략하면 왼쪽 Map에 지정된 타입을 따라감
```
예제
```
import java.util.HashMap;

public class Sample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("people", 20);
        map.put("baseball", 21);
    }
}
```