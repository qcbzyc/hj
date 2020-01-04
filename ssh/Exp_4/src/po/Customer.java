
package po;

import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable {
    private Integer id;
    private String cname;//客户名称
    private String bank;//银行帐号
    private String phone;//电话号码
    private Set orders = new HashSet();//关联另外一个类
    public Customer() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Set getOrders() {
        return orders;
    }
    public void setOrders(Set orders) {
        this.orders = orders;
    }
}
