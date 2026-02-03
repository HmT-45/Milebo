package com.example.milebo.feature.admin.dashboard;

//package com.example.Milebo.controller.admin;
//
//import com.example.milebooo.feature.order.repository.OrderRepository;
//import com.example.milebooo.feature.product.repository.ProductRepository;
//import com.example.milebooo.feature.user.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminDashboardController {
//
//    @Autowired
//    private OrderRepository orderRepo;
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Autowired
//    private ProductRepository productRepo;
//
//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//
//        // KPI
//        model.addAttribute("todayRevenue", orderRepo.getTodayRevenue());
//        model.addAttribute("todayOrders", orderRepo.countTodayOrders());
//        model.addAttribute("newCustomers", userRepo.countNewCustomersToday());
//        model.addAttribute("lowStock", productRepo.countLowStockProducts());
//
//        // 5 đơn mới nhất
//        Pageable top5 = PageRequest.of(0, 5);
//        model.addAttribute("recentOrders", orderRepo.findRecentOrders(top5));
//
//        // ===== CHART DATA =====
//        List<Object[]> raw = orderRepo.getRevenueLast7Days();
//
//        List<String> labels = new java.util.ArrayList<>();
//        List<Double> data = new java.util.ArrayList<>();
//
//        for (Object[] r : raw) {
//            labels.add(r[0].toString());                  // ngày
//            data.add(((Number) r[1]).doubleValue());      // doanh thu
//        }
//
//        model.addAttribute("labels", labels);
//        model.addAttribute("data", data);
//
//        return "admin/dashboard";
//    }
//}

