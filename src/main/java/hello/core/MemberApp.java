package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        기존 자바 코드
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        스프링 코드
//        Appconfig의 환경 설정 정보를 가지고 스프링이 객체를 집어넣어 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 컨테이너에서 가져옴

        Member member = new Member(1L, "memberA", Grade.VIP); // Long타입이라 뒤에 L
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
