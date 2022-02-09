package com.whiteship.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
클래스 레벨에서 테스트 이름 설정이 가능한데 ReplaceUnderscores.Class => _로 표시한 모든 부분은 공백으로 처리
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기 ╯°□°）╯")
        // 테스트 이름 설정 가능
    void create_new_study() {
        Study study = new Study(); // study 인스턴스 생성
        assertNotNull(study); // 값이 null인지 확인
        System.out.println("create");
    }

    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study_again() {
        System.out.println("create1");
    }

    /*
    테스트 시작 전 딱 한 번 실행
    static method로 정의 => 그렇지 않으면 JUnitException 발생
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    /*
    테스트 종료 후 딱 한 번 실행 => static method로 정의
     */
    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    /*
    각 테스트 시작 전 실행
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    /*
    각 테스트 종료 후 실행
     */
    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }
}