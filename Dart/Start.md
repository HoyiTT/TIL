# Dart

Dart는 UI에 최적화되있다.

생산적인 개발환경을 가지고 있고

모든 플랫폼에서 빠르다.

## Dart의 특징

Dart는 2개의 컴파일러를 가지고 있다.

### Dart web compiler

Dart web compiler는 Dart VM에서 실행되는 Dart 코드를 JavaScript로 컴파일한다.

### Dart native compiler
Dart native compiler는 Dart VM에서 실행되는 Dart 코드를 여러 CPU 아키텍처에 맞게 변환해준다.

### JIT and AOT

Dart VM은 JIT와 AOT를 지원한다.

JIT는 Just In Time의 약자로, 프로그램이 실행되는 동안에 코드를 컴파일하는 방식이다.

AOT는 Ahead Of Time의 약자로, 프로그램이 실행되기 전에 코드를 컴파일하는 방식이다.

### null safety

Dart는 null safety를 지원한다.

Dart 에는 처음에 AOT가 없었다. 하지만 Flutter가 나오면서 AOT가 필요해졌다. 필요에 따라 AOT가 추가되었다. 그리고 Dart VM은 JIT와 AOT를 지원하게 되었다.

다른 프레임워크였다면 이러한 추가는 불가능하지만 Dart는 가능하다.
(예: React js를 빨리 작동시키기 위해 js를 수정하는 것은 불가능하다.)