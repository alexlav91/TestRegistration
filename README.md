TestRegistration(Camunda)
---------
Описание:
---------
TestRegistration(Camunda) - приложение для регистрации пользователя с
дальнейшим подтверждением регистрации администратором и выводом лога о 
результатах регистрации в консоль.

---------
Назначение и цель создания
---------
Тестовое задание

----
Установка
------
Проект разворачивается с использованием:
1. Язык программирования Java 15 версии
2. База данных (по умолчанию H2)
3. Фреймворк Spring Boot
4. Сборщик проекта Maven
5. Camunda-Api

Для настройки приложения требуется:
1. Прописать данные для администратора Camunda и, по необходимости, для фильтрации:
    ```
   camunda:
     bpm:
      admin-user:
       id: demo
       password: demo
       filter:
        create: All tasks
    ```
2. Создать базу данных, прописать переменные среды для базы данных:
   ```
   spring:
     datasource:
       driver-class-name: org.h2.Driver
       url: jdbc:h2:file:./camunda-h2-database
     jpa:
      hibernate:
        ddl-auto: create
      generate-ddl: true
      properties:
        hibernate:
          dialect: org.hibernate.dialect.H2Dialect
   ```
3. Адрес для регистрации нового пользователя:  http://localhost:8080/index
4. Адрес Camunda: http://localhost:8080
   
   
   
        
    






