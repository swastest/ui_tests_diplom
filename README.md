# Проект по автоматизации тестирования клининговой платформы "Чистота ру"
## <a target="_blank" href="https://www.navedudud.ru/">Платформа "Наведу чистоту точка ру"</a>
<p align="center">
<img title="logo" src="images/screenshots/Xpic001.jpg">
</p>


## :floppy_disk: Содержание:

- <a href="#computer-технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#notebook_with_decorative_cover-реализованные-проверки">Реализованные проверки</a>
- <a href="#electric_plug-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#arrow_forward-запуск-из-терминала">Запуск из терминала</a>
- <a href="#open_book-allure-отчет">Allure отчет</a>
- <a href="#hammer-allure-test-ops-отчет">Allure Test Ops отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-примеры-прохождения-тестов">Видео примеры прохождения тестов</a>

***

## :computer: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Postgresql" src="images/logo/Postgresql_elephant.svg.png">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

***

## :notebook_with_decorative_cover: Реализованные проверки
- Негативная проверка восстановления пароля незарегистрированным пользователем
- Проверка наличия соответствия Title
- Авторизация пользователя со статусом Активен
- Авторизация заблокированного пользователя
- Негативная проверка авторизации
- Всплывающее уведомление об отправке смс, с кодом подтверждая, отображается при запросе восстановления пароля
- Проверка стоимости уборки за 1 час, на главной странице
- Проверка контента на странице "Сотрудничество"
- Проверка отсутствия ошибок в консоли браузера

***

## :electric_plug: Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/swastest_ui_diplom/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/main_jen.png">
</p>  

***

## :arrow_forward: Запуск из терминала
Локальный запуск:
```
gradle clean test -Dhost=local 
```
## :gear: Запуск тестов с выбором параметров
<img title="Jenkins ParamStart" src="images/screenshots/param_jen.png">

Удаленный запуск:
```
clean
test
-Dhost=remote
-DbrowserName=${BROWSERNAME}
-DbrowserVersion=${VERSION}
-Dcity=${CITY}
-DbrowserSize=${BROWSERSIZE}
```
:monocle_face: Попробуйте - это очень удобно!
- -Dbrowser - можно выбрать браузер, который необходимо открыть именно вам
  (chrome,
  opera,
  firefox,
  safari)
- -DbrowserVersion - выберете нужную версию браузера
- -DbrowserSize - возможность управлять разрешением (1920x1080,
  1366x768,
  1280x1024,
  1280x800,
  1024x768)
- -Dcity - здесь вы можете выбрать свой город, для того чтобы узнать стоимость уборки :)

***

## :open_book: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure_main.png">
</p>

- ### Страница с проведенными тестами
*Можно подробно разобрать каждый шаг тест кейса, сбоку отображаются все шаги и тестовые данные*
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure_steps.png">
</p>

***

## :hammer: Allure Test Ops отчет
<p align="center">
<img title="Allure Test Ops Launch" src="images/screenshots/testOpsLaunch.png">
</p>

***

## :robot: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/screenshots/tg.png">
</p>

***
## :film_projector: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/screenshots/ezgif-3-7fe6118ad8.gif">
</p>

