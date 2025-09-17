package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository
    extends PagingAndSortingRepository<Order, Long> {
    @Query(
        value = "select order " +
        "from Order order " +
        "where(:orderId is null or order.orderId = :orderId)"
    )
    Order orderStatusTracking(Long orderId);

    @Query(
        value = "select order " +
        "from Order order " +
        "where(:orderId is null or order.orderId = :orderId)"
    )
    Order orderDetails(Long orderId);

    @Query(
        value = "select order " +
        "from Order order " +
        "where(:deliveryRiderId is null or order.deliveryRiderId = :deliveryRiderId)"
    )
    List<Order> deliveryHistoryList(Long deliveryRiderId, Pageable pageable);
}
