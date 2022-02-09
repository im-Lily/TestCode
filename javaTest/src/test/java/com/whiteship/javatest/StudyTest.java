package com.whiteship.javatest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
클래스 레벨에서 테스트 이름 설정이 가능한데 ReplaceUnderscores.Class => _로 표시한 모든 부분은 공백으로 처리
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기 ╯°□°）╯")
        // 테스트 이름 설정 가능 => DisplayNameGeneration보다 우선순위가 높음
    void create_new_study() {
        Study study = new Study(10); // study 인스턴스 생성
        // assertAll에 포함되면 테스트 실패 시 한 번에 파악할 수 있음
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다."), // 람다식으로 표현할 경우 문자 연산을 성공 시에만 수행하기 때문에 성능 향상
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 10명입니다.")
        );
        System.out.println("study.getLimit() = " + study.getLimit());
        assertThat(study.getLimit()).isGreaterThan(0);
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