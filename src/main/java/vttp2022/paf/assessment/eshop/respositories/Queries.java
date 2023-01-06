package vttp2022.paf.assessment.eshop.respositories;

public class Queries {

    public static final String SQL_SELECT_CUSTOMER_BY_NAME = "select name from eshop.customers where name = ?";
    public static final String SQL_INSERT_ORDER = "insert into estore.orders(orderId, deliveryId, name) values (?,?,?)";
}
