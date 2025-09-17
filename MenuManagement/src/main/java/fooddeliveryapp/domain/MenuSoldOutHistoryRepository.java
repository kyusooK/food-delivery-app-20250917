package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "menuSoldOutHistories",
    path = "menuSoldOutHistories"
)
public interface MenuSoldOutHistoryRepository
    extends PagingAndSortingRepository<MenuSoldOutHistory, Long> {
    @Query(
        value = "select menuSoldOutHistory " +
        "from MenuSoldOutHistory menuSoldOutHistory " +
        "where(:menuId is null or menuSoldOutHistory.menuId = :menuId)"
    )
    List<MenuSoldOutHistory> menuSoldOutHistoryList(
        Long menuId,
        Pageable pageable
    );
}
