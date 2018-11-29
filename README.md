java-touch
---

Reproduction

```sh
~/code/java-touch master* 12s
❯ docker build -t touch .
Sending build context to Docker daemon  44.03kB
Step 1/8 : FROM java
 ---> d23bdf5b1b1b
Step 2/8 : COPY Touch.java Touch.java
 ---> 2a60dabd99ad
Step 3/8 : RUN javac Touch.java
 ---> Running in 1e2c00efa407
Removing intermediate container 1e2c00efa407
 ---> a236913f5c40
Step 4/8 : RUN touch file && chmod 666 file
 ---> Running in 0b17acf58bfd
Removing intermediate container 0b17acf58bfd
 ---> 45c51b29e64e
Step 5/8 : RUN adduser --disabled-password --gecos "" user
 ---> Running in 8c0acc3ef7ba
Adding user `user' ...
Adding new group `user' (1000) ...
Adding new user `user' (1000) with group `user' ...
Creating home directory `/home/user' ...
Copying files from `/etc/skel' ...
Removing intermediate container 8c0acc3ef7ba
 ---> b10855d65779
Step 6/8 : USER user
 ---> Running in a1dd53b4fac2
Removing intermediate container a1dd53b4fac2
 ---> 37a0b56e03ed
Step 7/8 : ENTRYPOINT ["java", "Touch"]
 ---> Running in d01e342d58ab
Removing intermediate container d01e342d58ab
 ---> 1f254da0f2a8
Step 8/8 : CMD ["bad"]
 ---> Running in 110e6ea9c51d
Removing intermediate container 110e6ea9c51d
 ---> b7ad8b3c45d9
Successfully built b7ad8b3c45d9
Successfully tagged touch:latest

~/code/java-touch master* 2m 16s
❯ docker run --rm -it touch bad
1543517620000
Exception in thread "main" java.lang.Exception: Could not update time stamp for file
        at Touch.BadTouch(Touch.java:24)
        at Touch.main(Touch.java:14)

~/code/java-touch master*
❯ docker run --rm -it touch good
1543517620000
1543517686000
```
