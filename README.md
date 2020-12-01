# T24-utilities

## UploadOFSFile
Java project to upload OFS messages through JMS queues into T24, from flat files

### Requirements
- Java 8
- JBOSS EAP 7
- T24 Enviroment (R19)

### Compilation
Download code, and build with IntelliJ via maven
** Maven will create one jar file UploadOFSFile-1.0-SNAPSHOT.jar, and a lib folder with the corersponding depdencies to use

### Execution
java -jar UploadOFSFile-1.0-SNAPSHOT.jar

- Logic will take ofs (*.ofs) files from the {{inputPath}} and process it, line by line
- Finally a new folder {{inputPath}}/output/{inputFileName} will be created
- Inside of that folder one file will be created for each line (#)-UUIDD where (#) is the original line number


### Configuration
Modify file UploadOFSFile-1.0-SNAPSHOT.jar>jndi.properties 

```
# JMS Connection
java.naming.factory.initial=org.jboss.naming.remote.client.InitialContextFactory
java.naming.provider.url=http-remoting://localhost:8080
java.naming.security.principal=BNKUSER01
java.naming.security.credentials=XXXXXX

# JNDI component
jmsConnectionFactory=jms/RemoteConnectionFactory
requestQueue=t24OFSQueue
responseQueue=t24OFSReplyQueue

#-------------------------------------------------------
#File Options
#-------------------------------------------------------
# folder with file(s) to process
inputPath=src/data
# Pattern of files' names to process
filePattern=.*.ofs
# true => will delete file, false => move to .camel folder
keepFile=false

#-------------------------------------------------------
#Processing Option
#-------------------------------------------------------
# max number of threads for requesting and consuming
maxNoOfThreads=10
# max number of message to process by second
maxNoOfReqBySec=100
```

