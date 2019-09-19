package bean;

public class Student {
    private String num;
    private String name;
    private String sex;
    private String cla;
    private double mark;

    public Student(String num, String name, String sex, String cla, double mark) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.cla = cla;
        this.mark = mark;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
