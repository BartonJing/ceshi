package cn.com.jrr;

/**
 * Created by Administrator on 2016/3/30.
 */
public class Student {
    private Integer id;
    private String code;
    private String name;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student() {

    }

    public Student(String code, String name, String sex, String school) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.school = school;
    }

    public Student(Integer id, String code, String name, String sex, String school) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
