package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

//public class QaTest {
 //   @Test
 //   void mentoringPriceShouldBe47000Test() {
        /*
        * Тест-кейс - проверить что предоплата по обучению - 47000 рублей
        * 1. Открыть поисковик (Яндекс)
        * 2. Ввести данные сайта (bulgakov qa)
        * 3. Нажать кнопку поиск
        * 4. В поисковой выдаче найти нужный сайт, кликнуть на него
        * 5. Нажать на кнопку стоимость
        * 5. Нажать на кнопку "Хочу вкатиться в QA"
        * 5. Нажать на кнопку "Бегу оплачивать"
        * 6. Проверить, что к оплате 47000 рублей
        * */
     //  Configuration.holdBrowserOpen = true;

   //     open("https://ivanbulgakovqa.ru");
        /* $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();
        if ($(".DistributionButtonClose").exists()) {
            $(".DistributionButtonClose").click();
        }
        $(byText("ivanbulgakovqa.ru")).click();
        sleep(3000);
        switchTo().window(1); */
  //   $$(".t-menu__list li").get(4).click();
  //      $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a/div/span").click();
  //      $(byText("Бегу оплачивать")).click();
   //     sleep(5000);
  //      switchTo().window(1);
    //    $(".styles-module-scss-module__t92_WG__price h2").shouldHave(text(" 47 000.00 "));


//    }
//}
 //  public class QaTest_2 {
   //    @Test
   //    void LoginInAndSendMessageGmail() {
           /*
            * Тест-кейс - залогиниться в Gmail и отправить сообщение с темой
            * 1. Перейти на сайт Gmail
            * 2. Нажать "Войти"
            * 2. Заполнить поле "Телефон или адрес эл. почты" (alexandertest73@gmail.com)
            * 3. Нажать "Далее"
            * 4. Ввести пароль (1609Test)
            * 5. Нажать "Далее"
            * 6. В окне "Быстрее входите в аккаунт" нажать "Не сейчас"
            * 7. Нажать "Отмена"
            * 8. Нажать "Пропустить"
            * 9. Нажать "Написать"
            * 10. Ввести данные в строке "Кому" (ilderovilderov@gmail.com)
            * 11. Ввести данные в строке "Тема" (Первый тест)
            * 12. Ввести данные в тело письма (Привет!)
            * 13. Нажать отправить
            * 14. Увидеть "Сообщение отправлено."
             */
     //      Configuration.holdBrowserOpen = true;
      //     open("https://mail.google.com/");
      //     $("[type=email]").setValue("alexandertest73@gmail.com");
       //    $("[id=identifierNext]").click();
       //    sleep(5000);
       //    $("[type=password]").setValue("1609Test");
       //    $("[id=passwordNext]").click();



 //      }
 //  }

   public class QaTest_2 {
       @Test
       void practiceFormDemoQA() {
           /*
           * 1. Перейти сразу на практическую форму по ссылке https://demoqa.com/automation-practice-form
           * 2. Заполнить поля имени и фамилии
           * 3. Заполнить поле с email
           * 4. Выбрать пол
           * 5. Заполнить поле с номером телефона 9930900333
           * 6. Выбрать дату рождения
           * 7. Заполнить поле с увлечениями
           * 8. Выбрать хобби
           * 7. Подгружаем картинку
           * 8. Заполнить поле с адресом
           * 9. Выбрать штат и город
           * 10. Нажать кнопку Submit
           * 11. Проверить появление фразы Thanks for submitting the form
           */
           Configuration.holdBrowserOpen = true;
           open("https://demoqa.com/automation-practice-form");


           // Пока что мне удобнее ставить id, class и тд. вместо символов, а то пока путаюсь + почему-то иногда ошибку выдает когда ставлю # вместо id.

           $("[id=firstName]").setValue("Alexander");
           $("[id=lastName]").setValue("Test");
           $("[id=userEmail]").setValue("alexander@test.ru");
           $("[id=gender-radio-1]").click();
           $("[id=userNumber]").setValue("9930900333");
           $("[id=dateOfBirthInput]").click();
           $("[class=react-datepicker__year-select]").click(); // еще дату можно было от руки написать в формате 20 Dec 1996, добавил clear().
           $(byText("1996")).click();
           $("[class=react-datepicker__month-select]").click();
           $(byText("December")).click();
           $$("[class=react-datepicker__week] div").get(19).click(); // методом тыка подобрал. Так и не смог сделать так, что бы программа на число 20 нажала.
           $("[id=subjectsInput]").setValue("A"); // возможно лучше было выбрать элемент через get(), но сделал как сделал
           $(byText("Arts")).click();
           $("[id=subjectsInput]").setValue("Com");
           $(byText("Computer Science")).click();
           $("[id=hobbies-checkbox-2]").click();
           $("[id=hobbies-checkbox-3]").click();
           $("[id=uploadPicture]").uploadFromClasspath("obezgan.jpg"); // тут заранее закинул картинку в \src\test\resources
           $("[id=currentAddress]").setValue("WWW LENINGRAD SBP TOCHKA RU");
           $("[id=state]").scrollTo().click(); //тест не срабатывал когда браузер в окне запускался. Добавил прокрутку до нужного элемента
           $(byText("NCR")).click();
           $("[id=city]").click();
           $(byText("Delhi")).click();
           $("[id=submit]").click();
           $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));



       }


   }