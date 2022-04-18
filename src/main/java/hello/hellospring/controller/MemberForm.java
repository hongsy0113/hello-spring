package hello.hellospring.controller;

public class MemberForm {
    // 이 name과 form.html의 name과 값이 매치되어서 들어온다.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
