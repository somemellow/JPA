package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class orderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model){
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items",items);

        return "order/orderForm";
    }
    @PostMapping("/order")
    public String order(@RequestParam("memeberId") Long memberId,
                        @RequestParam("itmeId") Long itemId,
                        @RequestParam("count") int count){
        //식별자만 넘기고 비즈니스 로직은 서비스에서 처리하도록 하면 영속컨테스트가 존재한 상태로 조회 가능해진다.
        orderService.order(memberId,itemId, count);
        return "redirect:/orders";
    }
}
