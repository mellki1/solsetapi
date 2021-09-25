cd  ./../../../../
mvn clean install && docker build -t melquisedeque/solset . && docker push melquisedeque/solset
