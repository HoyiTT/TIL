# Sping 오류 일지
Spring을 공부하며 발생한 오류들을 기록합니다.

###  An error happened during template parsing
오류 원인 

실제 엔티티의 필드명과 템플릿에서 사용하는 필드명이 다를 경우 발생합니다.

해결 방법

실제 엔티티의 필드명과 템플릿에서 사용하는 필드명을 동일하게 맞춰주면 해결됩니다.
오늘 같은 경우에는 엔티티의 필드명이 'CREATEDATE' 였지만  html에서 타임리프 엔진을 사용하며 DB를 불러들이는 과정에서 question.createDate로 사용하였습니다. 이때 'createDate'로 변경하니 정상적으로 동작하였습니다.

