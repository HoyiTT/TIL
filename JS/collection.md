# 컬렉션

JavaScript에서 컬렉션 타입(Collection Types)은 여러 개의 값을 하나의 단위로 묶어서 관리할 수 있는 데이터 구조를 의미한다. 

이러한 컬렉션 타입은 배열, 객체 등과 같이 JavaScript에서 자주 사용되는 데이터 구조입니다. 

1. **배열 (Array)**:
   - 순서가 있는 값들의 리스트
   - 각 값은 인덱스로 접근할 수 있다
   - 배열의 값은 어떠한 타입도 될 수 있다.
   - 예시:
     ```javascript
     let fruits = ["apple", "banana", "cherry"];
     console.log(fruits[0]); // "apple"
     ```

2. **객체 (Object)**:
   - 키-값 쌍의 집합
   - 각 값은 키를 통해 접근할 수 있다.
   - 객체의 키는 문자열 또는 심볼이어야 하며, 값은 어떠한 타입도 될 수 있다.
   - 예시:
     ```javascript
     let person = {
       name: "John",
       age: 30
     };
     console.log(person.name); // "John"
     ```

3. **맵 (Map)**:
   - 키-값 쌍의 집합입니다.
   - 객체와 달리, 맵의 키는 모든 타입이 될 수 있다.
   - 순서를 유지
   - 예시:
     ```javascript
     let map = new Map();
     map.set("name", "John");
     map.set(1, "one");
     console.log(map.get("name")); // "John"
     console.log(map.get(1)); // "one"
     ```

4. **셋 (Set)**:
   - 유일한 값들의 집합
   - 중복된 값이 없다
   - 순서를 유지
   - 예시:
     ```javascript
     let set = new Set();
     set.add(1);
     set.add(2);
     set.add(2); // 중복된 값은 무시됩니다.
     console.log(set.has(1)); // true
     console.log(set.size); // 2
     ```

5. **위크맵 (WeakMap)**:
   - 키는 반드시 객체
   - 키에 대한 약한 참조를 유지하여, 가비지 컬렉션이 가능
   - 예시:
     ```javascript
     let weakMap = new WeakMap();
     let obj = {};
     weakMap.set(obj, "value");
     console.log(weakMap.get(obj)); // "value"
     ```

6. **위크셋 (WeakSet)**:
   - 값은 반드시 객체
   - 값에 대한 약한 참조를 유지하여, 가비지 컬렉션이 가능
   - 예시:
     ```javascript
     let weakSet = new WeakSet();
     let obj = {};
     weakSet.add(obj);
     console.log(weakSet.has(obj)); // true
     ```

이러한 컬렉션 타입들은 각각의 특성과 용도에 맞게 사용되어 효율적인 데이터 관리와 조작을 가능하게 함.