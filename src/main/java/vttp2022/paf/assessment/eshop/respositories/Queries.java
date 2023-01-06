package vttp2022.paf.assessment.eshop.respositories;

public class Queries {

    public static final String SQL_SELECT_CUSTOMER_BY_NAME = "select name from customers where name = ?;";
    public static final String SQL_INSERT_ORDER = "insert into orders(orderId, name) values (?,?);";
    public static final String SQL_INSERT_ITEM = "insert into items(orderId, item, quantity) values (?,?,?);";

    /*
    select name, address, email, orderId, item, quantity 
    from customers
    inner join orders
    on customers.name = orders.name
    inner join items
    on orders.orderId = items.orderId
    where orders.orderId = ?
    group by orderId asc;
    */
    public static final String SQL_SELECT_ORDER = "select name, address, email, orderId, item, quantity from customers inner join orders on customers.name = orders.name inner join items on orders.orderId = items.orderId where orders.orderId = ? group by orderId asc;";
}
