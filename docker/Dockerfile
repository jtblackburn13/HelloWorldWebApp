FROM adoptopenjdk/openjdk8:alpine-slim

ENV AWS_ACCESS_KEY_ID XXXXX
ENV AWS_SECRET_ACCESS_KEY YYYYYY
ENV AWS_DEFAULT_REGION eu-central-1

ENV APP_NAME swyp

LABEL maintainer="Marc Logemann<marc.logemann.extern@swyp.com>"
ADD VERSION .

RUN apk update

# Install base and dev packages
RUN apk add --no-cache --virtual .build-deps
RUN apk add nano

# Install build packages
RUN apk add openssh curl

# install tini
RUN apk add --no-cache tini

# Set timezone to UTC by default
RUN apk add -U tzdata
RUN cp /usr/share/zoneinfo/Europe/Berlin /etc/localtime

# Install aws-cli
RUN apk -Uuv add groff less python py-pip
RUN pip install awscli
RUN apk --purge -v del py-pip
RUN rm /var/cache/apk/*

COPY entrypoint.sh /bin
COPY update.sh /bin
COPY startup.sh /bin
RUN ["chmod", "+x", "/bin/entrypoint.sh"]
RUN ["chmod", "+x", "/bin/update.sh"]
RUN ["chmod", "+x", "/bin/startup.sh"]

VOLUME /swyp/bin
VOLUME /swyp/data

# use tini to avoid zombie processes and allow better shutdown
ENTRYPOINT ["/sbin/tini", "-e", "143", "-g", "--", "/bin/entrypoint.sh"]
CMD ["/bin/startup.sh"]
