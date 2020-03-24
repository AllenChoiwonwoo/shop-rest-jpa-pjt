## cns-boot  
### Codepresso Simple SNS project for practice  
### 메인화면
![main](./images/cns-boot.png)
---  
### 프로젝트 소개
트위터 같은 sns 프로젝트 입니다
### 제작정보
codepresso 의 dev-ops 과정을 수강하면 작성한 프로젝트입니다.  
##### http://codepresso.kr/  
### 사용기술
* springboot  
* MySQL
* JPA 
* Freemarker  
### 필수조건 안내
* java 8 이상이 필요합니다.  
* STS 설치권장  
* JPA
* MySQL 5.7  
### 설치 안내 
클론을 통해서 받아서 사용하면 됩니다.  
주의할것은  src/main/resources/application.properies 파일을 보안상의 문제로 git 에는 업로드 하지 않았습니다.  
그래서 제가 사용한 기본값들을 올리니 사용자에 맞게 작성해 사용하면 됩니다.  
#프리마커 파일(.ftl)의 위치/확장자 지정
    
    ## DataBase Connection 정보 설정
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver(사용자에 맞게 작성)
	spring.datasource.url=db-url (전 rds 사용) 
	spring.datasource.username=사용자
	spring.datasource.password=비밀번호
	
	#JPA Setting
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.generate-ddl=false
	spring.jpa.show-sql=true
	# MySQL'5or8'Dialect : mysql 버전에 따라 다르게 한다.
	spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
	#이 속성은 ]PA 구현체로 사용할 하이버네이트가 생성한 SQL을 콘솔에 출력할 지 여부를 결정한다.
	spring.jpa.properties.hibernate.format_sql=true
	#DB에 테이블 생성시 컬럼명이 강제로 카멜형을 따르는것 없에기 - 
	spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
	
   
	#Logging Setting , hibernate 가 어떻게 작동하는지 볼 수 있는 logging 설정 ( sql 쿼리를 볼 수 있다.)
	logging.level.org.hibernate=info

### 실행방법

   - 참고 블로그 : https://www.leafcats.com/178
* 
    

### 저작권
codepresso  
![codepresso log](./images/codepresso-logo.png)