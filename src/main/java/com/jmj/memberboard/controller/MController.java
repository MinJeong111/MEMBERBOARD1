package com.jmj.memberboard.controller;

import com.jmj.memberboard.dto.MEMBER;
import com.jmj.memberboard.service.MService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MController {

    @Autowired
    private MService msvc;

    @Autowired
    private HttpSession session;

    private ModelAndView mav = new ModelAndView();

    // joinForm : 회원가입 페이지로 이동
    @RequestMapping(value="joinForm", method = RequestMethod.GET)
    public String joinForm(){
        return "joinForm";
    }

    // mJoin : 회원가입
    @RequestMapping(value="mJoin", method = RequestMethod.POST)
    public ModelAndView mJoin(@ModelAttribute MEMBER member) throws IOException {
        System.out.println(" ======= mJoin 메소드 ======= ");
        System.out.println("[1]controller : member -> " + member);

        mav = msvc.mJoin(member);
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // loginForm : 로그인 페이지로 이동
    @RequestMapping(value="loginForm", method = RequestMethod.GET)
    public String loginForm(){
        return "loginForm";
    }

    // mLogin : 로그인
    @RequestMapping(value="mLogin", method = RequestMethod.POST)
    public ModelAndView mLogin(@ModelAttribute MEMBER member){
        System.out.println(" ======= mLogin 메소드 ======= ");
        System.out.println("[1]controller : member -> " + member);

        mav = msvc.mLogin(member);
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // logout : 로그아웃
    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(){
        session.invalidate();   // session을 초기화 하는 작업
        return "index";
    }

    // mList : 회원목록 보기
    @RequestMapping(value="mList", method = RequestMethod.GET)
    public ModelAndView mList(){
        System.out.println(" ======= mList 메소드 ======= ");
        System.out.println("[1]controller");

        mav = msvc.mList();
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // mView : 회원 상세보기
    @RequestMapping(value="mView", method = RequestMethod.GET)
    public ModelAndView mView(@RequestParam("mId") String mId){
        mav = msvc.mView(mId);
        return mav;
    }

    // mModiForm : 회원 수정 페이지로 이동
    @RequestMapping(value="mModiForm", method = RequestMethod.GET)
    public ModelAndView mModiForm(@RequestParam("mId") String mId){
        mav = msvc.mModiForm(mId);
        return mav;
    }

    // mModify : 회원 수정
    @RequestMapping(value="mModify", method = RequestMethod.POST)
    public ModelAndView mModify(@ModelAttribute MEMBER member) throws IOException {
        System.out.println(" ======= mModify 메소드 ======= ");
        System.out.println("[1]controller : member -> " + member);

        mav = msvc.mModify(member);
        System.out.println("[4]controller : mav -> " + mav);

        return mav;
    }

    // mDelete : 회원 삭제(GET방식)
    @RequestMapping(value="mDelete", method = RequestMethod.GET)
    public ModelAndView mDelete(@RequestParam("mId") String mId){
        mav = msvc.mDelete(mId);
        return mav;
    }

    // A_idoverlap
    // A_idoverlap : 아이디 중복 검사
    @RequestMapping(value="/A_idoverlap", method = RequestMethod.POST)
    public @ResponseBody String idOverlap(@RequestParam("mId") String mId) {
        //System.out.println("================= A_idoverlap =================");
        //System.out.println("[1]controller : MId -> " + MId);
        String result = msvc.idOverlap(mId);
        //System.out.println("[5]controller : result -> " + result);
        return result;
    }

}
