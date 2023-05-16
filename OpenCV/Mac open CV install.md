# M1 MAC에서 OpenCV 설치하기

1. Homebrew 설치
2. OpenCV 설치
3. OpenCV 설치 확인
4. cmake 설치
5. 작업할 폴더 생성
6. main.cpp 생성 및 코드 작성
7. CMakeLists.txt 생성
8. CMakelists.txt 수정
9. OpenCV 컴파일
10. OpenCV 실행


## 1. Homebrew 설치

Homebrew는 macOS에서 사용하는 패키지 관리자입니다. Homebrew를 사용하면 macOS에서 손쉽게 패키지를 설치할 수 있습니다.

터미널을 열고 아래 명령어를 입력합니다.

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

설치가 완료되면 아래 명령어를 입력하여 Homebrew가 제대로 설치되었는지 확인합니다.

```bash
brew -v
```

## 2. OpenCV 설치

터미널에 아래 명령어를 입력하여 OpenCV를 설치합니다.

```bash
brew install opencv
```

## 3. OpenCV 설치 확인

아래 명령어를 입력하여 OpenCV가 제대로 설치되었는지 확인합니다.

```bash
pkg-config --modversion opencv4
```

## 4. cmake 설치

터미널에 아래 명령어를 입력하여 cmake를 설치합니다.

```bash
brew install cmake
```

## 5. 작업할 폴더 생성

작업할 폴더를 생성합니다.

```bash
mkdir opencv
cd opencv
```
그 후 VSCODE에서 해당 폴더를 엽니다.

## 6. main.cpp 생성 및 코드 작성

VSCODE에서 main.cpp를 생성하고 아래 코드를 작성합니다.

```cpp
#include <opencv2/opencv.hpp>
#include <iostream>

using namespace cv;
using namespace std;

int main(int argc, char** argv) {
    Mat img = imread("image.jpg");
    if (img.empty()) {
        cout << "Could not open or find the image" << endl;
        return -1;
    }
    imshow("Display window", img);
    int k = waitKey(0);
    if (k == 's') {
        imwrite("starry_night.png", img);
    }
    return 0;
}
```

## 7. CMakeLists.txt 생성

VSCODE에서 CMakeLists.txt를 생성합니다.


## 8. CMakelists.txt 수정

VSCODE에서 CMakeLists.txt를 열고 아래 코드를 추가합니다.

```cmake
cmake_minimum_required(VERSION 3.10)
project(MyProject)
find_package(OpenCV REQUIRED)
add_executable(MyProject tutorial.cpp)
target_link_libraries(MyProject ${OpenCV_LIBS})
```


## 9. OpenCV 컴파일

터미널에 아래 명령어를 입력하여 OpenCV를 컴파일합니다.

```bash
mkdir build
cd build
cmake ..
make
```

## 10. OpenCV 실행

터미널에 아래 명령어를 입력하여 OpenCV를 실행합니다.

```bash
./MyProject
```

## 참고

[https://docs.opencv.org/master/d0/db2/tutorial_macos_install.html](https://docs.opencv.org/master/d0/db2/tutorial_macos_install.html)