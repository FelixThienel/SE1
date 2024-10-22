package org.hbrs.se1.ws24.exercises.uebung3;

public class Client {
    public void test(Container container) {
        MemberView view = new MemberView();
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);
        Member m3 = new ConcreteMember(3);
        try {
            container.addMember(m1);
            container.addMember(m2);
            container.addMember(m3);
            view.dump(container.getCurrentList());
        } catch (Exception ignored) {
        }
    }
}
