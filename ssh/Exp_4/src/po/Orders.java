
package po;

import java.io.Serializable;
import java.util.*;

public class Orders implements Serializable{
    private Integer id;
    private String orderno;
    private Double money;
    private Set items = new HashSet();
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderno() {
        return orderno;
    }
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public Set getItems() {
        return items;
    }
    public void setItems(Set items) {
        this.items = items;
    }
}
