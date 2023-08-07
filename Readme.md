# spring-boot-actuator 파헤치기
https://www.inflearn.com/course/spring-boot-actuator-%ED%8C%8C%ED%97%A4%EC%B9%98%EA%B8%B0/dashboard

http://127.0.0.1:8080/actuator
```json
{
  "_links": {
    "self": {
      "href": "http://127.0.0.1:8080/actuator",
      "templated": false
    },
    "health": {
      "href": "http://127.0.0.1:8080/actuator/health",
      "templated": false
    },
    "health-path": {
      "href": "http://127.0.0.1:8080/actuator/health/{*path}",
      "templated": true
    }
  }
}
```

| 일자       | 학습내용                             |
|----------|----------------------------------|
| 20230805 | 섹션0                              |
| 20230806 | 섹션1 endpoints 설정 \n 커스텀 엔드포인트 설정 |

# 섹션0. 실습 프로젝트 생성 및 강의 개요
## 프로젝트 생성
[pom.xml](pom.xml)
## 공식 가이드 페이지, 의존성 라이브러리
[Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
[Production Ready Feature](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator)
## 강의 자료
https://semtul79.tistory.com/category/spring%20boot/actuator%20in%20spring%20boot

# 섹션1. actuator 기본 설정과 다양하 endpoint
## endpoints 설정
https://semtul79.tistory.com/13

endpoint는 각각 제어에 관련
endpoints는 노출 에 과련
## custom endpoints 생성

## health endpoint
show-component
show-detail

## info endpoint
