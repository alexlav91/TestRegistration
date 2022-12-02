TestRegistration(Camunda)
---------
��������:
---------
TestRegistration(Camunda) - ���������� ��� ����������� ������������ �
���������� �������������� ����������� ��������������� � ������� ���� � 
����������� ����������� � �������.

---------
���������� � ���� ��������
---------
�������� �������

----
���������
------
������ ��������������� � ��������������:
1. ���� ���������������� Java 15 ������
2. ���� ������ (�� ��������� H2)
3. ��������� Spring Boot
4. ������� ������� Maven
5. Camunda-Api

��� ��������� ���������� ���������:
1. ��������� ������ ��� �������������� Camunda �, �� �������������, ��� ����������:
    ```
   camunda:
     bpm:
      admin-user:
       id: demo
       password: demo
       filter:
        create: All tasks
    ```
2. ������� ���� ������, ��������� ���������� ����� ��� ���� ������:
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
3. ����� ��� ����������� ������ ������������:  http://localhost:8080/index
4. ����� Camunda: http://localhost:8080
   
   
   
        
    






