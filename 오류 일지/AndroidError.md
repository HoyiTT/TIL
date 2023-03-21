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



