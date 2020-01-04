
package po;

import java.io.Serializable;
import java.util.*;

public class Items implements Serializable{
    private Integer id;
    private String itemno;//商品号
    private String itemname;//商品名称  
    private Set orders = new HashSet();
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getItemno() {
        return itemno;
    }
    public void setItemno(String itemno) {
        this.itemno = itemno;
    }
    public String getItemname() {
        return itemname;
    }
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public Set getOrders() {
        return orders;
    }
    public void setOrders(Set orders) {
        this.orders = orders;
    }
}
