package com.eojjeol.dev.member.repository;

import com.eojjeol.dev.entity.member.Member;
import com.eojjeol.dev.entity.member.QMember;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.eojjeol.dev.entity.member.QMember.member;

@RequiredArgsConstructor
public class MemberQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Member findMemberById(Long id) {
        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.id.eq(id))
                .fetchOne();
        return findMember;
    }

    public List<Member> findPoint10000(Pageable pageable){
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.point.eq(10000))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return result;
    }


}
