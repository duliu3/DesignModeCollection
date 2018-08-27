package cn.eternal.designmode.visitor;

import java.util.ArrayList;

import cn.eternal.designmode.DesignMode;
import cn.eternal.libprocessor.Design;

@Design
public class VisitMode extends DesignMode {
    @Override
    public void process() {
        Engineer engineer = new Engineer();
        engineer.name = "小红";
        engineer.salary = "薪水 10000";
        engineer.skill = "制造火箭";

        Engineer engineer2 = new Engineer();
        engineer2.name = "小明";
        engineer2.salary = "薪水 15000";
        engineer2.skill = "制造原子弹";

        Manager manager = new Manager();
        manager.name = "大王";
        manager.demand = "扩招人手";
        manager.progress = "项目进度：30%";

        Manager manager2 = new Manager();
        manager2.name = "二王";
        manager2.demand = "团建";
        manager2.progress = "项目进度：60%";

        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(engineer);
        staffs.add(engineer2);
        staffs.add(manager);
        staffs.add(manager2);

        System.out.println("————————CEO 视察员工————————");
        for (int i=0;i<staffs.size();i++) {
            Staff staff = staffs.get(i);
            staff.accept(new CEO());
        }

        System.out.println("————————CTO 视察员工————————");
        for (int i=0;i<staffs.size();i++) {
            Staff staff = staffs.get(i);
            staff.accept(new CTO());
        }
    }

    @Override
    public String getName() {
        return "访问者模式";
    }
}
