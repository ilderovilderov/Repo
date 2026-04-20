package jUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class JunitTests {

    @Nested // - группировка тестов. Внутри создаем public class (см. ниже)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // - для выполнения тестов по порядку (антипаттерн)
    public class PositiveTests { // - вот этот public class для группировки тестов

        @Test
        @Order(3) // - порядок выполнения тестов
        @Timeout(2)
            // - тест упадёт через 2 секунды
        void Test1() {
            System.out.println("Test 1");
        }

        @RepeatedTest(3) // - тест повторится 3 раза (аннотация @Test не нужна)
        @Order(2)
        @DisabledOnOs(OS.MAC)
            // - тест не заработает на MacOS
        void Test2() {
            System.out.println("Test 2");
        }

        @Test
        @Disabled("Баг 123") // - тест пока что выключен из-за бага №123
        @EnabledIfEnvironmentVariable(named = "env", matches = "dev") // - переменная окружения
        @EnabledIfSystemProperty(named = "env", matches = "dev") // - системные переменные
        @Order(1)
        void Test3() {
            System.out.println("Test 3");
        }
    }

    @Nested
    public class NegativeTests {

        @Test
        void Test1() {
            System.out.println("Test 4");
            assertAll( // - если много Ассертов, то всех их можно засунуть в assertAll через запятую
                    () -> assertTrue(1 < 2),  // - и нужно вставить () ->
                    () -> assertFalse(1 > 2),
                    () -> assertEquals(1, 1),
                    () -> assertNotEquals(1, 2)
            );


        }

        @Test
        @Tag("negative") // - задает тег для негативных тестов. Для этого в BuildGradle нужно подключить теги
        @DisplayName("Этот тест для теста 1")
            // - задает название теста
        void Test2() {
            System.out.println("Test 5");
        }
    }

    @ParameterizedTest // - параметризованный тест. Это когда в тест можно передать некоторое количество значений
    @ValueSource(strings = {"Vlad", "Masha", "Sasha"})
        // - параметры (значения) теста
    void paramTest1(String name) {
        System.out.println(name);
    }

    enum Color {RED, GREEN, BLUE} // - задаем дискретные значения. Когда у нас должны быть только определенные параметры и никаких других.

    @ParameterizedTest
    @EnumSource(Color.class)
        // - задаем параметр Enum
    void paramTest2(Color color) {
        System.out.println(color.name());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Vlad", "Masha", "Sasha"})
        // - параметры (значения) теста
    void paramTest3(String name) {
        System.out.println(name);
    }

    @ParameterizedTest
    @MethodSource("wordLetterCountProvider") // - задаем метод, который написан ниже
    void paramTest4(String name, int count) {
        System.out.println("Имя: " + name + ", кол-во букв: " + count);
    }

    @ParameterizedTest
    @CsvSource({  // - берем данные из таблицы, таблицу расписываем в фигурных скобках
            "apple, 5",
            "banana, 6",
            "orange juice, 12"
    })
    void paramTest5(String fruit, int count) {
        System.out.println("Фрукт: " + fruit + ", кол-во букв: " + count);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/file.csv", numLinesToSkip = 1) // - тест берет параметры из таблицы, которая лежит в resources. Обязательно нужно ставить "/"
    void paramTest6 (String name, int count, String nation) { // - numLinesToSkip - пропустить первую строку в таблице
        System.out.println("Имя: " + name + ", кол-во букв: " + count + ", национальность: " + nation);
    }


    static Stream<Arguments> wordLetterCountProvider() {

        return Stream.of(
                Arguments.of("Vlad", 4),
                Arguments.of("Masha", 5),
                Arguments.of("Sasha", 5)
        );
    }
}


