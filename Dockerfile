FROM ubuntu:latest
LABEL authors="brahiam"

ENTRYPOINT ["top", "-b"]