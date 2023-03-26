Flutter를 공부하며 발생한 오류들을 기록합니다.

### Flutter build 오류

error 메시지가 출력되며 실행이 되지 않음

오류 원인

추측컨데, 사용자 명이 한글로 되어 있어 FLutter build가 되지 않는 것 같다.

사용자명과 사용자 users 안에 있는 폴더를 영어로 변경하니 애러메시지는 변경되었지만 빌드는 되지 않았다.

해결방법

구글링한 결과 stack overflow에서 아래와 같은 해결방법을 찾을 수 있었다.

flutter clean

을 입력하니 정상적으로 build가 되었다.



