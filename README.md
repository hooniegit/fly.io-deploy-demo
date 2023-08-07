# fly.io-deploy-demo
: 간단한 spring project를 fly.io로 배포하는 파이프라인을 포함하고 있습니다 :)

### Architecture
<img width="973" alt="스크린샷 2023-08-07 오전 10 34 44" src="https://github.com/hooniegit/fly.io-deploy-demo/assets/130134750/631e3ad4-88bf-487c-9715-0b3383dacbee">


# DEV
### DEV Environment
- java 17
- gradle 8.2.1
- springbooy 3.1.2

### DEV commands
``` bash
# 빌드 명령어
$ gradle build

# 테스트 명령어
$ gradle test

# 패키징 명령어
$ gradle bootJar

# 배포 명령어
$ flyctl deploy --image <이미지명>
```

# Deploy
### 📝 전제 조건
1. Jenkins 서버가 설치되어 있어야 합니다.
2. Fly.io 토큰이 Jenkins에 등록되어 있어야 합니다.
3. Fly CLI가 Jenkins 서버에 설치되어 있어야 합니다.
4. Spring 어플리케이션 소스 코드가 Jenkins 서버에 접근 가능한 위치에 있어야 합니다.
5. Docker가 Jenkins 서버에 설치되어 있어야 합니다. ***

### 🛠️ 단계 1: 새로운 파이프라인 생성
1. Jenkins 대시보드에 로그인합니다.
2. 좌측 메뉴에서 "새로운 Item 만들기"를 클릭합니다.
3. "Item 이름"란에 원하는 파이프라인 이름을 입력하고, "Freestyle project"를 선택합니다.
4. "OK" 버튼을 클릭하여 파이프라인을 생성합니다.

### 📦 단계 2: 소스 코드 가져오기
1. "소스 코드 관리" 섹션에서 소스 코드의 버전 관리 시스템(Git, Subversion 등)을 선택하고 해당 저장소의 URL을 입력합니다.
2. 인증 정보를 설정하고 브랜치를 지정합니다.

### 👷‍♂️ 단계 3: 빌드 설정
1. 빌드 단계 추가를 클릭하고 "Invoke Gradle script"를 선택합니다.
2. "Use Gradle Wrapper"를 선택하고, Gradle 설치를 설정합니다.
3. "Tasks" 필드에 Gradle 빌드 명령어를 입력합니다. Spring 어플리케이션을 빌드하기 위해 일반적으로 "build"와 같은 명령어를 입력합니다.

### ✈️ 단계 4: Deploy to Fly.io 파이프라인 단계 추가
1. 빌드 단계 추가를 클릭하고 "Pipeline Script"를 선택합니다.
2. 아래의 파이프라인 스크립트를 입력합니다. 해당 스크립트는 Fly.io로 배포하는 과정을 수행합니다.
```groovy
pipeline {
    agent any

    environment {
        FLY_ACCESS_TOKEN = credentials('fly-io-token') // Jenkins에 등록한 Fly.io 토큰 Credential ID
        DOCKER_IMAGE_TAG = 'your-docker-image:latest' // Jenkins에서 빌드한 Docker 이미지 이름과 태그
        FLY_APP_NAME = 'your-fly-app-name' // Fly.io에 배포할 앱의 이름
    }

    stages {
        stage('Build') {
            steps {
                // 여기에 Jenkins 빌드 단계를 설정합니다.
                // Spring 어플리케이션 빌드 및 Docker 이미지 생성
            }
        }

        stage('Deploy to Fly.io') {
            steps {
                script {
                    // Fly.io에 인증
                    sh "flyctl auth login --access-token ${FLY_ACCESS_TOKEN}"

                    // Fly.io에 앱 생성 (이미 생성했다면 생략 가능)
                    sh "flyctl apps create ${FLY_APP_NAME}"

                    // Fly.io에 배포
                    sh "flyctl deploy --image ${DOCKER_IMAGE_TAG}"
                }
            }
        }
    }
}
```

### 💌 단계 5: 저장 및 빌드 실행
1. 파이프라인 설정 페이지의 상단에 "저장"을 클릭하여 파이프라인 설정을 저장합니다.
2. "Build Now" 버튼을 클릭하여 파이프라인을 실행합니다.

Jenkins는 설정한 파이프라인 단계를 따라서 Spring 어플리케이션을 빌드하고, Fly.io에 자동으로 배포합니다. Fly.io에 토큰을 사용하여 인증하기 때문에 Fly.io에 직접 Docker 이미지를 푸시하지 않아도 애플리케이션을 자동으로 배포할 수 있습니다.
