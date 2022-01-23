package study.querydsl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.entity.Member;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTestRepositoryTest {

    @Autowired
    private MemberTestRepository memberTestRepository;

    @Test
    public void applyPagination2Test() {
        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setAgeGoe(35);
        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        PageRequest pageRequest = PageRequest.of(0, 3);


        Page<Member> results = memberTestRepository.applyPagination2(condition, pageRequest);

        for (Member result : results) {
            System.out.println("Member = " + result);
        }
    }


}