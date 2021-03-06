FROM hseeberger/scala-sbt:11.0.9.1_1.4.4_2.12.12

ENV CHECKERS_UI_TYPE=tui

RUN \
    apt-get update && \
    apt-get install -y libxrender1 libxtst6 libxi6 openjfx


ADD . /sources

WORKDIR /sources
RUN sbt compile

CMD sbt run