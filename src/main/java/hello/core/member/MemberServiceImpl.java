package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository(); // dip 위반

    private final MemberRepository memberRepository; // DIP 지킴

    // memberRepository 구현체가 뭐가 들어갈지를 생성자를 통해 건네줌
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
