FROM openjdk:8-jre
COPY svc /svc
EXPOSE 9002 9443
CMD /svc/bin/start -Dhttps.port=9443 -Dhttp.port=9002 -Dplay.crypto.secret=secret