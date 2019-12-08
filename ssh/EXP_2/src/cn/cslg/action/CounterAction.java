package cn.cslg.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CounterAction extends ActionSupport {

    public String excute() {
        ActionContext ac=ActionContext.getContext();
        int counter = 1;
        if(ac.getSession().get("counter")!=null){
            counter=Integer.parseInt(String.valueOf(ac.getSession().get("counter")));
            counter++;
        }
        ac.getSession().put("counter", counter);
        return SUCCESS;
    }

}
