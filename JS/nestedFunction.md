# nestedFunction(중첩함수)

함수 안에 또다른 함수를 선언하는 것.

```js
function foo(){
  function bar() {
        console.log('Hello');
  }

    bar(); // Hello가 출력된다.
}

bar(); // 에러발생!, bar is not defined
```