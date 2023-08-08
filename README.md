

# Deploy Process
### Need To Do
1. Local or Server
: install flyctl and login - to create toml file
``` bash
$ brew install flyctl
$ flyctl auth login
```

2. Jenkins
: install flyctl and login - to deploy
``` bash
$ apt-get install flyctl
$ flyctl auth login
```

### Process
1. Local
: launch
``` bash
# Prepare Dockerfile for better status
$ fly launch
```

2. Jenkins
: deploy

