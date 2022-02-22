package com.whiteship.javatest.study;

import com.whiteship.javatest.domain.Member;
import com.whiteship.javatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
mock 객체: 구현체가 완성되지 않았거나,
구현체가 있지만 서비스에 대한 코드만 테스트하고 싶을 때 사용
 */
@ExtendWith(MockitoExtension.class) // mock 어노테이션 사용 시 mock 객체 생성 가능
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {
        // mock 메서드를 사용해서 인터페이스나 객체를 mock 객체로 만들 수 있음
//        MemberService memberService = mock(MemberService.class);
//        StudyRepository studyRepository = mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("test@gmail.com");
    }
}