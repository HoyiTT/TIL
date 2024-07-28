# 기본 명령어

git clone 깃 레포지토리 주소

git init 

git add 파일명
혹은
git add * (전체다)

git commit -m "메시지"

git push

git branch hhy

hhy 브랜치를 생성한다

git checkout hhy

hhy 브랜치로 이동한다

git push origin hhy

hhy 브랜치로 푸시한다.

git에 잘못 업로드한 파일 삭제

git rm --cached -r [폴더/파일이름]

git commit -m "Delete wrong file"

git push

깃 서브트리

변경 사항을 커밋
git add .
git commit -m "Save changes before adding subtree"

서브트리 추가
git subtree add --prefix=5.pwa https://github.com/HoyiTT/flask-pwa.git main

서브트리 업데이트
git subtree pull --prefix=5.pwa https://github.com/HoyiTT/flask-pwa.git main


main 브랜치의 최신내용을 원격 저장소로 부터 가져오기
git fetch origin main:main

서브 브랜치에 main 브랜치 병합
git merge main
