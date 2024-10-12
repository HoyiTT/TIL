# 애매모호한 Eroor들을 기록합니다

## github remote: fatal error in commit_refs

평소와 다름없이 커밋후 푸쉬를 했는데

``` git 
remote: fatal error in commit_refs
To https://github.com/HoyiTT/ggdormMenu.git
 ! [remote rejected] main -> main (failure)
error: failed to push some refs to 'https://github.com/HoyiTT/ggdormMenu.git'
```

라는 에러 메시지와 함께 푸쉬가 되지 않았다.

오류의 원인으로 세운 첫번째 가설은 

1. 바로 어제 윈도우계정명을 한글 -> 영어로 변경했기에 깃 설정이 꼬였다.

가 첫번째 가설이였다.

하지만  git config를 통해 설정을 뒤져보아도 윈도우 계정명이 적힌 곳은 없었다.

2. 로컬과 깃허브 레포지터리에 유무가 다른 파일이 있다.

구글링 해보니 이러한 오류는 서로 존재 유무가 다른 파일이 있을 때 발생한다고 한다.

```
git pull
```

명령어를 실행하고 다시 푸쉬를 해보았다.

하지만 똑같이 에러가 난다.

### 해결 방법

알고보니 그저 깃허브 서버가 터진것이였다.

https://www.githubstatus.com/

서버 상태는 이 사이트에서 확인 가능하다.

한시간정도? 만에 고쳐진 것 같다.

서버가 정상화 되었다는 메시지 확인 후 푸쉬하니 정상적으로 된다.

