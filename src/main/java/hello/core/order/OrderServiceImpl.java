package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final 붙은 거 생성자 만들어줌
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountpolicy();
    // DIP 지킴
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    필드 주입
//    @Autowired private final MemberRepository memberRepository;
//    @Autowired private final DiscountPolicy discountPolicy;

//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

//    // @RequiredArgsConstructor로 대체
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

//    일반 메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // for test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
