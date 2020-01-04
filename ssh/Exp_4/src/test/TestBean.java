package test;

import dao.ManyManyDao;
import dao.OneManyDao;
import dao.OneOneDao;
import po.*;

import java.util.Random;
import java.util.Set;

public class TestBean {
    OneOneDao dao = new OneOneDao();
    OneManyDao manydao = new OneManyDao();
    Random rnd = new Random();
    ManyManyDao manyManyDao = new ManyManyDao();


    //添加会员信息
    public void addCompany(){
        Company company = new Company();
        Login login = new Login();
        login.setLoginname("QQ");
        login.setLoginpwd("123");
        company.setCompanyname("清华大学出版社");
        company.setLinkman("白立军");
        company.setTelephone("010-60772015");
        company.setEmail("bailj@163.com");
        //PO对象之间相互设置关联关系
        login.setCompany(company);
        company.setLogin(login);
        dao.addCompany(company);
    }
    //获取会员信息
    public Company loadCompany(Integer id){
        return dao.loadCompany(id);
    }

    //添加客户信息
    public void addClient(){
        Client client = new Client();
        Address address = new Address();
        address.setProvince("北京市");
        address.setCity("北京市");
        address.setStreet("清华园");
        address.setZipcode("100084");
        client.setClientname("李想");
        client.setPhone("010-56565566");
        client.setEmail("lixiang@163.com");
        //PO对象之间相互设置关联关系
        address.setClient(client);
        client.setAddress(address);
        dao.addClient(client);
    }
    //获取客户信息
    public Client loadClient(Integer id){
        return dao.loadClient(id);
    }

    public void addCustomer(){
        Customer customer = new Customer();
        customer.setCname("清华大学出版社");
        customer.setBank("9559501012356789");
        customer.setPhone("010-62772015");
        manydao.addCustomer(customer);
    }

    public Customer loadCustomer(Integer id){
        return manydao.loadCustomer(id);
    }

    public void addItem(String itemno,String itemname){
        Items item = new Items();
        item.setItemno(itemno);
        item.setItemname(itemname);
        manyManyDao.addItems(item);
    }

    public void addOrder(String orderno, Double money, Set items){
        Orders order = new Orders();
        order.setOrderno(orderno);
        order.setMoney(money);
        order.setItems(items);
        manyManyDao.addOrders(order);
    }


    public Items loadItems(Integer id){
        return manyManyDao.loadItems(id);
    }

    public Orders loadOrders(Integer id){
        return manyManyDao.loadOrders(id);
    }




}
