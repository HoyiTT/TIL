Git `pull` 명령어 관련 내용을 추가하여 다시 정리해 보았습니다.  

```markdown
# Git 명령어 정리

## 1. 기본 설정
- **Git 초기화**  
  ```bash
  git init
  ```
- **Git 클론 (원격 저장소 복제)**  
  ```bash
  git clone <레포지토리 주소>
  ```
- **특정 브랜치를 클론**  
  ```bash
  git clone --branch <브랜치명> <레포지토리 주소>
  ```

## 2. 현재 상태 확인
- **저장소 상태 확인**  
  ```bash
  git status
  ```
- **현재 브랜치 확인**  
  ```bash
  git branch
  ```

## 3. 파일 추가 및 커밋
- **파일을 Stage 영역에 추가**  
  ```bash
  git add <파일명>
  ```
  또는 전체 추가  
  ```bash
  git add .
  ```
- **변경 사항 커밋**  
  ```bash
  git commit -m "커밋 메시지"
  ```

## 4. 원격 저장소와 동기화
- **원격 저장소에서 최신 내용 가져오기 (병합 없음)**  
  ```bash
  git fetch origin main:main
  ```
- **원격 저장소의 변경 사항을 가져와 병합 (fetch + merge)**  
  ```bash
  git pull origin main
  ```
- **로컬 브랜치와 원격 브랜치를 rebase 방식으로 동기화**  
  ```bash
  git pull --rebase origin main
  ```
  > `--rebase` 옵션을 사용하면 불필요한 병합 커밋을 피할 수 있습니다.  
- **로컬에 있는 모든 원격 브랜치 최신화**  
  ```bash
  git pull --all
  ```

## 5. 원격 저장소 업로드
- **커밋한 내용을 원격 저장소에 푸시**  
  ```bash
  git push
  ```
- **브랜치 푸시**  
  ```bash
  git push origin <브랜치명>
  ```

## 6. 브랜치 관련 명령어
- **브랜치 생성**  
  ```bash
  git branch <브랜치명>
  ```
- **브랜치 전환**  
  ```bash
  git checkout <브랜치명>
  ```
- **브랜치 병합 (main 브랜치를 현재 브랜치에 병합)**  
  ```bash
  git merge main
  ```

## 7. 잘못 업로드한 파일 삭제
- **Git에서 특정 파일 제거 (파일은 유지, Git 추적만 제거)**  
  ```bash
  git rm --cached -r <폴더/파일명>
  git commit -m "Delete wrong file"
  git push
  ```

## 8. Git 서브트리
- **변경 사항 커밋 (서브트리 추가 전 저장)**  
  ```bash
  git add .
  git commit -m "Save changes before adding subtree"
  ```
- **서브트리 추가**  
  ```bash
  git subtree add --prefix=<폴더명> <레포지토리 주소> <브랜치명>
  ```
- **서브트리 업데이트**  
  ```bash
  git subtree pull --prefix=<폴더명> <레포지토리 주소> <브랜치명>
  ```
## 9. git diff
- **변경 사항 확인**  
  ```bash
  git diff
  ```

```

