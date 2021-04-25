# Проект отправки резюме работодателю Playrix.ru
https://playrix.ru

# Используемые технологии
![Java](readme_files/icons/Java.png)
![Gradle](readme_files/icons/Gradle.png)
![JUnit5](readme_files/icons/JUnit5.png)
![Selenide](readme_files/icons/Selenide.png)
![Allure_Report](readme_files/icons/Allure.png)
![Jenkins](readme_files/icons/Jenkins.png)
![Selenoid](readme_files/icons/Selenoid.png)
![Telegram](readme_files/icons/Telegram.png)

- Java, Gradle
- Junit5, Selenide
- Allure
- Jenkins
- Selenoid
- Telegram Bot

# Описание
Тестирование UI элементов веб страницы.

- Автоматизированный запуск тестов из Jenkins
- Для кросс-браузерного тестирования используем Selenoid
- Отчет о пройденных тестах генерируется Allure, добавляем логи,скриншоты браузера, видео прохождения тестов
- Отправляем отчет тест-сессии в Telegram

## Отчеты Allure reports
### Jenkins сборка
![Jenkins job](./readme_files/JenkinsJob.png)
### Отчет о прохождении тест сьюта в Allure Report
![Allure report](./readme_files/AllureReportScreenshot.png)
### Отчет о прохождении тест сьюта в Allure TestOps
![Allure TestOps](./readme_files/AlluretestOpsScreenshot.png)
### Видео прохождения одного из тестов
![Video](./readme_files/VideoReport.gif)
## Уведомление в Telegram
![Telegram](./readme_files/TelegramReport.png)

## Ссылки
### Репозиторий GitHub
https://github.com/pulsaronline/vacancy_project.git
### Jenkins job
https://jenkins.autotests.cloud/job/c05-mBessudnov-lesson11-CV/16/
### Allure reports
https://jenkins.autotests.cloud/job/c05-mBessudnov-lesson11-CV/16/allure/
