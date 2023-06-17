# Getter, Setter을 사용하는 이유

객체들의 테이터(필드)를 외부에서 직접적으로 접근하는 것을 막기위해 사용

필드들을 private 접근 제한자로 막아둔 뒤 각 필드에 Getter, Setter로 접근하는 방식

이렇게 하는 이유

-> 객체의 무결성을 보장하기 위해


# 예시

``` java
//Getter
public 리턴타입 getFieldName() {
    return fieldName;
}

//Setter
public void setFieldName(타입 fieldName) {
    this.fieldName = fieldName;
}
```