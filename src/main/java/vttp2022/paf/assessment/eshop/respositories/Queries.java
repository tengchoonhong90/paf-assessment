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
    public static final String SQL_SELECT_ORDER_AND_ORDER_STATUS_AND_NAME_BY_ORDER_ID = "select name, address, email, orderId, item, quantity from customers inner join orders on customers.name = orders.name inner join items on orders.orderId = items.orderId where orders.orderId = ? group by orderId asc;";

    /*
    update order_status
    set order_id = ?, delivery_id = ?, status = ?, status_update = ?
    where order_id = ?
     */
    public static final String SQL_UPDATE_ORDER_STATUS_AFTER_SUCCESSFUL_DISPATCH="update order_status set order_id = ?, delivery_id = ?, status = ?, status_update = ? where order_id = ?";

    /*
    update order_status
    set order_id = ?, status = "pending", status_update = ?
    where order_id = ?
     */
    public static final String SQL_UPDATE_ORDER_STATUS_AFTER_UNSUCCESSFUL_DISPATCH = "update order_status set order_id = ?, status = 'pending', status_update = ? where order_id = ?";

    /*
    select count(name)
    from orders
    inner join order_status
    on orders.orderId = order_status.order_id
    where order_status.status = 'pending'
     */

    public static final String SQL_COUNT_ALL_PENDING_ORDERS_BY_CUSTOMER_NAME = "select count(name) from orders inner join order_status on orders.orderId = order_status.order_id where order_status.status = 'pending'";

    /*
    select count(name)
    from orders
    inner join order_status
    on orders.orderId = order_status.order_id
    where order_status.status = 'dispatched'
     */

    public static final String SQL_COUNT_ALL_DISPATCHED_ORDERS_BY_CUSTOMER_NAME = "select count(name) from orders inner join order_status on orders.orderId = order_status.order_id where order_status.status = 'dispatched'";

}
