# 브랜치 전략

## feature branch

- 각 기능별로 독립적인 브랜치를 생성하여 작업하는 전략
- 서로 작업에 영향을 주지 않고 효율적으로 협업

### 브랜치 생성
- 기준 브랜치에서 새로운 feature 브랜치 생성
- 브랜치 이름은 해당 기능을 설명하는 명칭 사용
- 일반적으로 'feature/기능명' 의 형식을 사용

```bash
git checkout -b feature/기능명
``` 

### 작업 진행
- 새로운 feature 브랜치에서 작업을 진행하고, 필요한 경우 여러 개의 커밋 생성

```bash
git add .
git commit -m "커밋 메시지"
```

### 원격 저장소 푸시
- 기준 브랜치로 병합하기 전에 원격 저장소에 feature 브랜치를 푸쉬

```bash
git push origin feature/기능명
```

### 머지
- 리뷰 후, 기준 브랜치에 feature 브랜치를 머지
- 머지 후 불필요한 feature 브랜치는 삭제

``` bash
git checkout main
git merge --no-ff feature/기능명

git branch -d feature/기능명
```

## Github Flow

- 규모가 작거나 중간 크기의 프로젝트에 적합
- 빠른 개발 주기와 지속적인 배포에 초점

### 브랜치 생성
- 기준 브랜치에서 새로운 브랜치 생성
- 브랜치 명은 작업 내용을 설명하는 명칭
- 기준 브랜치는 항상 배포 가능한 상태

```bash
git checkout -b new-feature
```

### 작업 진행

### 원격 저장소 푸쉬

### PR 생성
- Git Hub에서 PR 생성
- 코드 리뷰 완료 후, 기준 브랜치로 병합하고 pr 종료

## Git Flow

- 대규모 프로젝트에 적합

* Master : 프로덕션 환경에 배포되는 안정적인 코드가 저장되는 브랜치
* Develop : 다음 출시 버전을 개발하는 브랜치 (개발 중인 코드를 관리하는 브랜치)
* Feature : 기능 개발 브랜치 (Develop으로 부터 분기)
* Release : 새로운 버전 릴리즈를 준비하는 브랜치 (Develop으로 부터 분기)
* Hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치 (Master로 부터 분기)

## 새로운 기능 개방
- develop 브랜치에서 feature 브랜치 생성
- 기능 개발을 완료한 후 develop 브랜치로 병합

## 릴리스 준비
- develop 브랜치에서 release 브랜치 생성
- 버전 번호를 부여하고, 문서 작업 등 릴리스를 위한 작업 진행

## 릴리스 확정
- release 브랜치를 master 브랜치로 병합
- 해당 커밋에 태그를 추가하여 릴리스 버전 명시
- 이후 release 브랜치는 develop 브랜치로 머지

## 긴급한 버그 수정
- master 브랜치에서 발견한 버그는 hotfix 브랜치를 생성해서 수정
- 수정 완료 후 master와 develop 브랜치로 머지