# Android 오류일지
Android를 공부하며 발생한 오류들을 기록합니다.

### 버튼 색상 변경되지 않음

오류 원인

다음과 같이 activity_main.xml 파일에 버튼을 추가하고, 버튼의 색상을 변경하였다.

```xml
<Button
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#DF6D6D"
        android:text="네이트입니다"></Button>
```

그러나, 실행 결과는 색상이 변경되지 않았다.

알아보니 

res/values/styles.xml 파일에
    
 ```xml
<style name="AppTheme" 
    parent="Theme.AppCompat.Light.DarkActionBar">
</style>
```

이 부분이 원인이었다.

이 부분을 다음과 같이 변경하니 색상이 변경되었다.

```xml
<style name="Theme.MyApplication" parent="Theme.AppCompat.Light">
</style>
```

기본값으로 정해진 Style 값이 문제였다.

### 맥에선 빌드가 잘 되지만 윈도우에선 되지 않음

해결 중



### 안드로이드 스튜디오 java.net.SocketException: socket failed: EPERM (Operation not permitted) 에러 

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```
소켓 통신을 위한 premission을 추가해주었는데도 불구하고 위와 같은 에러가 발생하였다.

해결 방법

AVD에 설치된 어플을 지웠다가 재설치하니 해결되었다.
