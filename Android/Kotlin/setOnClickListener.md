# setOnClickListener

## 1. setOnClickListener

예제
버튼 클릭 시 웹 브라우저를 띄워서 네이트 홈페이지를 띄워준다.

``` kotlin
btnNate = findViewById<Button>(R.id.button1)

btnNate.setOnClickListener{
            val mintent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"))
            startActivity(mintent)
        }
```

