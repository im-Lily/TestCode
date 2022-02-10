package com.whiteship.javatest.member;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);
}
