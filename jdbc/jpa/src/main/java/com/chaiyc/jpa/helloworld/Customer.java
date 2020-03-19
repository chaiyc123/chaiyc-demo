package com.chaiyc.jpa.helloworld;


import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name="JPA_CUSTOMERS")
public class Customer {

    private Integer id;

    private String lastName;

    private String email;
    private int age;

    private Date createDate;

    private Date birthday;


    /*   table 得主键生成策略
    @TableGenerator(name = "ID_GENERATOR",
        table = "jpa_id_generator",
        pkColumnName = "PK_NAME",
        pkColumnValue = "CUSTOMER_ID",
        valueColumnName = "PK_VALUE",
        allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "ID_GENERATOR")
    */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="LAST_NAME",length=50,nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", createDate=" + createDate +
                ", birthday=" + birthday +
                '}';
    }
}
