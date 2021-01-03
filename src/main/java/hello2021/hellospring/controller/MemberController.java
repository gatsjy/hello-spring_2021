package hello2021.hellospring.controller;

import hello2021.hellospring.domain.Member;
import hello2021.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Gatsjy
 * @since 2021-01-03
 * realize dreams myself
 * Blog : https://blog.naver.com/gkswndks123
 * Github : https://github.com/gatsjy
 */

@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링 컨테이너에 하나만 등록해 놓는다.
    // 스프링 컨테이너가 뜰 때 생성한다.
    // Parameter 0 of constructor in hello2021.hellospring.controller.MemberController required a bean of type 'hello2021.hellospring.service.MemberService' that could not be found.
    // 의존관계를 주입하기 위해서 어노테이션을 작성해줘야한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
