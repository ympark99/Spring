package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService2") // 읾의 이름 지정, 기본은 첫글자만 소문자로 바뀌어서 됨
public class MemberServiceImpl implements MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository(); // dip 위반

    private final MemberRepository memberRepository; // DIP 지킴

    // memberRepository 구현체가 뭐가 들어갈지를 생성자를 통해 건네줌
    @Autowired // 자동 의존관계 주입, ac.getBean(MemberRepository.class); 와 같은 기능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // for test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
