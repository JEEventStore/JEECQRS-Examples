package org.jeeventstore.example.quickstart.domain.model.order;

/**
 *
 */
public interface OrderRepository {

    /**
     * Retrieves the order with the given identity.
     * Must exist.
     * 
     * @param orderId  the id of the order to retrieve
     * @return   the order
     */
    Order orderOfIdentity(OrderId orderId);

    /**
     * Adds an order to the repository.
     *
     * @param order the order to add
     * @param commitId  unique id for this commit
     */
    void add(Order order, String commitId);

    /**
     * Saves an order.
     * 
     * @param order the order to save
     * @param commitId  unique id for this commit
     */
    void save(Order order, String commitId);
    
}
