

# Deploy Process
### Need To Do
1. Local or Server \
: install flyctl and login - to create toml file
``` bash
$ brew install flyctl
$ flyctl auth login
```

2. Jenkins(Docker or Server) \
: install flyctl and login - to deploy
``` bash
# skip if already installed
$ apt-get install flyctl
$ flyctl auth login
```

### Process
1. Local or Server \
: launch
``` bash
# Prepare Dockerfile for better status
$ fly launch
```

2. Jenkins(Docker or Server) \
: deploy
<img width="1019" alt="스크린샷 2023-08-08 오후 2 26 12" src="https://github.com/hooniegit/fly.io-deploy-demo/assets/130134750/759672d6-5a6d-4be0-b274-edaf2d7453c6">
<img width="1005" alt="스크린샷 2023-08-08 오후 2 25 50" src="https://github.com/hooniegit/fly.io-deploy-demo/assets/130134750/c5c0ef68-a84b-4332-978d-7e9077670551">
