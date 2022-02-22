package com.whiteship.javatest.study;

import com.whiteship.javatest.domain.Study;
import com.whiteship.javatest.member.MemberService;

import java.lang.reflect.Member;
import java.util.Optional;

public class StudyService {

    private final MemberService memberService;

    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        // 멤버 조회 시 없으면 예외 발생, 있으면 멤버 저장
        if (member.isPresent()) {
            study.setOwnerId(memberId);
        } else {
            throw new IllegalArgumentException("Membmer dosen't exist for id: '" + memberId + "'");
        }
        return studyRepository.save(study);
    }
}
