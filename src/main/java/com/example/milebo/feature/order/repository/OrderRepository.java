package com.example.milebo.feature.order.repository;

import com.example.milebo.feature.order.model.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository <Orders, String> {
    // Doanh thu hôm nay
    @Query(value = """
        SELECT ISNULL(SUM(total),0)
        FROM Orders
        WHERE status = 'PAID'
          AND CAST(date AS date) = CAST(GETDATE() AS date)
    """, nativeQuery = true)
    BigDecimal getTodayRevenue();

    // Số đơn hôm nay
    @Query(value = """
        SELECT COUNT(*)
        FROM Orders
        WHERE CAST(date AS date) = CAST(GETDATE() AS date)
    """, nativeQuery = true)
    Long countTodayOrders();

    // 5 đơn mới nhất
    @Query("SELECT o FROM Orders o ORDER BY o.date DESC")
    List<Orders> findRecentOrders(Pageable pageable);

    // Doanh thu 7 ngày gần nhất
    @Query(value = """
        SELECT CAST(date AS date) AS day, SUM(total) AS revenue
        FROM Orders
        WHERE status = 'PAID'
          AND date >= DATEADD(day, -6, CAST(GETDATE() AS date))
        GROUP BY CAST(date AS date)
        ORDER BY day
    """, nativeQuery = true)
    List<Object[]> getRevenueLast7Days();
}


