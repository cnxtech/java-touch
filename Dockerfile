FROM java

COPY Touch.java Touch.java
RUN javac Touch.java
RUN touch file && chmod 666 file

RUN adduser --disabled-password --gecos "" user
USER user

ENTRYPOINT ["java", "Touch"]

CMD ["bad"]
