FROM ubuntu:latest
LABEL authors="Robert"

ENTRYPOINT ["top", "-b"]